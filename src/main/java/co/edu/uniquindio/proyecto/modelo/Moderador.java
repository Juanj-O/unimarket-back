package co.edu.uniquindio.proyecto.modelo;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Moderador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @Column(nullable = false)
    private String contraseña;


    // relacion con el logPublicacion
    @OneToMany(mappedBy = "moderador")
    private List<LogPublicacion> logPublicacion;


}
