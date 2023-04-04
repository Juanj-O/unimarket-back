package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ComentarioServicio {

    ComentarioGetDTO crearComentario(ComentarioDTO comentarioDTO);

    List<ComentarioGetDTO> listarComentariosProducto(int codigoProducto);

}
