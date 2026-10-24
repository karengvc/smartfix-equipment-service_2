package pe.edu.cibertec.smartfix.equipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.smartfix.equipment.entity.Equipo;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findByPropietarioIdOrderByIdDesc(Long propietarioId);
}
