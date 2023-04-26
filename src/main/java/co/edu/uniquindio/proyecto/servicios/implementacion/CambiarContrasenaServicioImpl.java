package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CambiarContrasenaDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CambiarContrasenaServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CambiarContrasenaServicioImpl implements CambiarContrasenaServicio {
    private EmailServicioImpl emailServicio;
    private UsuarioRepo clienteRepo;

    private ModeradorRepo moderadorRepo;

    @Override
    public void recuperarPassword(String email) throws Exception {
        System.out.println(email);
        if (email != clienteRepo.buscarUsuario(email).getEmail()) {
            System.out.println("entro 1");

            if (email != moderadorRepo.findByCorreo(email).get().getCorreo()){
                System.out.println("entro 2");

                throw new UsernameNotFoundException("El correo " + email + " no esta registrado");
            }
        }else {
            System.out.println("entro");
            emailServicio.enviarEmail("Cambio contraseña", "Ingresa al siguiente Link:"+
                    "http://localhost:8081/api/cambiar-contrasena/cambiar/"+clienteRepo.buscarUsuario(email).getCedula(), email);
        }
    }

    @Override
    public void cambiarContrasena(String cedula, CambiarContrasenaDTO cambiarContrasenaDTO) throws Exception {
        Usuario usuario = clienteRepo.findUsuarioByCedula(cedula);
        if (cambiarContrasenaDTO.getContrasena().equals(cambiarContrasenaDTO.getRepetirContrasena()) && usuario!=null){
            usuario.setContrasena(cambiarContrasenaDTO.getContrasena());
            clienteRepo.save(usuario);
        }

    }

}
