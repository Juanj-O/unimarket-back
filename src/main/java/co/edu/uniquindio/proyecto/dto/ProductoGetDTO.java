package co.edu.uniquindio.proyecto.dto;

import java.time.LocalDateTime;
import java.util.List;

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

    private List<String> imagenes;

    private List<Integer> categorias;

}
