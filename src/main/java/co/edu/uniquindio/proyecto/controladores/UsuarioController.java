package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.seguridad.modelo.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.implementacion.CambiarContrasenaServicioImpl;
import co.edu.uniquindio.proyecto.servicios.implementacion.EmailServicioImpl;
import co.edu.uniquindio.proyecto.servicios.implementacion.UsuarioServicioImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("api/usuario")
@AllArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioServicioImpl usuarioServicio;

    @Autowired
    private CambiarContrasenaServicioImpl cambiarContrasenaServicio;

    @Autowired
    private EmailServicioImpl emailServicio;

    @PostMapping("/registrar-usuario")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try {
            return ResponseEntity.status(200).body(usuarioServicio.registarUsuario(usuarioDTO));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @SecurityRequirement(name = "bearerAuth")
    @PutMapping("/actualizar-usuario")
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try {
            return ResponseEntity.status(200).body(usuarioServicio.actualizarUsuario(usuarioDTO));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/obtener-usuario/{cedula}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> obtenerUsuarioCedula(@PathVariable(name = "cedula") String cedula){
        try {
            return ResponseEntity.status(200).body(usuarioServicio.obtenerUsuarioCodigo(cedula));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-usuario/{cedula}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> eliminarUsuario(@PathVariable(name = "cedula") String cedula){
        try {
            usuarioServicio.eliminiarUsuario(cedula);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
