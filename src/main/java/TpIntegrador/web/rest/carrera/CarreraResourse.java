package TpIntegrador.web.rest.carrera;

import TpIntegrador.service.CarreraService;
import TpIntegrador.service.Estudiante_CarreraService;
import TpIntegrador.service.dto.carrera.response.CarreraReporteResponseDTO;
import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/carreras")
@RequiredArgsConstructor

public class CarreraResourse {

    @Autowired
    CarreraService carreraService;

    @GetMapping("reporte")
    public List<CarreraReporteResponseDTO> generateReport(){
        return this.carreraService.generateReport();
    }


}
