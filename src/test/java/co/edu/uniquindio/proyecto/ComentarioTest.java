package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.ActualizarComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.implementacion.ComentarioSericioImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class ComentarioTest {

    @Autowired
    private ComentarioSericioImpl comentarioSericio;

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentario() throws Exception{
        ComentarioDTO comentarioDTO = new ComentarioDTO("prueba" , 1 , "1234");
        Comentario comentario = comentarioSericio.crearComentario(comentarioDTO);
//        System.out.println();
        Assertions.assertNotNull(comentario);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosProducto() throws Exception{
            List<ComentarioGetDTO> lista = comentarioSericio.listarComentariosProducto(1);
            lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarComentario(){
        Comentario comentario = comentarioRepo.findById(1).orElse(null);
        comentarioRepo.delete(comentario);
        Assertions.assertNotNull(comentarioRepo.findById(1).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarComentario() throws Exception{
        ActualizarComentarioDTO actualizarComentarioDTO = new ActualizarComentarioDTO(1 , "prueba");
        Comentario comentario = comentarioSericio.actualizarComentario(actualizarComentarioDTO);
        System.out.println(comentario);
        Assertions.assertNotNull(comentario);
    }
}
