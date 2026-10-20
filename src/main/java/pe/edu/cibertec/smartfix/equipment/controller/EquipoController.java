
package pe.edu.cibertec.smartfix.equipment.controller;

import jakarta.validation.Valid;
import pe.edu.cibertec.smartfix.equipment.entity.Equipo;
import pe.edu.cibertec.smartfix.equipment.service.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    // Listar todos los equipos
    @GetMapping
    public ResponseEntity<List<Equipo>> listarEquipos() {
        return ResponseEntity.ok(equipoService.listarEquipos());
    }

    // Consultar un equipo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipo(@PathVariable Long id) {
        return ResponseEntity.ok(equipoService.obtenerEquipo(id));
    }

    // Registrar un equipo
    @PostMapping
    public ResponseEntity<Equipo> registrarEquipo(
            @Valid @RequestBody Equipo equipo) {
        Equipo nuevoEquipo = equipoService.registrarEquipo(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipo);
    }

    // Actualizar un equipo
    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(
            @PathVariable Long id,
            @Valid @RequestBody Equipo equipo) {
        return ResponseEntity.ok(
                equipoService.actualizarEquipo(id, equipo));
    }

    // Eliminar un equipo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        equipoService.eliminarEquipo(id);
        return ResponseEntity.noContent().build();
    }
}
