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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        validarProductoExiste(codigoProducto);
        productoRepo.deleteById(codigoProducto);
    }

    @Override
    public ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {
        validarProductoExiste(codigoProducto);
        Producto producto = convertirDTO(productoDTO);
        producto.setCodigo(codigoProducto);
        return convertir(productoRepo.save(producto));
    }

    @Override
    public void actualizarProductoEstado(int codigoProducto, boolean estado) throws Exception {
        validarProductoExiste(codigoProducto);
        Producto producto = obtener(codigoProducto);
        producto.setEstado(estado);
    }

    @Override
    public int actualizarProductoCantidad(int codigoProducto, int unidades) {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception{

        return convertir(obtener(codigoProducto));
    }

    @Override
    public Producto obtener(int codigoProducto) throws Exception {
        //Devuelve un producto dado su codigo
        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if(producto.isEmpty()){
            throw new Exception("El código "+codigoProducto+" no está asociado a ningún producto");
        }
        return producto.get();
    }

    @Override
    public List<ProductoGetDTO> listarProductoCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(String cedulaUsuario) throws Exception {
        List<Producto> productos = productoRepo.listarProductosDelUsuario(cedulaUsuario);

        if(productos.isEmpty()) {
            throw new Exception("El usuario no tiene productos");
        }

        List<ProductoGetDTO> response = new ArrayList<>();
        for(Producto producto : productos){
            response.add(convertir(producto));
        }

        return response;
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

    private void validarProductoExiste (int codigoProducto) throws Exception {
        boolean existe = productoRepo.existsById(codigoProducto);

        if( !existe ){
            throw new Exception("No se encuentra ningún producto con el código "+codigoProducto);
        }

    }

    private Producto convertirDTO(ProductoDTO productoDTO) throws Exception {
        Producto producto = new Producto();
        producto.setEstado(false);
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setUsuario(usuarioServicio.obtener(productoDTO.getCedulaUsuario()));
        return producto;
    }

    private ProductoGetDTO convertir(Producto producto){
        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getFechaLimite(),
                producto.isEstado(),
                producto.getFechaCreacion(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getUnidades(),
                producto.getUsuario().getCedula(),
                producto.getImagen(),
                producto.getCategoria()
        );
        return productoGetDTO;
    }

    @Override
    public int actualizarUnidades(Producto producto, int unidades) throws Exception{
        validarProductoExiste(producto.getCodigo());
        producto.setUnidades(unidades);
        return productoRepo.save(producto).getCodigo();
    }
}
