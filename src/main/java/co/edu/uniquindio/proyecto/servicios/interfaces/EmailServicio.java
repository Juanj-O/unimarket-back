package co.edu.uniquindio.proyecto.servicios.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface EmailServicio {

    String enviarEmail(String asunto, String cuerpo, String para);
}
