package TpIntegrador.service.dto.estudianteCarrera.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
public class Estudiante_CarreraRequestDTO {


    private int anio_inscripcion;
    private int anio_graduacion;
    private int antiguedad;
    private int id_carrera;
    private int dni_estudiante;
}
