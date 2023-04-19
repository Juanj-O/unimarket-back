package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.MetodoPago;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {

    private MetodoPago metodoPago;

    private String cedulaUsuario;

    private List<DetalleCompraDTO> detalleCompraDTO;


}
