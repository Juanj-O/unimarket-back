package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
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
    private CloudinaryServicio cloudinaryServicio;

    @PostMapping("/subir-imagen")
    public ResponseEntity<?> subirImagen(@RequestBody MultipartFile file)
            throws Exception{
        File imagen = cloudinaryServicio.convertir(file);
        Map response = cloudinaryServicio.subirImagen(imagen, "unimarket");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarImagen(@PathVariable String id) throws Exception{
        Map response = cloudinaryServicio.eliminarImagen(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}