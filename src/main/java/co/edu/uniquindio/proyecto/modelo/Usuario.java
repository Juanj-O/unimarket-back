package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private String cedula;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 10)
    private String contrasena;

    @Column(nullable = false)
    private boolean estado;


    /// relacion con ciudad
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    /// crear la tabla intermedia entre producto y usuario
    @ManyToMany(mappedBy = "favorito")
    private List<Producto> ProductoFav;



    /// relacion con producto
    @OneToMany(mappedBy = "usuario")
    private List<Producto> producto;


    /// relacion con la compra
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compra;


    /// relacion con el comentario
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentario;


    /// relacion con el pqrs
    @OneToMany(mappedBy = "usuario")
    private List<PQRS> pqrs;


}
