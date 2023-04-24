package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.PqrDTO;
import co.edu.uniquindio.proyecto.modelo.PQRS;
import org.springframework.stereotype.Service;

@Service
public interface PqrsServicio {

    PQRS crearPqrs(PqrDTO pqrDTO) throws Exception;

}
