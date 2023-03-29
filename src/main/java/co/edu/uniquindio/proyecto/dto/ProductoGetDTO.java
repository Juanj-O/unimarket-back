package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Categoria;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ProductoGetDTO {

    private String codigo;

    private LocalDateTime fechaLimite;

    private boolean estado;

    private LocalDateTime fechaCreacion;

    private String nombre;

    private String descripcion;

    private Float precio;

    private int unidades;

    private String cedulaUsuario;

    private Map<String, String> imagenes;

    private List<Categoria> categorias;

}
