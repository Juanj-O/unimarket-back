package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.servicios.implementacion.CompraServicioImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/compras")
@AllArgsConstructor
public class CompraController {
    @Autowired
    private CompraServicioImpl compraServicio;

    @PostMapping("/crear-compra")
    public ResponseEntity<?> crearCompra(@RequestBody CompraDTO compraDTO) {
            try {
                return ResponseEntity.status(200).body(compraServicio.crearCompra(compraDTO));
            } catch (Exception e) {
                return ResponseEntity.status(500).body(e.getMessage());
            }
    }

    @GetMapping("/listar-compras/{cedula}")
    public ResponseEntity<?> listarCompra(@PathVariable String cedula) {
        try {
            return ResponseEntity.status(200).body(compraServicio.listarComprasUsuario(cedula));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
