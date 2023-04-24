package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class PQRS implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private LocalDateTime fecha;


    /// relacion con el usuario
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;


    /// relacion con la compra
    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compra;

    public PQRS(String mensaje, LocalDateTime fecha, Usuario usuario, Compra compra) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.usuario = usuario;
        this.compra = compra;
    }
}
