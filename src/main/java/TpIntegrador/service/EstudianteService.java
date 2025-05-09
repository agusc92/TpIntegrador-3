package TpIntegrador.service;

import TpIntegrador.domain.Estudiante;
import TpIntegrador.repository.EstudianteRepository;
import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;
    @Transactional
    public EstudianteResponseDTO save(EstudianteRequestDTO request){

        final var estudiante = new Estudiante(request);
        final var result = this.estudianteRepository.save(estudiante);
        return new EstudianteResponseDTO(result.getDni(),result.getNombre(),result.getApellido(),result.getEdad(),result.getGenero(),result.getCiudad(),result.getLu());


    }
    @Transactional
    public List<EstudianteResponseDTO> findAllByAge() {
        return this.estudianteRepository.findAllByAge()
                .stream().map(EstudianteResponseDTO::new).toList();
    }
}
