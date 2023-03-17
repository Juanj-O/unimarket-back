package co.edu.uniquindio.proyecto.modelo;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String nombre;



    // crear tabla intermedia entre categoria y producto
    @ManyToMany(mappedBy = "categoria")
    private List<Producto> producto;


}
