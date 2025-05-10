package TpIntegrador.service;

import TpIntegrador.repository.CarreraRepository;
import TpIntegrador.repository.EstudianteRepository;
import TpIntegrador.service.dto.carrera.response.CarreraReporteResponseDTO;
import TpIntegrador.service.dto.carrera.response.CarreraResponseDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CarreraService {

    @Autowired
    private final CarreraRepository carreraRepository;

    @Transactional
    public List<CarreraReporteResponseDTO> generateReport() {
        List<CarreraReporteResponseDTO> reportes = new ArrayList<>();
        List<CarreraReporteResponseDTO> parte1 = carreraRepository.generateReportparte1();
        List<CarreraReporteResponseDTO> parte2 = carreraRepository.generateReportparte2();

        Map<String, CarreraReporteResponseDTO> reporteMap = new HashMap<>();
        // Procesar inscriptos
        for (CarreraReporteResponseDTO insc : parte1) {
            String clave = insc.getNombreCarrera() + "_" + insc.getAnio();
            reporteMap.putIfAbsent(clave, new CarreraReporteResponseDTO(insc.getNombreCarrera(), insc.getAnio(), 0L, 0L));
            reporteMap.get(clave).setInscriptos(insc.getInscriptos());
        }

// Procesar graduados
        for (CarreraReporteResponseDTO grad : parte2) {
            String clave = grad.getNombreCarrera() + "_" + grad.getAnio();
            reporteMap.putIfAbsent(clave, new CarreraReporteResponseDTO(grad.getNombreCarrera(), grad.getAnio(), 0L, 0L));
            reporteMap.get(clave).setGraduados(grad.getGraduados());
        }

// Convertir a lista ordenada
        reportes = new ArrayList<>(reporteMap.values());
        reportes.sort(Comparator
                .comparing(CarreraReporteResponseDTO::getNombreCarrera)
                .thenComparing(CarreraReporteResponseDTO::getAnio));

// Ordenar por carrera y año
        reportes.sort(Comparator
                .comparing(CarreraReporteResponseDTO::getNombreCarrera)
                .thenComparing(CarreraReporteResponseDTO::getAnio));
        return reportes;
    }
}
