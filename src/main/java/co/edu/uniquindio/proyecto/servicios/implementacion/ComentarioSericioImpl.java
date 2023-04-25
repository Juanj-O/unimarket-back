package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ActualizarComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioSericioImpl implements ComentarioServicio {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Override
    public Comentario crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        Usuario usuario = usuarioRepo.findById(comentarioDTO.getCedulaUsuario()).orElse(null);
        if (usuario == null){
            throw new Exception("El Usuario no existe.");
        }
        Producto producto = productoRepo.findById(comentarioDTO.getCodigoProducto()).orElse(null);

        if(producto == null ){
            throw new Exception("El Producto no existe.");
        }

        Comentario comentario = comentarioRepo.save(new Comentario(comentarioDTO.getMensaje() , LocalDateTime.now() , producto , usuario ));

        return comentario;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariosProducto(int codigoProducto) throws Exception{

        Producto producto = productoRepo.findById(codigoProducto).orElse(null);

        if(producto == null ){
            throw new Exception("El Producto no existe.");
        }

        List<Comentario> listaComentarios = comentarioRepo.obtenerComentarios(codigoProducto);
        List<ComentarioGetDTO> listaComentariosGetDto = new ArrayList<ComentarioGetDTO>();
        for (Comentario comentario : listaComentarios) {
            ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(comentario.getCodigo() , comentario.getDescripcion() ,
                    comentario.getProducto().getCodigo() , comentario.getUsuario().getCedula() , comentario.getFechaCreacion());
            listaComentariosGetDto.add(comentarioGetDTO);
        }
        return listaComentariosGetDto;
    }

    @Override
    public Comentario actualizarComentario(ActualizarComentarioDTO actualizarComentarioDTO) throws Exception{

        Comentario comentario = comentarioRepo.findById(actualizarComentarioDTO.getCodigo()).orElse(null);

        comentario.setDescripcion(actualizarComentarioDTO.getMensaje());

        return comentarioRepo.save(comentario);

    }
}
