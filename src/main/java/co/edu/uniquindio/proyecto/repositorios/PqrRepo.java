package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqrRepo extends JpaRepository<PQRS, Integer> {

    @Query("select p from PQRS p where p.usuario.cedula = :cedulaUsuario")
    List<PQRS> listarPQRSUsuario(String cedulaUsuario);
}
