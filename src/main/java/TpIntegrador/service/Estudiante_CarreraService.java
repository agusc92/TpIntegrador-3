package TpIntegrador.service;

import TpIntegrador.domain.Estudiante_Carrera;
import TpIntegrador.repository.CarreraRepository;
import TpIntegrador.repository.EstudianteRepository;
import TpIntegrador.repository.Estudiante_CarreraRepository;
import TpIntegrador.service.dto.carrera.response.CarreraResponseDTO;
import TpIntegrador.service.dto.estudianteCarrera.request.Estudiante_CarreraRequestDTO;
import TpIntegrador.service.dto.estudianteCarrera.response.CarreraPorInscriptosResponseDTO;
import TpIntegrador.service.dto.estudianteCarrera.response.Estudiante_CarreraResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Estudiante_CarreraService {
    @Autowired
    private final Estudiante_CarreraRepository estudianteCarreraRepository;

    @Autowired
    private final EstudianteRepository estudianteRepository;

    @Autowired
    private final CarreraRepository carreraRepository;

    //matricular estudiante en una carrera
    @Transactional
    public Estudiante_CarreraResponseDTO save(Estudiante_CarreraRequestDTO request){



        final var estudiante = this.estudianteRepository.findById(Long.valueOf(request.getDni_estudiante())
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("No se encontró ningún estudiante con DNI %d.", request.getDni_estudiante())));

        final var carrera = this.carreraRepository.findById(Long.valueOf(request.getId_carrera())
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("No se encontró ningúna carrera con id %d.", request.getId_carrera())));

        if (estudianteCarreraRepository.existeMatricula(estudiante.getDni(), carrera.getId_carrera()) > 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format("El estudiante con DNI %d ya está matriculado en la carrera con ID %d.", estudiante.getDni(), carrera.getId_carrera()));
        }
        final var estudianteCarrera = new Estudiante_Carrera(request, estudiante,carrera);
        final var result = this.estudianteCarreraRepository.save(estudianteCarrera);
        return new Estudiante_CarreraResponseDTO(result);


    }

    @Transactional
    public List<CarreraPorInscriptosResponseDTO> findByRegistered() {
        return this.estudianteCarreraRepository.findByRegistered();
    }
}
