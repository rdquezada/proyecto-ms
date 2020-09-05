/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.usuarioms.controller;

import com.example.usuarioms.entity.Region;
import com.example.usuarioms.entity.Usuario;
import com.example.usuarioms.repository.UsuarioRepository;
import com.example.usuarioms.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rubén
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Lista todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listAllUsuario(@RequestParam(name = "regionId", required = false) Long regionId) {
        List<Usuario> usuarios = new ArrayList<>();
        if (null == regionId) {
            usuarios = usuarioService.listAllUsuario();
            if (usuarios.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            Region Region = new Region();
            Region.setId(regionId);
            usuarios = usuarioService.findUsuarioByRegion(Region);
            if (null == usuarios) {
                return ResponseEntity.notFound().build();
            }
        }

        return ResponseEntity.ok(usuarios);
    }

    //Busca por el id del usuario
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") long id) {
        Usuario usuario = usuarioService.getUsuario(id);
        if (null == usuario) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    //Crea usuario
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {

        Usuario usuarioDB = usuarioService.createUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDB);
    }

    //Actualiza usuario
    @PutMapping(value = "/{usuarioid}")
    public ResponseEntity<?> updateUsuario(@PathVariable("usuarioid") long usuarioid, @RequestBody Usuario usuario) {
        Usuario usuarioActual = usuarioService.getUsuario(usuarioid);

        if (null == usuarioActual) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(usuarioid);
        usuarioActual = usuarioService.updateUsuario(usuario);
        return ResponseEntity.ok(usuarioActual);
    }

    //Elimina usuario
    @DeleteMapping(value = "{usuarioId}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("usuarioId") Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
        return ResponseEntity.ok(null);
    }
    /*@DeleteMapping(value = "/{usuarioId}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("usuarioId") Long usuarioId) {
        Usuario usuario = usuarioService.getUsuario(usuarioId);
        if (null == usuario) {
            return ResponseEntity.notFound().build();
        }
        usuario = usuarioService.deleteUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }*/

}
