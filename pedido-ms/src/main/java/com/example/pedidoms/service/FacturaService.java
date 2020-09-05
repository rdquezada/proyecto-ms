/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.service;

import com.example.pedidoms.entity.Factura;
import java.util.List;

/**
 *
 * @author Rubén
 */
public interface FacturaService {

    public List<Factura> findFacturaAll();

    public Factura createFactura(Factura factura);

    public Factura updateFactura(Factura factura);

    public Factura deleteFactura(Factura factura);

    public Factura getFactura(Long id);
}
