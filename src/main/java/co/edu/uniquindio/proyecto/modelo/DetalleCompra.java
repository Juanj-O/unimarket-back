package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private Double precio;



    /// relacion con el producto
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;


    /// relacion con la compra
    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compra;




}
