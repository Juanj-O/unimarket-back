package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.servicios.implementacion.SesionServicioImpl;
import co.edu.uniquindio.proyecto.servicios.implementacion.UsuarioServicioImpl;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioServicioImpl usuarioServicioImpl;

    @Autowired
    private SesionServicioImpl sesionServicio;
    @Test
    public void crearUsuarioTestNormal() throws Exception{


            UsuarioDTO usuarioDTO = new UsuarioDTO("1223", "pepe1", "1234", "Calle 123", "pepe@qqq", "525");
            Usuario usuario = usuarioServicio.registarUsuario(usuarioDTO);

            Assertions.assertNotEquals(0, usuario);


        }

    @Test
    @Sql("classpath:dataset.sql")
    public void Login() throws Exception{

/*       UsuarioDTO usuarioDTO = new UsuarioDTO("1234", "juan lopez", "3218745560", "carrera 14", "juanlopez@hotmail.com", "123juan");
        System.out.println(usuarioDTO);

        Usuario usuario = usuarioServicioImpl.registarUsuario(usuarioDTO);
        System.out.println("Usuario creado "+usuario);
        Assertions.assertNotNull(usuario);*/


        SesionDTO sesionDTO = new SesionDTO("juanlopez@hotmail.com", "123juan");
        System.out.println("sesionDTO "+sesionDTO);

        TokenDTO usuarioLogeado = sesionServicio.login(sesionDTO);
        System.out.println("Usuario login "+usuarioLogeado);
        Assertions.assertNotNull(usuarioLogeado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearUsuarioTest() throws Exception{

        UsuarioDTO usuarioDTO = new UsuarioDTO("1223", "pepe1", "1234", "Calle 123", "pepe@qqq", "525");
        System.out.println(usuarioDTO);

        Usuario usuario = usuarioServicioImpl.registarUsuario(usuarioDTO);
        System.out.println("Usuario creado "+usuario);
        Assertions.assertNotNull(usuario);


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
