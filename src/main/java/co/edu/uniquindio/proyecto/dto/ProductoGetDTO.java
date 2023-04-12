package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {

    private int codigo;

    private LocalDateTime fechaLimite;

    private boolean estado;

    private LocalDateTime fechaCreacion;

    private String nombre;

    private String descripcion;

    private float precio;

    private int unidades;

    private String cedulaUsuario;

    private Map<String, String> imagenes;

    private List<Categoria> categorias;

}
