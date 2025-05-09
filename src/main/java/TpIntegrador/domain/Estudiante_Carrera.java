package TpIntegrador.domain;

import TpIntegrador.service.dto.estudianteCarrera.request.Estudiante_CarreraRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Estudiante_Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estudiante_carrera;

    @Column (nullable = false)
    private int anio_inscripcion;

    @Column
    private int anio_graduacion;

    @Column
    private int antiguedad;

    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn (name = "dni_estudiante")
    private Estudiante estudiante;

    @ManyToOne ( fetch = FetchType.LAZY )
    @JoinColumn (name = "id_carrera")
    private Carrera carrera;

    public Estudiante_Carrera(Estudiante_CarreraRequestDTO request,Estudiante estudiante, Carrera carrera) {

        this.anio_inscripcion = request.getAnio_inscripcion();
        this.anio_graduacion = request.getAnio_graduacion();
        this.antiguedad = request.getAntiguedad();
        this.estudiante = estudiante;
        this.carrera = carrera;
    }
}
