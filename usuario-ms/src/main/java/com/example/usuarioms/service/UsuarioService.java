/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.usuarioms.service;

import com.example.usuarioms.entity.Region;
import com.example.usuarioms.entity.Usuario;
import java.util.List;

/**
 *
 * @author Rubén
 */
public interface UsuarioService {

    public List<Usuario> listAllUsuario();

    public List<Usuario> findUsuarioByRegion(Region region);

    public Usuario createUsuario(Usuario usuario);

    public Usuario updateUsuario(Usuario usuario);

    public Usuario deleteUsuario(Usuario usuario);

    public Usuario getUsuario(Long id);

}
