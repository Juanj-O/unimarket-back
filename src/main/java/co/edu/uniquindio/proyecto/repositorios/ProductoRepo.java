package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo  extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.nombre like concat('%', :nombreProducto,'%') and current_date <= p.fechaLimite and p.estado = true")
    List<Producto> listarProductosPorNombre(String nombreProducto);

    @Query("select p from Producto p where p.usuario.cedula = :cedulaUsuario")
    List<Producto> listarProductosDelUsuario(String cedulaUsuario);

}
