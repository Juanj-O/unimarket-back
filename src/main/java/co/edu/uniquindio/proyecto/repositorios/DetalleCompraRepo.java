package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra , Integer> {

    @Query("select d from DetalleCompra d where d.compra.codigo = :codigoCompra")
    List<DetalleCompra>obtenerDetallesCompra(Integer codigoCompra);

}
