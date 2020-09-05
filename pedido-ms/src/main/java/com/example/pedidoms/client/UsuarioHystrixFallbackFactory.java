/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.client;

import com.example.pedidoms.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class UsuarioHystrixFallbackFactory implements UsuarioClient {

    @Override
    public ResponseEntity<Usuario> getUsuario(long id) {
        Usuario usuario = Usuario.builder()
                .nombre("none")
                .apellido("none")
                .email("none").build();
        return ResponseEntity.ok(usuario);
    }
}
