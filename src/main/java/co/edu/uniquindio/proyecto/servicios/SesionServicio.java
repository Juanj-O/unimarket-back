package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.dto.SesionDTO;

public interface SesionServicio {

    TokenDTO login(SesionDTO sesionDTO);

   void logout (SesionDTO sesionDTO );

}
