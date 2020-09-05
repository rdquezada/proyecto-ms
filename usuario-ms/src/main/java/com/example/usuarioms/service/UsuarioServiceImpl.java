/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.usuarioms.service;

import com.example.usuarioms.entity.Region;
import com.example.usuarioms.entity.Usuario;
import com.example.usuarioms.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rubén
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listAllUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findUsuarioByRegion(Region region) {
        return usuarioRepository.findByRegion(region);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario usuarioDB = usuarioRepository.findByCedula(usuario.getCedula());
        if (usuarioDB != null) {
            return usuarioDB;
        }

        usuario.setEstado("CREADO");
        usuarioDB = usuarioRepository.save(usuario);
        return usuarioDB;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario usuarioDB = getUsuario(usuario.getId());
        if (usuarioDB == null) {
            return null;
        }
        usuarioDB.setNombre(usuario.getNombre());
        usuarioDB.setApellido(usuario.getApellido());
        usuarioDB.setEmail(usuario.getEmail());

        return usuarioRepository.save(usuarioDB);
    }

    @Override
    public Usuario deleteUsuario(Usuario usuario) {
        Usuario usuarioDB = getUsuario(usuario.getId());
        if (usuarioDB == null) {
            return null;
        }
        usuario.setEstado("ELIMINADO");
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

}
