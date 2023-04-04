package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioServicio {

    String registarUsuario(UsuarioDTO usuarioDTO) throws Exception;

    String actualizarUsuario(String cedula, UsuarioDTO usuarioDTO ) throws Exception;

    String eliminiarUsuario(String cedula) throws Exception;

    UsuarioGetDTO obtenerUsuarioCodigo(String cedula)throws Exception;

    Usuario obtener(String cedula) throws Exception;




}
