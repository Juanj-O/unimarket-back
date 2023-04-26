package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.ImagenDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private ProductoRepo productoRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearProductoTest() throws Exception {

        List<ImagenDTO> imagenes = new ArrayList<>();
        List<Categoria> categorias = null;
        ProductoDTO productoDTO = new ProductoDTO("NintendoTEST", "Gen 2.0", 25.000, 2, "1234", imagenes, categorias);
        int productoGuardado = productoServicio.crearProducto(productoDTO);
        Assertions.assertNotEquals(0, productoGuardado);
        System.out.println(productoGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProductoTest() throws Exception {

        int codigoProducto = 1;
        productoServicio.eliminarProducto(codigoProducto);
        Assertions.assertThrows(Exception.class, () -> productoServicio.obtenerProducto(codigoProducto));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProductoTest() throws Exception {

        List<ImagenDTO> imagenes = new ArrayList<>();
        List<Categoria> categorias = null;
        ProductoDTO productoDTO = new ProductoDTO("NintendoTEST", "Gen 2.0", 25.000, 2, "1234", imagenes, categorias);
        productoServicio.actualizarProducto(1, productoDTO);
        Assertions.assertNotEquals("AUDIFONOS SAMSUNG 158-6685", productoServicio.obtenerProducto(1));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductoTest() throws Exception {
        ProductoGetDTO productoGetDTO = productoServicio.obtenerProducto(1);
        Assertions.assertNotNull(productoGetDTO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidadesTest () throws Exception{
        int unidades = productoServicio.actualizarUnidades(1, 20);
        Assertions.assertEquals(20, unidades);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEstadoProductoTest()throws Exception{
        productoServicio.actualizarProductoEstado(1, true);
        Assertions.assertEquals(true, productoServicio.obtenerProducto(1).isEstado());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosUsuarioTest() throws Exception {
        List<ProductoGetDTO> lista = productoServicio.listarProductosUsuario("1234");
        Assertions.assertEquals(1,lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosFavoritosTest() throws Exception {
        List<ProductoGetDTO> listaProductosFavoritos = productoServicio.listarProductosFavoritos("1234");
        Assertions.assertEquals(1,listaProductosFavoritos.size());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosNombreTest() throws Exception {
        List<ProductoGetDTO> lista = productoServicio.listarProductosNombre("MacBook10,1");
        Assertions.assertEquals(1,lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductoPorPrecio() throws Exception{
        List<ProductoGetDTO> lista = productoServicio.listarProductosPrecio(10000,80000);
        Assertions.assertEquals(2,lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearFavoritoTest() throws Exception{
        String cedulaUsuario = "1234" ;
        int codigoProducto = 1 ;

        productoServicio.crearFavorito(cedulaUsuario, codigoProducto);

        List<ProductoGetDTO> lista = productoServicio.listarProductosFavoritos(cedulaUsuario);
        Assertions.assertEquals(2,lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFavoritoTest() throws Exception{
        productoServicio.eliminarFavorito("1234",1);

        List<ProductoGetDTO> lista = productoServicio.listarProductosFavoritos("1234");
        Assertions.assertEquals(1,lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosEstadoModeradorTest()throws Exception {
        List<ProductoGetDTO> listaProductos = productoServicio.listarProductosEstadoModerador(1, Estado.APROBADO);
        Assertions.assertEquals(1,listaProductos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosMasComprados(){
        Assertions.assertEquals(5 ,productoServicio.listarProductosMasComprados().size());
    }
}
