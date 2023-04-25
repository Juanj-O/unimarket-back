package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ActualizarPqrsDTO;
import co.edu.uniquindio.proyecto.dto.PqrDTO;
import co.edu.uniquindio.proyecto.modelo.PQRS;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PqrsServicio {

    PQRS crearPqrs(PqrDTO pqrDTO) throws Exception;

    List<PqrDTO> listarPQRSHechos(String cedula) throws Exception;

    PQRS actualizarPqrs(ActualizarPqrsDTO actualizarPqrsDTO) throws Exception;

     void eliminarPQRS(int codigoPQRS) throws Exception;

}
