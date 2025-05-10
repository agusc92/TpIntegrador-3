package TpIntegrador.service.dto.carrera.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarreraReporteResponseDTO {

    private String nombreCarrera;
    private int anio;
    private long inscriptos;
    private long graduados;

    public CarreraReporteResponseDTO(String nombreCarrera, int anio, long inscriptos, long graduados) {
        this.nombreCarrera = nombreCarrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.graduados = graduados;
    }

}
