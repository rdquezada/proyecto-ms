package com.example.usuarioms;

import com.example.usuarioms.entity.Region;
import com.example.usuarioms.entity.Usuario;
import com.example.usuarioms.repository.UsuarioRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioMsApplicationTests {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Prueba de Insertar Usuario
    //Buscar por Region
    /*@Test
    public void test() {
        Usuario usuario1 = Usuario.builder()
                .cedula("9889765612")
                .nombre("Freddy")
                .apellido("Pineda")
                .region(Region.builder().id(3L).build())
                .email("freddy@gmail.com")
                .estado("CREADO").build();
        usuarioRepository.save(usuario1);
        List<Usuario> lista = usuarioRepository.findByRegion(usuario1.getRegion());

        Assertions.assertThat(lista.size()).isEqualTo(3);
    }*/
    
    //Prueba de listar todos los usuarios
    @Test
    public void test2() {
        assertEquals(9, usuarioRepository.findAll().size());
        //assertThat(usuarioRepository.findAll()).hasSize(3);
    }

}
