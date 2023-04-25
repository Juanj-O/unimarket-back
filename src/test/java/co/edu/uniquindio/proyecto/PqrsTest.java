package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.PqrDTO;
import co.edu.uniquindio.proyecto.modelo.PQRS;
import co.edu.uniquindio.proyecto.repositorios.PqrRepo;
import co.edu.uniquindio.proyecto.servicios.implementacion.PqrServicioImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class PqrsTest {

    @Autowired
    private PqrServicioImpl pqrServicio;

    @Autowired
    private PqrRepo pqrRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void crearPqrs() throws Exception{
        PqrDTO pqrDTO = new PqrDTO("1234", 2, "prueba");
        pqrServicio.crearPqrs(pqrDTO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPqrs() throws Exception {

        PQRS pqrs = pqrRepo.findById(1).orElse(null);
        pqrRepo.delete(pqrs);
        Assertions.assertNotNull(pqrRepo.findById(1).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRSHechos() throws  Exception {
        Assertions.assertEquals(1 , pqrServicio.listarPQRSHechos("1478"));
    }
}
