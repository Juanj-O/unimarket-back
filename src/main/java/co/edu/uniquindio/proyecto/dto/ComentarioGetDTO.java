package co.edu.uniquindio.proyecto.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioGetDTO {

    private int codigo;

    private String mensaje;

    private int codigoProducto;

    private String cedulaUsuario;

    private LocalDateTime fechaCreacion;


}
