package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServicioImpl implements EmailServicio {

    private final JavaMailSender javaMailSender;

    @Override
    public void enviarEmail(String asunto, String cuerpo, String para) throws Exception {
        System.out.println(para);
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        helper.setSubject(asunto);
        helper.setText(cuerpo, true);
        helper.setTo(para);
        helper.setFrom("no_reply@dominio.com");
        javaMailSender.send(mensaje);
    }
}
