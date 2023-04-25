package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ActualizarComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ComentarioServicio {

    Comentario crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    List<ComentarioGetDTO> listarComentariosProducto(int codigoProducto) throws Exception;

    Comentario actualizarComentario(ActualizarComentarioDTO actualizarComentarioDTO) throws Exception;
}
