package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.PqrDTO;
import co.edu.uniquindio.proyecto.modelo.PQRS;
import co.edu.uniquindio.proyecto.servicios.implementacion.PqrServicioImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class PqrsTest {

    @Autowired
    private PqrServicioImpl pqrServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearPqrs() throws Exception{
        PqrDTO pqrDTO = new PqrDTO("1234", 2, "prueba");
        pqrServicio.crearPqrs(pqrDTO);
    }
}
