package TpIntegrador.service.dto.estudiante.response;

import TpIntegrador.domain.Estudiante;
import TpIntegrador.domain.Estudiante_Carrera;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private List<Estudiante_Carrera> carreras;

    public EstudianteResponseDTO(Estudiante estudiante) {
        this.dni = estudiante.getDni();
        this.nombre = estudiante.getNombre();
        this.apellido = estudiante.getApellido();
        this.edad = estudiante.getEdad();
        this.genero = estudiante.getGenero();
        this.ciudad = estudiante.getCiudad();
        this.lu = estudiante.getLu();
        this.carreras = new ArrayList<>();
    }

}
