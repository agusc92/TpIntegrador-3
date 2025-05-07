package TpIntegrador.service.dto.estudiante.response;

import TpIntegrador.domain.Estudiante;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EstudianteResponseDTO {
    private final int dni;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String genero;
    private final String ciudad;
    private final int lu;

    public EstudianteResponseDTO(Estudiante estudiante) {
        this.dni = estudiante.getDni();
        this.nombre = estudiante.getNombre();
        this.apellido = estudiante.getApellido();
        this.edad = estudiante.getEdad();
        this.genero = estudiante.getGenero();
        this.ciudad = estudiante.getCiudad();
        this.lu = estudiante.getLu();
    }
}
