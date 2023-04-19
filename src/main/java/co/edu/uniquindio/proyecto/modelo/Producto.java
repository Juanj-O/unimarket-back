package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private int unidades;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @Column(nullable = false)
    private boolean estado;


    /// crea la tabla de las imagenes
    @ElementCollection
    @Column(nullable = false)
    @ToString.Exclude
    private Map<String, String> imagen;

    ///relacion con el usuario
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;


    /// crear la relacion entre la enum categoria y producto
    @ElementCollection
    @ToString.Exclude
    private List<Categoria> categoria;


    // crear tabla intermedia entre producto y usuario
    @ManyToMany(mappedBy = "productofavorito")
    @ToString.Exclude
    private List<Usuario> usuarioF;


    /// relacion con el producto
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<LogPublicacion> logPublicacion;

    /// relacion con detalle compra
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<DetalleCompra> detalleCompra;


    /// relacion con el comentario
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Comentario> comentario;

}
