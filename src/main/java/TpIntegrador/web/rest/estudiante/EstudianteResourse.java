package TpIntegrador.web.rest.estudiante;

import TpIntegrador.service.EstudianteService;
import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudiantes")
@RequiredArgsConstructor
public class EstudianteResourse {

    private final EstudianteService estudianteService;


    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody @Valid EstudianteRequestDTO request ){
        final var result = this.estudianteService.save( request );
        return ResponseEntity.accepted().body( result );
    }
    @GetMapping("")
    public List<EstudianteResponseDTO> findAllByAge(EstudianteRequestDTO request){
        return this.estudianteService.findAllByAge();
    }

}
