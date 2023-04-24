package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    /// relacion con el producto
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;


    /// relacion con Usuario
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    public Comentario(String descripcion, LocalDateTime fechaCreacion, Producto producto, Usuario usuario) {
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.producto = producto;
        this.usuario = usuario;
    }
}
