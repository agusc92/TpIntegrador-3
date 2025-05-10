package TpIntegrador.service.dto.estudianteCarrera.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarreraPorInscriptosResponseDTO {
    private final String nombre;
    private final Long inscriptos;


}
