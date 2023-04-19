package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoDTO {

    private String nombre;

    private String descripcion;

    private Double precio;

    private int unidades;

    private String cedulaUsuario;

    private Map<String, String> imagenes;

    private List<Categoria> categorias;

}
