package co.edu.uniquindio.proyecto.dto;

import jakarta.persistence.Column;

import java.util.List;

public class ProductoDTO {

    private String nombre;

    private String descripcion;

    private Float precio;

    private int unidades;

    private String cedulaUsuario;

    private List<String> imagenes;

    private List<Integer> categorias;

}
