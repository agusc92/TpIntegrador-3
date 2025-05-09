package TpIntegrador.repository;

import TpIntegrador.domain.Estudiante;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query(
            "SELECT e " +
                    "FROM Estudiante e " +
                    "ORDER BY e.edad"
    )
    List<Estudiante> findAllByAge();

}
