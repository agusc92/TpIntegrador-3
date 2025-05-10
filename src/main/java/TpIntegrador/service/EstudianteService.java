package TpIntegrador.service;

import TpIntegrador.domain.Estudiante;
import TpIntegrador.repository.EstudianteRepository;
import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    @Transactional
    public EstudianteResponseDTO findByLu(int lu) {
        Estudiante estudiante = this.estudianteRepository.findByLu(lu);

                return new EstudianteResponseDTO(estudiante);
    }
    @Transactional
    public List<EstudianteResponseDTO> filterByGenre(String genre) {
        return this.estudianteRepository.filterByGenre(genre)
                .stream().map(EstudianteResponseDTO::new).toList();
    }

    @Transactional
    public List<EstudianteResponseDTO> filterByCarreraCiudad(String carrera, String ciudad) {
        return this.estudianteRepository.filterByCarreraCiudad(carrera,ciudad)
                .stream().map(EstudianteResponseDTO::new).toList();
    }
}
