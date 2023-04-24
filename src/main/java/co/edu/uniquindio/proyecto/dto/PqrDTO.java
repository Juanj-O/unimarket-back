package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PqrDTO {

    private String cedulaUsuario;

    private Integer codigoFactura;

    private String mensaje;
}
