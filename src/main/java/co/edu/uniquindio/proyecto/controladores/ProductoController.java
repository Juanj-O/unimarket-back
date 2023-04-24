package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.servicios.implementacion.ProductoServicioImpl;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/productos")
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

    @GetMapping("/obtener-producto/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable(name="id") int codigoProducto) {
        try{
            return ResponseEntity.status(200).body(productoServicio.obtenerProducto(codigoProducto));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
