package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ActualizarPqrsDTO;
import co.edu.uniquindio.proyecto.dto.PqrDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.repositorios.PqrRepo;
import co.edu.uniquindio.proyecto.seguridad.modelo.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.implementacion.PqrServicioImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("api/pqrs")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class PQRSController {

    @Autowired
    private PqrServicioImpl pqrServicio;

    @Autowired
    private PqrRepo pqrRepo;

    @PostMapping("/crear-pqrs")
    public ResponseEntity<?> crearPQRS(@RequestBody PqrDTO pqrDTO) {
        try {
            pqrServicio.crearPqrs(pqrDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO<>(HttpStatus.CREATED,
                    false, "PQRS creado exitosamente."));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-pqrs")
    public ResponseEntity<?> actualizarPQRS(@RequestBody ActualizarPqrsDTO actualizarPqrsDTO) {
        try {
            pqrServicio.actualizarPqrs(actualizarPqrsDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO<>(HttpStatus.CREATED,
                    false, "PQRS actualizado exitosamente."));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/elimiar-pqrs/{codigoPQRS}")
    public ResponseEntity<?> actualizarPQRS(@PathVariable  int codigoPQRS) {
        try {
            pqrServicio.eliminarPQRS(codigoPQRS);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO<>(HttpStatus.CREATED,
                    false, "PQRS eliminado exitosamente."));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/obtener-listaPQRSHechos/{cedula}")
    public ResponseEntity<?> listarPQRSHechos(@PathVariable  String cedula) {
        try {
            return ResponseEntity.status(200).body(pqrServicio.listarPQRSHechos(cedula));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
