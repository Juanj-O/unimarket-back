package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.seguridad.modelo.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.implementacion.EmailServicioImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("api/enviar-email")
@AllArgsConstructor
public class EnviarEmailController {

    @Autowired
    private EmailServicioImpl emailServicio;


    @PostMapping("/enviar-email")
    public ResponseEntity<?> enviarEmail(@RequestBody EmailDTO emailDTO){
        try {
            emailServicio.enviarEmail(emailDTO.getAsunto(),emailDTO.getCuerpo() ,emailDTO.getDestinatario());
            return ResponseEntity.status(200).body(new MensajeDTO<>(HttpStatus.ACCEPTED,
                    false, "Revisa tu correo"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
