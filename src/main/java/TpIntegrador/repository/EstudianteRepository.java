package TpIntegrador.repository;

import TpIntegrador.domain.Estudiante;
import TpIntegrador.service.dto.estudiante.response.EstudianteResponseDTO;
import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query(
            "SELECT e " +
                    "FROM Estudiante e " +
                    "ORDER BY e.edad"
    )
    List<Estudiante> findAllByAge();

    @Query(
            "SELECT e FROM Estudiante e WHERE e.lu = :lu"
    )
    Estudiante findByLu(@Param("lu")int lu);

    @Query(

            "SELECT e " +
                    "FROM Estudiante e " +
                    "WHERE e.genero = :genero"
    )
    List<Estudiante> filterByGenre(@Param("genero")String genero);
}
