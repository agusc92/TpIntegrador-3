package TpIntegrador.service.dto.estudianteCarrera.response;

import TpIntegrador.domain.Estudiante_Carrera;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Estudiante_CarreraResponseDTO {
    private final int id_estudiante_carrera;
    private final int anio_inscripcion;
    private final int anio_graduacion;
    private final int antiguedad;
    private final String id_carrera;
    private final int dni_estudiante;

    public Estudiante_CarreraResponseDTO(Estudiante_Carrera eC) {
        this.id_estudiante_carrera = eC.getId_estudiante_carrera();
        this.anio_inscripcion = eC.getAnio_inscripcion();
        this.anio_graduacion = eC.getAnio_graduacion();
        this.antiguedad = eC.getAntiguedad();
        this.id_carrera = eC.getCarrera().getNombre();
        this.dni_estudiante = eC.getEstudiante().getDni();
    }
}


