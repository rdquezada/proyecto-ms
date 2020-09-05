/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.client;

import com.example.pedidoms.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Rubén
 */
@FeignClient(name = "usuario-ms", fallback = UsuarioHystrixFallbackFactory.class)
//@FeignClient(name = "usuario-ms")
//@RequestMapping("/usuarios")
public interface UsuarioClient {

    @GetMapping(value = "/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") long id);
}
