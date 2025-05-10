package TpIntegrador.repository;

import TpIntegrador.domain.Carrera;
import TpIntegrador.service.dto.carrera.response.CarreraReporteResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {



@Query(
        "SELECT new TpIntegrador.service.dto.carrera.response.CarreraReporteResponseDTO(" +
                "c.nombre, " +
                "e.anio_inscripcion, " +
                "COUNT(e), " +
                "SUM(CASE WHEN e.anio_graduacion IS NOT NULL THEN 0 ELSE 0 END)) " +
                "FROM Estudiante_Carrera e " +
                "JOIN e.carrera c " +
                "WHERE e.anio_inscripcion IS NOT NULL " +
                "GROUP BY c.nombre, e.anio_inscripcion"
)
    public List<CarreraReporteResponseDTO> generateReportparte1();


    @Query(
            "SELECT new TpIntegrador.service.dto.carrera.response.CarreraReporteResponseDTO(" +
                    "c.nombre, " +
                    "e.anio_graduacion, " +
                    "SUM(CASE WHEN e.anio_graduacion IS NOT NULL THEN 0 ELSE 0 END), " +
                    "COUNT(e)) " +
                    "FROM Estudiante_Carrera e " +
                    "JOIN e.carrera c " +
                    "WHERE e.anio_graduacion IS NOT NULL AND e.anio_graduacion > 0 " +
                    "GROUP BY c.nombre, e.anio_graduacion"
    )
    public List<CarreraReporteResponseDTO> generateReportparte2();
}
