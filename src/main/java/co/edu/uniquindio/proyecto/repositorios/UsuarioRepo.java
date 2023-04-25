package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {

    @Query("select u from Usuario u where u.email = :correo")
    Usuario buscarUsuario(String correo);



    @Query("select u from Usuario u where u.email = :correo and u.cedula = :cedulaUsuario")
    Usuario buscarCorreo(String correo, String cedulaUsuario);


    Optional<Usuario> findByEmail(String email);
}
