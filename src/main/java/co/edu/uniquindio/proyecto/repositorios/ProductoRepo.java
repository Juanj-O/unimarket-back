package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo  extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.nombre like concat('%',:nombreProducto,'%') and current_date <= p.fechaLimite and p.estado = true")
    List<Producto> listarProductosPorNombre(String nombreProducto);

    @Query("select p from Producto p where p.usuario.cedula = :cedulaUsuario")
    List<Producto> listarProductosDelUsuario(String cedulaUsuario);

    @Query("select p from Producto p where p.precio between :precioMin and :precioMax and current_date <= p.fechaLimite and p.estado = true")
    List<Producto> listarProductosPorPrecio(double precioMin, double precioMax);

    @Query("select p from Producto p where :categoria member of p.categoria and current_date <= p.fechaLimite and p.estado = true")
    List<Producto> listarProductoCategoria(Categoria categoria);

    @Query ("select p from Producto p where p.estado = :estado and current_date <= p.fechaLimite")
    List<Producto> listarProductosEstado(boolean estado);

    @Query("select f from Usuario u join u.productofavorito f where u.cedula = :cedulaUsuario and f.estado = true")
    List<Producto> listarProductosFavoritos(String cedulaUsuario);

    @Query("select p from Producto p inner join LogPublicacion l on p.codigo = l.producto.codigo where l.moderador.codigo = :codigoModerador and l.estado = :estado")
    List<Producto> listarProductosEstadoModerador(int codigoModerador, Estado estado);
}
