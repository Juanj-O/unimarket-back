package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.PqrDTO;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.PQRS;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.PqrRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.PqrsServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PqrServicioImpl implements PqrsServicio {

    @Autowired
    private PqrRepo pqrRepo;

    @Autowired
    private CompraRepo compraRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public PQRS crearPqrs(PqrDTO pqrDTO) throws Exception {

        Usuario usuario = usuarioRepo.findById(pqrDTO.getCedulaUsuario()).orElse(null);
        Compra compra = compraRepo.findById(pqrDTO.getCodigoFactura()).orElse(null);

        if (usuario == null){
            throw new Exception("El Usuario no existe.");
        }
        if (compra == null){
            throw new Exception("La compra no existe.");
        }
        System.out.println(usuario.getCedula());
        System.out.println(compra.getCodigo());

        PQRS pqrs = pqrRepo.save(new PQRS(pqrDTO.getMensaje() , LocalDateTime.now() , usuario , compra ) );

        System.out.println(pqrs.getCodigo());

        return null;
    }
}
