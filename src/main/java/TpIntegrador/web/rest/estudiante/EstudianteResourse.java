package TpIntegrador.web.rest.estudiante;

import TpIntegrador.service.EstudianteService;
import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudiantes")
@RequiredArgsConstructor
public class EstudianteResourse {

    @Autowired
    private final EstudianteService estudianteService;


    //Matricular estudiante
    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody @Valid EstudianteRequestDTO request ){
        final var result = this.estudianteService.save( request );
        return ResponseEntity.accepted().body( result );
    }

    //Obtener todos ordenados por edad
    @GetMapping("")
    public List<EstudianteResponseDTO> findAllByAge(){
        return this.estudianteService.findAllByAge();
    }

    //Obtener por lubreta universitaria
    @GetMapping("lu/{lu}")
    public EstudianteResponseDTO findByLu( @PathVariable int lu ){
        return this.estudianteService.findByLu( lu );
    }

    //obtener todos, filtrado por genero
    @GetMapping("genero/{genero}")
    public List<EstudianteResponseDTO> filterByGenre(@PathVariable String genero){
        return this.estudianteService.filterByGenre(genero);
    }

    //obtener por carrera y ciudad
    @GetMapping("/{carrera}/{ciudad}")
    public List<EstudianteResponseDTO> filterByCarreraCiudad(@PathVariable String carrera, @PathVariable String ciudad){
        return this.estudianteService.filterByCarreraCiudad(Integer.parseInt(carrera),ciudad);
    }
}
