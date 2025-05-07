package TpIntegrador.domain;

import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Estudiante {

    @Id
    private int dni;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int edad;

    @Column
    private String genero;

    @Column
    private String ciudad;

    @Column
    private int lu;

    @OneToMany (mappedBy = "estudiante")
    private List<Estudiante_Carrera> carreras;

    public Estudiante(String nombre, String apellido, int edad,int dni, String genero,String ciudad , int lu ) {
        this.lu = lu;
        this.ciudad = ciudad;
        this.genero = genero;
        this.edad = edad;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.carreras = new ArrayList<>();
    }

    public Estudiante(EstudianteRequestDTO request){

    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                '}';
    }
}
