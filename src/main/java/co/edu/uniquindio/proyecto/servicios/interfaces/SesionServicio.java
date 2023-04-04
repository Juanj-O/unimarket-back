package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.dto.SesionDTO;
import org.springframework.stereotype.Service;

@Service
public interface SesionServicio {

    TokenDTO login(SesionDTO sesionDTO);

   void logout (SesionDTO sesionDTO );

}
