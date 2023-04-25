package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.CompraCreadaDTO;
import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.Compra;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CompraServicio {

    Compra crearCompra(CompraDTO compraDTO)  throws Exception ;

    List<CompraGetDTO>listarComprasUsuario(String cedula) throws Exception;
}
