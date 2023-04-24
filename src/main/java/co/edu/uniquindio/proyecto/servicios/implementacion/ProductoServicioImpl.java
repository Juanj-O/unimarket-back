package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private UsuarioServicio usuarioServicio;


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
    public List<ProductoGetDTO> listarProductoCategoria(Categoria categoria) throws Exception {
        List<Producto> listaProductos = productoRepo.listarProductoCategoria(categoria);

        if(listaProductos.isEmpty()) {
            throw new Exception("No hay producto en la categoria" + categoria);
        }

        List<ProductoGetDTO> response = new ArrayList<>();

        for(Producto producto : listaProductos){
            response.add( convertir(producto) );
        }

        return response;
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
    public List<ProductoGetDTO> listarProductosEstadoModerador( int codigoModerador ,Estado estado) throws Exception {
        List<Producto> listaProductosEstadoModerador = productoRepo.listarProductosEstadoModerador(codigoModerador, estado);

        if(listaProductosEstadoModerador.isEmpty()) {
            throw new Exception("Usted no tiene productos con estado " + estado);
        }

        List<ProductoGetDTO> response = new ArrayList<>();

        for(Producto producto : listaProductosEstadoModerador){
            response.add( convertir(producto) );
        }
        return response;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(boolean estado) throws Exception {
        List<Producto> listaProductosEstado = productoRepo.listarProductosEstado(estado);

        if(listaProductosEstado.isEmpty()) {
            throw new Exception("No hay productos con estado " + estado);
        }

        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto producto : listaProductosEstado){
            respuesta.add( convertir(producto) );
        }
        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) throws Exception {
        List<Producto> productos = productoRepo.listarProductosPorNombre(nombre);

        if (productos.isEmpty()){
            throw new Exception("El producto no se encuentra");
        }

        List<ProductoGetDTO> response = new ArrayList<>();
        for (Producto producto : productos){
            response.add(convertir(producto));
        }

        return response;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(double precioMin, double precioMax) throws Exception {
        List<Producto> productos = productoRepo.listarProductosPorPrecio(precioMin, precioMax);

        if (productos.isEmpty()){
            throw new Exception("No hay productos en este rango de precios");
        }

        List<ProductoGetDTO> response = new ArrayList<>();
        for (Producto producto : productos){
            response.add(convertir(producto));
        }

        return response;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(String cedulaUsuario) throws Exception {
        List<Producto> listaProductosFavoritos = productoRepo.listarProductosFavoritos(cedulaUsuario);

        if(listaProductosFavoritos.isEmpty()){
            throw new Exception("El usuario no tiene productos favoritos");
        }

        List<ProductoGetDTO> response = new ArrayList<>();

        for(Producto producto : listaProductosFavoritos){
            response.add( convertir(producto) );
        }

        return response;
    }

    @Override
    public void crearFavorito(String cedulaUsuario, int codigoProducto) throws Exception {
        Usuario usuario = usuarioServicio.obtener(cedulaUsuario);
        Producto producto = obtener(codigoProducto);
        usuario.getProductofavorito().add(producto);
    }

    @Override
    public void eliminarFavorito(String cedulaUsuario, int codigoProducto) throws Exception {
        Usuario usuario = usuarioServicio.obtener(cedulaUsuario);
        Producto producto = obtener(codigoProducto);
        usuario.getProductofavorito().remove(producto);
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
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception{
        validarProductoExiste(codigoProducto);
        Producto producto = obtener(codigoProducto);
        producto.setUnidades(unidades);
        return producto.getUnidades();
    }
}
