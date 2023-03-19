package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.MetodoPago;
import jakarta.persistence.Column;

import java.util.List;

public class CompraDTO {

    private MetodoPago metodoPago;

    private String cedulaUsuario;

    private List<DetalleCompraDTO> detalleCompraDTO;


}
