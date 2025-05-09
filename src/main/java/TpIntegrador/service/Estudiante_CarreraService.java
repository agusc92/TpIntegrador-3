package TpIntegrador.service;

import TpIntegrador.domain.Estudiante;
import TpIntegrador.domain.Estudiante_Carrera;
import TpIntegrador.repository.CarreraRepository;
import TpIntegrador.repository.EstudianteRepository;
import TpIntegrador.repository.Estudiante_CarreraRepository;
import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import TpIntegrador.service.dto.estudianteCarrera.request.Estudiante_CarreraRequestDTO;
import TpIntegrador.service.dto.estudianteCarrera.response.Estudiante_CarreraResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Estudiante_CarreraService {
    private final Estudiante_CarreraRepository estudianteCarreraRepository;
    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;

    @Transactional
    public Estudiante_CarreraResponseDTO save(Estudiante_CarreraRequestDTO request){
        final var estudiante = this.estudianteRepository.findById(Long.valueOf(request.getDni_estudiante())
        ).orElseThrow(() -> new EntityNotFoundException("estudiante no encontrada"));

        final var carrera = this.carreraRepository.findById(Long.valueOf(request.getId_carrera())
        ).orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada"));

        final var estudianteCarrera = new Estudiante_Carrera(request, estudiante,carrera);
        final var result = this.estudianteCarreraRepository.save(estudianteCarrera);
        return new Estudiante_CarreraResponseDTO(result);


    }
}
