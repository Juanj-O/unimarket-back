package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
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
}
