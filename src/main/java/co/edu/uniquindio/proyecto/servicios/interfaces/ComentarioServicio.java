package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ActualizarComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ComentarioServicio {

    Comentario crearComentario(ComentarioDTO comentarioDTO);

    List<ComentarioGetDTO> listarComentariosProducto(int codigoProducto);

    Comentario actualizarComentario(ActualizarComentarioDTO actualizarComentarioDTO);
}
