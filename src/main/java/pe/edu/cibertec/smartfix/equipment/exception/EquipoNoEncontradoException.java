
package pe.edu.cibertec.smartfix.equipment.exception;

public class EquipoNoEncontradoException extends RuntimeException {

    public EquipoNoEncontradoException(Long id) {
        super("No se encontró el equipo con ID: " + id);
    }
}
