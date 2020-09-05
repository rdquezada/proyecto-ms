/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.repository;

import com.example.pedidoms.entity.Factura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rubén
 */
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    public List<Factura> findByUsuarioId(Long usuarioId);

    public Factura findByNumeroFactura(String numeroFactura);

}
