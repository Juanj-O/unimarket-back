package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;

    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;


    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setUsuario(usuarioServicio.obtener(productoDTO.getCedulaUsuario()));
        producto.setImagen(productoDTO.getImagenes());
        producto.setCategoria(productoDTO.getCategorias());
        producto.setEstado(false);
        producto.setFechaCreacion( LocalDateTime.now());
        producto.setFechaLimite(LocalDateTime.now().plusDays(60));


        return productoRepo.save(producto).getCodigo();

    }

    @Override
    public void eliminarProducto(int codigoProducto) throws Exception {
        validarExiste(codigoProducto);
        productoRepo.deleteById(codigoProducto);
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) {
        return 0;
    }

    @Override
    public int actualizarProductoEstado(int codigoProducto, boolean estado) {
        return 0;
    }

    @Override
    public int actualizarProductoCantidad(int codigoProducto, int unidades) {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductoCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int cedulaUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstadoModerador(Estado estado) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMin, float precioMax) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos() {
        return null;
    }

    @Override
    public void crearFavorito(int codigoUsuario, int codigoProducto) throws Exception {

    }

    @Override
    public void eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception {

    }

    @Override
    public void validarExiste(int codigo) throws Exception{
        productoServicio.obtenerProducto(codigo);
    }

    @Override
    public int actualizarUnidades(Producto producto, int unidades) throws Exception{
        validarExiste(producto.getCodigo());
        producto.setUnidades(unidades);
        return productoRepo.save(producto).getCodigo();
    }
}
