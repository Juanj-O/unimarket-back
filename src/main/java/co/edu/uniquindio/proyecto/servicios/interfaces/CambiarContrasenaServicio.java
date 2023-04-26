package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.CambiarContrasenaDTO;

public interface CambiarContrasenaServicio {

     void recuperarPassword(String email) throws Exception;

     void cambiarContrasena(String cedula,CambiarContrasenaDTO cambiarContrasenaDTO) throws Exception;
}
