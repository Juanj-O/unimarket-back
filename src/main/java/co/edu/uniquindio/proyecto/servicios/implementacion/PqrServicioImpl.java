package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ActualizarPqrsDTO;
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
import java.util.ArrayList;
import java.util.List;

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


        return pqrs;
    }

    @Override
    public List<PqrDTO> listarPQRSHechos(String cedula) throws Exception {

        Usuario usuario = usuarioRepo.findById(cedula).orElse(null);

        if(usuario == null){
            throw new Exception("El usuario no existe.");
        }
        System.out.println(usuario.getNombreCompleto());

        List<PQRS> listaPqrs = pqrRepo.listarPQRSUsuario(cedula);

        List<PqrDTO> listaDTO = new ArrayList<PqrDTO>();
        for ( PQRS pqrs : listaPqrs ) {
            PqrDTO pqrDTO = new PqrDTO(pqrs.getUsuario().getCedula() , pqrs.getCompra().getCodigo() , pqrs.getMensaje());
            listaDTO.add(pqrDTO);
        }
        return listaDTO;
    }

    @Override
    public PQRS actualizarPqrs(ActualizarPqrsDTO actualizarPqrsDTO) throws Exception{

        PQRS pqrs = pqrRepo.findById(actualizarPqrsDTO.getCodigoPqrs()).orElse(null);

        if(pqrs == null ){
            throw new Exception("No existe el pqrs");
        }

        pqrs.setMensaje(actualizarPqrsDTO.getMensaje());
        pqrs.setFecha(LocalDateTime.now());
        return pqrRepo.save(pqrs);
    }

    @Override
    public void eliminarPQRS(int codigoPQRS) throws Exception{
        PQRS pqrs = pqrRepo.findById(codigoPQRS).orElse(null);

        if(pqrs == null ){
            throw new Exception("El PQRS no existe.");
        }

        pqrRepo.delete(pqrs);
    }
}
