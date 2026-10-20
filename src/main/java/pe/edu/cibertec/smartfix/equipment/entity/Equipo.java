
package pe.edu.cibertec.smartfix.equipment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del equipo es obligatorio")
    @Size(max = 100, message = "El nombre no debe superar los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El tipo de equipo es obligatorio")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String tipo;

    @NotBlank(message = "La marca es obligatoria")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String marca;

    @Size(max = 100)
    @Column(length = 100)
    private String modelo;

    @Size(max = 100)
    @Column(name = "numero_serie", length = 100)
    private String numeroSerie;

    @NotBlank(message = "El estado del equipo es obligatorio")
    @Size(max = 30)
    @Column(nullable = false, length = 30)
    private String estado;

    @Size(max = 500)
    @Column(length = 500)
    private String descripcion;
}
