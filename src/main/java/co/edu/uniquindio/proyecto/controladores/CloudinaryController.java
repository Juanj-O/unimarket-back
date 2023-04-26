package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.servicios.implementacion.CloudinaryServicioImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("api/imagenes")
@AllArgsConstructor
public class CloudinaryController {
    @Autowired
    private CloudinaryServicioImpl cloudinaryServicio;

    @PostMapping("/subir-imagen")
    public ResponseEntity<?> subirImagen(@RequestParam("file") MultipartFile file)
            throws Exception{
        File imagen = cloudinaryServicio.convertir(file);
        Map response = cloudinaryServicio.subirImagen(imagen, "proyecto");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarImagen(@RequestParam("publicId") String publicId) throws Exception{
        Map response = cloudinaryServicio.eliminarImagen(publicId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}