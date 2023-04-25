package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Moderador;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer>{
    Optional<Moderador> findByCorreo(String email);
}
