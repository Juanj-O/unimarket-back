package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO);

    List<CompraGetDTO>listarComprasUsuario(String cedula);
}
