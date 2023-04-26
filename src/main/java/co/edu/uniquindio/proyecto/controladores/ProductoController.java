package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.servicios.implementacion.ProductoServicioImpl;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/productos")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @PostMapping("/crear-producto")
    public ResponseEntity<?> crearProducto(@RequestBody ProductoDTO productoDTO){
        try {
            return ResponseEntity.status(200).body(productoServicio.crearProducto(productoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-producto/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable(name = "id") int codigoProducto){
        try{
            productoServicio.eliminarProducto(codigoProducto);
            return ResponseEntity.status(200).body("Producto eliminado");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-producto")
    public ResponseEntity<?> actualizarProducto(@RequestBody int codigoProducto, ProductoDTO productoDTO){
        try{
            return ResponseEntity.status(200).body(productoServicio.actualizarProducto(codigoProducto, productoDTO));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-producto-estado")
    public ResponseEntity<?> actualizarProductoEstado(@RequestBody int codigoProducto, boolean estado){
        try{
            productoServicio.actualizarProductoEstado(codigoProducto, estado);
            return ResponseEntity.status(200).body("¡Estado del producto actualizado!");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-producto-cantidad")
    public ResponseEntity<?> actualizarProductoCantidad(@RequestBody int codigoProducto, int unidades){
        try{
            return ResponseEntity.status(200).body(productoServicio.actualizarProductoCantidad(codigoProducto, unidades));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/obtener-producto/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable(name="id") int codigoProducto) {
        System.out.println(codigoProducto);
        try{
            return ResponseEntity.status(200).body(productoServicio.obtenerProducto(codigoProducto));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-productos-categoria/{categoria}")
    public ResponseEntity<?> listarProductoCategoria(@PathVariable(name="categoria") Categoria categoria) {
        try{
            return ResponseEntity.status(200).body(productoServicio.listarProductoCategoria(categoria));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-productos-usuario/{cedula}")
    public ResponseEntity<?> listarProductosUsuario(@PathVariable(name="cedula") String cedula) {
        try{
            return ResponseEntity.status(200).body(productoServicio.listarProductosUsuario(cedula));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-productos-estado-moderador/{codigoModerador}/{estado}")
    public ResponseEntity<?> listarProductosEstadoModerador(@PathVariable(name="codigoModerador") Integer codigoModerador,
                                                    @PathVariable(name="estado") Estado estado) {
        try{
            return ResponseEntity.status(200).body(productoServicio.listarProductosEstadoModerador(codigoModerador, estado));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-productos-estado/{estado}")
    public ResponseEntity<?> listarProductosEstado(@PathVariable(name="estado") boolean estado) {
        try{
            return ResponseEntity.status(200).body(productoServicio.listarProductosEstado(estado));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-productos-nombre/{nombre}")
    public ResponseEntity<?> listarProductosNombre(@PathVariable(name="nombre") String nombre) {
        try{
            return ResponseEntity.status(200).body(productoServicio.listarProductosNombre(nombre));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-productos-precio/{precioMin}/{precioMax}")
    public ResponseEntity<?> listarProductosEstadoModerador(@PathVariable(name="precioMin") double precioMin,
                                                            @PathVariable(name="precioMax") double precioMax) {
        try{
            return ResponseEntity.status(200).body(productoServicio.listarProductosPrecio(precioMin, precioMax));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-productos-favoritos/{cedulaUsuario}")
    public ResponseEntity<?> listarProductosFavoritos(@PathVariable(name="cedulaUsuario") String cedulaUsuario) {
        try{
            return ResponseEntity.status(200).body(productoServicio.listarProductosFavoritos(cedulaUsuario));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/crear-favorito")
    public ResponseEntity<?> crearProductoFavorito(@RequestBody String cedulaUsuario, int codigoProducto){
        try {
            productoServicio.crearFavorito(cedulaUsuario, codigoProducto);
            return ResponseEntity.status(200).body("¡Producto agregado a favoritos!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-favorito")
    public ResponseEntity<?> eliminarProductoFavorito(@RequestBody String cedulaUsuario, int codigoProducto){
        try {
            productoServicio.eliminarFavorito(cedulaUsuario, codigoProducto);
            return ResponseEntity.status(200).body("¡Producto eliminado de favoritos!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/obtener-productosMasVendidos")
    public ResponseEntity<?> listarProductosMasVendidos(){
        try {
            return ResponseEntity.status(200).body(productoServicio.listarProductosMasComprados());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
