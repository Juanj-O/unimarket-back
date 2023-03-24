package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

    ComentarioGetDTO crearComentario(ComentarioDTO comentarioDTO);

    List<ComentarioGetDTO> listarComentariosProducto(int codigoProducto);

}
