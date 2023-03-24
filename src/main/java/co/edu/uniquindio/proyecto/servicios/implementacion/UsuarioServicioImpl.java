package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;

    @Override
    public String registarUsuario(UsuarioDTO usuarioDTO) throws Exception {

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());

        if (buscado != null) {
            throw new Exception("El correo " + usuarioDTO.getEmail() + " ya está en uso");
        }

        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save(usuario).getCedula();
    }

    @Override
    public String actualizarUsuario(String cedula, UsuarioDTO usuarioDTO) throws Exception {

        /**
         * TODO Validar que el correo no se repita
         */

        validarExiste(cedula);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCedula(cedula);

        return usuarioRepo.save(usuario).getCedula();
    }

    @Override
    public String eliminiarUsuario(String cedula) throws Exception {
        validarExiste(cedula);
        usuarioRepo.deleteById(cedula);
        return cedula;
    }


    public UsuarioGetDTO obtenerUsuarioCodigo(String cedula) throws Exception{
        return convertir( obtener(cedula) );
    }

    private Usuario obtener(String cedula) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(cedula);

        if(usuario.isEmpty() ){
            throw new Exception("El código "+cedula+" no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    private void validarExiste(String cedula) throws Exception {
        boolean existe = usuarioRepo.existsById(cedula);

        if (!existe) {
            throw new Exception("El código " + cedula + " no está asociado a ningún usuario");
        }

    }

    private UsuarioGetDTO convertir(Usuario usuario){

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCedula(),
                usuario.getNombreCompleto(),
                usuario.getTelefono(),
                usuario.getDireccion(),
                usuario.getEmail());


        return usuarioDTO;
    }


    private Usuario convertir(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setNombreCompleto( usuarioDTO.getNombreCompleto() );
        usuario.setTelefono( usuarioDTO.getTelefono() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setContrasena( usuarioDTO.getContrasena() );

        return usuario;
    }
}
