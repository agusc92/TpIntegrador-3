package TpIntegrador.service.dto.estudiante.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
public class EstudianteRequestDTO {

    @NotNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;
    private int lu;
}
