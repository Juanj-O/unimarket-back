package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;

    void eliminarProducto(int codigoProducto) throws Exception;

    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO);

    int actualizarProductoEstado(int codigoProducto, boolean estado);

    int actualizarProductoCantidad(int codigoProducto, int unidades);

    ProductoGetDTO obtenerProducto(int codigoProducto);

    List<ProductoGetDTO> listarProductoCategoria(Categoria categoria);

    List<ProductoGetDTO>  listarProductosUsuario(int cedulaUsuario);

    List<ProductoGetDTO> listarProductosEstadoModerador(Estado estado);

    List<ProductoGetDTO>  listarProductosNombre(String nombre);

    List<ProductoGetDTO>  listarProductosPrecio(float precioMin, float precioMax);

    List<ProductoGetDTO> listarProductosFavoritos();

    void crearFavorito(int codigoUsuario, int codigoProducto) throws Exception;

    void eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception;

    void validarExiste(int codigo) throws Exception;

    int actualizarUnidades(Producto producto, int unidades) throws Exception;
}
