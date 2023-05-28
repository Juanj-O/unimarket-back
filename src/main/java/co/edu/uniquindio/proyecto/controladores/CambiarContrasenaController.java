package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.CambiarContrasenaDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.seguridad.modelo.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.implementacion.CambiarContrasenaServicioImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("api/cambiar-contrasena")
@AllArgsConstructor
public class CambiarContrasenaController {

        private CambiarContrasenaServicioImpl cambiarContrasenaServicio;


    @PostMapping("/recuperar")
    public ResponseEntity<?> recuperarPassword(@RequestBody String email){
        try {
            cambiarContrasenaServicio.recuperarPassword(email);
            return ResponseEntity.status(200).body(new MensajeDTO<>(HttpStatus.CREATED,
                    false, "Se envio un correo para recuperar la contraseña"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/cambiar/{cedula}")
    public ResponseEntity<?> cambiarContrasena(@PathVariable(name="cedula") String cedula
            ,@RequestBody CambiarContrasenaDTO cambiarContrasenaDTO){
        try {
            cambiarContrasenaServicio.cambiarContrasena(cedula, cambiarContrasenaDTO);
            return ResponseEntity.status(200).body(new MensajeDTO<>(HttpStatus.CREATED,
                    false, "Se cambio la contraseña correctamente"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
