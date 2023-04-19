package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearUsuarioTest() throws Exception{


            UsuarioDTO usuarioDTO = new UsuarioDTO("1223", "pepe1", "1234", "Calle 123", "pepe@qqq", "525");
            String cedula = usuarioServicio.registarUsuario(usuarioDTO);

            Assertions.assertNotEquals(0, cedula);


        }


    @Test
    public void eliminarUsuarioTest(){
        try {
            usuarioServicio.eliminiarUsuario("232");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void actualizarUsuarioTest(){
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("111", "pepe1@email.com", "1234", "Calle 123", "2782", "343");
            usuarioServicio.actualizarUsuario("2344", usuarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void obtenerUsuarioTest(){
        try {
            UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuarioCodigo("1233");
            System.out.println(usuarioGetDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
