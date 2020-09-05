package com.example.productoms;

import com.example.productoms.entity.Categoria;
import com.example.productoms.entity.Producto;
import com.example.productoms.repository.ProductoRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductoMsApplicationTests {
    @Autowired
    private ProductoRepository productoRepository;

    //Prueba de Insertar Producto
    //Buscar por Categoria
    /*@Test
    public void test() {
        Producto producto1 = Producto.builder()
                .nombre("Carne de pollo")
                .descripcion("Es de categoria carnes")
                .categoria(Categoria.builder().id(1L).build())
                .precio(2.3)
                .estado("CREADO").build();
        productoRepository.save(producto1);
        List<Producto> lista = productoRepository.findByCategoria(producto1.getCategoria());

        Assertions.assertThat(lista.size()).isEqualTo(3);
    }*/
    
    //Prueba de listar todos los productos
    @Test
    public void test2() {
        assertEquals(5, productoRepository.findAll().size());
        //assertThat(usuarioRepository.findAll()).hasSize(3);
    }

}
