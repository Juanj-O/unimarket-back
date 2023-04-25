package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompraCreadaDTO {

    private int codigoCompra;

    private MetodoPago metodoPago;

    private String cedulaUsuario;
}
