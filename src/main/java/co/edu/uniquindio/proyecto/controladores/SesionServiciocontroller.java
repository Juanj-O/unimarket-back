package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.servicios.implementacion.SesionServicioImpl;
import co.edu.uniquindio.proyecto.servicios.implementacion.UsuarioServicioImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("api/auth")
@AllArgsConstructor
public class SesionServiciocontroller {


    @Autowired
    private SesionServicioImpl sesionServicio;

//  usuario  pedrorodriguez@hotmail.com  - 1234
//  moderador  juan@juan.com  - 1234
    @PostMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody SesionDTO sesionDTO){
        try {
            return ResponseEntity.status(200).body(sesionServicio.login(sesionDTO));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
