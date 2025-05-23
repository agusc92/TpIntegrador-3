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
import java.util.Optional;

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
    Optional<Estudiante> findByLu(@Param("lu")int lu);

    @Query(

            "SELECT e " +
                    "FROM Estudiante e " +
                    "WHERE e.genero = :genero"
    )
    List<Estudiante> filterByGenre(@Param("genero")String genero);


    @Query(

            "SELECT new TpIntegrador.domain.Estudiante(ce.estudiante.nombre, ce.estudiante.apellido, ce.estudiante.edad, ce.estudiante.dni, ce.estudiante.genero, ce.estudiante.ciudad, ce.estudiante.lu) " +
                    "FROM Estudiante_Carrera ce " +
                    "WHERE ce.carrera.id_carrera = :carrera " +
                    "AND ce.estudiante.ciudad = :ciudad"
    )
    List<Estudiante>filterByCarreraCiudad(@Param("carrera")int id,@Param("ciudad") String ciudad);
}
