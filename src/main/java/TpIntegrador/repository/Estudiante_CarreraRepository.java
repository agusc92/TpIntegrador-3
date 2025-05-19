package TpIntegrador.repository;

import TpIntegrador.domain.Carrera;
import TpIntegrador.domain.Estudiante_Carrera;
import TpIntegrador.service.dto.estudianteCarrera.response.CarreraPorInscriptosResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Estudiante_CarreraRepository extends JpaRepository<Estudiante_Carrera, Long> {

    @Query(
            "SELECT new TpIntegrador.service.dto.estudianteCarrera.response.CarreraPorInscriptosResponseDTO(ce.carrera.nombre, COUNT(ce.estudiante)) " +
                    "FROM Estudiante_Carrera ce " +
                    "GROUP BY ce.carrera.nombre " +
                    "ORDER BY COUNT(ce.estudiante) DESC"
    )
    List<CarreraPorInscriptosResponseDTO> findByRegistered();

    @Query("SELECT COUNT(ec) FROM Estudiante_Carrera ec WHERE ec.estudiante.dni = :dni AND ec.carrera.id_carrera = :idCarrera")
    int existeMatricula(@Param("dni") int dni, @Param("idCarrera") int idCarrera);

}
