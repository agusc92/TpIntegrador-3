package TpIntegrador.service;

import TpIntegrador.domain.Estudiante;
import TpIntegrador.service.dto.estudiante.request.EstudianteRequestDTO;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    @Transactional
    public EstudianteResponseDTO save(EstudianteRequestDTO request){
        final var estudiante = new Estudiante(request);
    }
}
