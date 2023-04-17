package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.MetodoPago;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompraGetDTO {

    private MetodoPago metodoPago;

    private String cedulaUsuario;

    private List<DetalleCompraDTO> detalleCompraDTO;

    private float valorTotal;

    private LocalDateTime fecha;
}
