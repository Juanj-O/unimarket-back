package co.edu.uniquindio.proyecto.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CambiarContrasenaDTO {

    private String contrasena;

    private String repetirContrasena;
}
