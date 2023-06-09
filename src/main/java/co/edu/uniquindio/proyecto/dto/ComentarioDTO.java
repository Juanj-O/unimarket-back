package co.edu.uniquindio.proyecto.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDTO {

    private String mensaje;

    private int codigoProducto;

    private String cedulaUsuario;
}
