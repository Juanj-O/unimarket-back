package co.edu.uniquindio.proyecto.servicios.implementacion;

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
        if (email != clienteRepo.buscarUsuario(email).getEmail()) {
            if (email != moderadorRepo.findByCorreo(email).get().getCorreo()){
                throw new UsernameNotFoundException("El correo " + email + " no esta registrado");
            }
        }else {
            emailServicio.enviarEmail("Cambio contraseña", "Ingresa al siguiente Link:", email);
        }
    }

}
