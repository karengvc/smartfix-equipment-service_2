
package pe.edu.cibertec.smartfix.equipment.repository;

import pe.edu.cibertec.smartfix.equipment.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
