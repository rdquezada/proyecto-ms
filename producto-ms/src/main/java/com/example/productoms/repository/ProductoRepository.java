/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.productoms.repository;

import com.example.productoms.entity.Categoria;
import com.example.productoms.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rubén
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public List<Producto> findByCategoria(Categoria categoria);
}
