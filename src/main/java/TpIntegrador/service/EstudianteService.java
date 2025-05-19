package TpIntegrador.service;

import TpIntegrador.domain.Estudiante;
import TpIntegrador.repository.EstudianteRepository;
import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    @Autowired
    private final EstudianteRepository estudianteRepository;

    //matricular estudiante
    @Transactional
    public EstudianteResponseDTO save(EstudianteRequestDTO request){
        final var estudiantefind = this.estudianteRepository.findById(Long.valueOf(request.getDni()));
        if (estudiantefind.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format("El estudiante con DNI %s ya está inscrito.", request.getDni()));


        }

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
        Estudiante estudiante = this.estudianteRepository.findByLu(lu)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("No se encontró ningún estudiante con LU %d.", lu)));
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
