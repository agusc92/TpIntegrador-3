package TpIntegrador.web.rest.estudianteCarrera;

import TpIntegrador.service.Estudiante_CarreraService;
import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import TpIntegrador.service.dto.estudianteCarrera.request.Estudiante_CarreraRequestDTO;
import TpIntegrador.service.dto.estudianteCarrera.response.CarreraPorInscriptosResponseDTO;
import TpIntegrador.service.dto.estudianteCarrera.response.Estudiante_CarreraResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudiante_carrera")
@RequiredArgsConstructor
public class Estudiante_CarreraResourse {

    @Autowired
    private final Estudiante_CarreraService estudianteCarreraService;

    //matricular un estudiante
    @PostMapping("")
    public ResponseEntity<Estudiante_CarreraResponseDTO> save(@RequestBody @Valid Estudiante_CarreraRequestDTO request ){
        final var result = this.estudianteCarreraService.save( request );
        return ResponseEntity.accepted().body( result );
    }

    // carreras por inscriptos
    @GetMapping("registered")
    public List<CarreraPorInscriptosResponseDTO> findByRegistered(){
        return this.estudianteCarreraService.findByRegistered();
    }

}
