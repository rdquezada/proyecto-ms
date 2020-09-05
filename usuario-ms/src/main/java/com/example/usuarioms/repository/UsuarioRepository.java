/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.usuarioms.repository;

import com.example.usuarioms.entity.Region;
import com.example.usuarioms.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rubén
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public Usuario findByCedula(String cedula);
    public List<Usuario> findByApellido(Region apellido);
    public List<Usuario> findByRegion(Region region);

}
