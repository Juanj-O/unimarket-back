package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.implementacion.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/usuario")
@AllArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioServicioImpl usuarioServicio;

    @PostMapping("/registrar-usuario")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try {
            return ResponseEntity.status(200).body(usuarioServicio.registarUsuario(usuarioDTO));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-usuario/{cedula}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable String cedula, @RequestBody UsuarioDTO usuarioDTO){
        try {
            return ResponseEntity.status(200).body(usuarioServicio.registarUsuario(usuarioDTO));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
