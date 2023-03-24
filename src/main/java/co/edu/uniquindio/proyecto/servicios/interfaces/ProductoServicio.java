package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO);

    int eliminarProducto(int codigoProducto);

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
}
