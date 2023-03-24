package co.edu.uniquindio.proyecto.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioGetDTO {

    private String cedula;

    private String nombreCompleto;

    private String telefono;

    private String direccion;

    private String email;
}
