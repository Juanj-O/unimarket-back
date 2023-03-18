package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LogPublicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private String descripcion;


    /// relacion con producto
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;


    /// relacion con el moderador
    @ManyToOne
    @JoinColumn(nullable = false)
    private Moderador moderador;


    ///  enumeracion de estado
    @Column(nullable = false)
    private Estado estado;

}
