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
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(nullable = false)
    private LocalDateTime fecha;

    ///  enumeracion de metodoPago
    @Column(nullable = false)
    private MetodoPago metodoPago;

    /// relacion con usuario
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;


    //// relacion con detalle compra
    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalleCompra;


    /// relacion con el pqrs
    @OneToMany(mappedBy = "compra")
    private List<PQRS> pqrs;

}
