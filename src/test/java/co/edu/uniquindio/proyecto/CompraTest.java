package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.MetodoPago;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.servicios.implementacion.CompraServicioImpl;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class CompraTest {

    @Autowired
    private CompraServicioImpl compraServicio;

    @Autowired
    private CompraRepo compraRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCompraTest() throws Exception {

        DetalleCompraDTO detalle1 = new DetalleCompraDTO(1 , 2000.0 , 1);
        DetalleCompraDTO detalle2 = new DetalleCompraDTO(1 , 2000.0 , 2);
        List<DetalleCompraDTO> listaDetalles = new ArrayList<>(){
            {add(detalle1);add(detalle2);}
        };

        CompraDTO compra = new CompraDTO(MetodoPago.PAGO_EFECTIVO , "1234" , listaDetalles);

        Compra compraPrueba = compraServicio.crearCompra(compra);

        Assertions.assertNotNull(compraPrueba);

        System.out.println(compraPrueba);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComprasUsuario() throws Exception {
        compraServicio.listarComprasUsuario("1234");
    }

}
