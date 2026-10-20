
package pe.edu.cibertec.smartfix.equipment.service;

import pe.edu.cibertec.smartfix.equipment.entity.Equipo;
import pe.edu.cibertec.smartfix.equipment.exception.EquipoNoEncontradoException;
import pe.edu.cibertec.smartfix.equipment.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipo> listarEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo obtenerEquipo(Long id) {
        return equipoRepository.findById(id)
                .orElseThrow(() ->
                        new EquipoNoEncontradoException(id));
    }


    public Equipo registrarEquipo(Equipo equipo) {
        equipo.setId(null);
        return equipoRepository.save(equipo);
    }

    public Equipo actualizarEquipo(Long id, Equipo datos) {
        Equipo equipo = obtenerEquipo(id);

        equipo.setNombre(datos.getNombre());
        equipo.setTipo(datos.getTipo());
        equipo.setMarca(datos.getMarca());
        equipo.setModelo(datos.getModelo());
        equipo.setNumeroSerie(datos.getNumeroSerie());
        equipo.setEstado(datos.getEstado());
        equipo.setDescripcion(datos.getDescripcion());

        return equipoRepository.save(equipo);
    }

    public void eliminarEquipo(Long id) {
        Equipo equipo = obtenerEquipo(id);
        equipoRepository.delete(equipo);
    }
}
