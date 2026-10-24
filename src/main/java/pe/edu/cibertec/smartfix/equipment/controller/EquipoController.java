package pe.edu.cibertec.smartfix.equipment.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import pe.edu.cibertec.smartfix.equipment.entity.Equipo;
import pe.edu.cibertec.smartfix.equipment.exception.EquipoNoEncontradoException;
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

    private boolean esUsuario(HttpServletRequest request) {
        return "USUARIO".equals(request.getAttribute("rol"));
    }

    private Long usuarioId(HttpServletRequest request) {
        return (Long) request.getAttribute("usuarioId");
    }

    // Un usuario solo ve sus propios equipos; administrador y técnico ven todos
    @GetMapping
    public ResponseEntity<List<Equipo>> listarEquipos(HttpServletRequest request) {
        if (esUsuario(request)) {
            return ResponseEntity.ok(equipoService.listarPorPropietario(usuarioId(request)));
        }
        return ResponseEntity.ok(equipoService.listarEquipos());
    }

    // Consultar un equipo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipo(@PathVariable Long id, HttpServletRequest request) {
        Equipo equipo = equipoService.obtenerEquipo(id);
        if (esUsuario(request) && !usuarioId(request).equals(equipo.getPropietarioId())) {
            throw new EquipoNoEncontradoException(id);
        }
        return ResponseEntity.ok(equipo);
    }

    // Registrar un equipo (el usuario solo puede registrarlo a su nombre)
    @PostMapping
    public ResponseEntity<Equipo> registrarEquipo(
            @Valid @RequestBody Equipo equipo, HttpServletRequest request) {
        if (esUsuario(request)) {
            equipo.setPropietarioId(usuarioId(request));
        }
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
