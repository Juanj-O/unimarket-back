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

    ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;

    void actualizarProductoEstado(int codigoProducto, boolean estado) throws Exception;

    int actualizarProductoCantidad(int codigoProducto, int unidades);

    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;

    Producto obtener(int codigoProducto) throws Exception;
    List<ProductoGetDTO> listarProductoCategoria(Categoria categoria) throws Exception;

    List<ProductoGetDTO>  listarProductosUsuario(String cedulaUsuario) throws Exception;

    List<ProductoGetDTO> listarProductosEstadoModerador(int codigoModerador, Estado estado) throws Exception;

    List<ProductoGetDTO> listarProductosEstado(boolean estado) throws Exception;

    List<ProductoGetDTO>  listarProductosNombre(String nombre) throws Exception;

    List<ProductoGetDTO>  listarProductosPrecio(double precioMin, double precioMax) throws Exception;

    List<ProductoGetDTO> listarProductosFavoritos(String cedula) throws Exception;

    void crearFavorito(String cedulaUsuario, int codigoProducto) throws Exception;

    void eliminarFavorito(String cedulaUsuario, int codigoProducto) throws Exception;


    int actualizarUnidades(int codigoProducto, int unidades) throws Exception;
}
