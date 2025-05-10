package TpIntegrador.service.dto.carrera.response;

import TpIntegrador.domain.Carrera;
import TpIntegrador.domain.Estudiante;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarreraResponseDTO {

    private String nombre;
    private int duracion;

    public CarreraResponseDTO(Carrera carrera) {
        this.nombre = carrera.getNombre();
        this.duracion = carrera.getDuracion();
    }
}

