package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepo  extends JpaRepository<Producto, Integer> {



}
