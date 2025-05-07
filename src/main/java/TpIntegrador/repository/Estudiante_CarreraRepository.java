package TpIntegrador.repository;

import TpIntegrador.domain.Estudiante_Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Estudiante_CarreraRepository extends JpaRepository<Estudiante_Carrera, Long> {

}
