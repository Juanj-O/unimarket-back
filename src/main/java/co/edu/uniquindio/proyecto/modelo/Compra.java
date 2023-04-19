package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    @ToString.Exclude
    private List<DetalleCompra> detalleCompra;


    /// relacion con el pqrs
    @OneToMany(mappedBy = "compra")
    @ToString.Exclude
    private List<PQRS> pqrs;


    public Compra(Double valorTotal, LocalDateTime fecha, MetodoPago metodoPago, Usuario usuario) {
        this.valorTotal = valorTotal;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.usuario = usuario;
    }

    public Compra(Double valorTotal, LocalDateTime fecha, MetodoPago metodoPago, Usuario usuario, List<DetalleCompra> detalleCompra) {
        this.valorTotal = valorTotal;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.usuario = usuario;
        this.detalleCompra = detalleCompra;
    }
}
