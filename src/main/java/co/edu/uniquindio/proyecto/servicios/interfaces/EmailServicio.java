package co.edu.uniquindio.proyecto.servicios.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface EmailServicio {

    void enviarEmail(String asunto, String cuerpo, String para) throws Exception;

/*    void enviarEmail2(EmailDTO emailDTO) throws Exception;*/
}
