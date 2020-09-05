/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.controller;

import com.example.pedidoms.entity.Factura;
import com.example.pedidoms.repository.FacturaRepository;
import com.example.pedidoms.service.FacturaService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rubén
 */
@Slf4j
@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    FacturaService facturaService;
    
    @Autowired
    FacturaRepository facturaRepository;

    //Recuperar todas las facturas
    @GetMapping
    public ResponseEntity<List<Factura>> listAllFactura() {
        List<Factura> facturas = facturaService.findFacturaAll();
        if (facturas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(facturas);
    }

    // Recuperar factura única
    @GetMapping(value = "/{id}")
    public ResponseEntity<Factura> getFactura(@PathVariable("id") long id) {
        Factura factura = facturaService.getFactura(id);
        if (null == factura) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(factura);
    }

    // Crear factura
    @PostMapping
    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
        Factura facturaDB = facturaService.createFactura(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaDB);
    }

    // Actualizar factura
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateFactura(@PathVariable("id") long id, @RequestBody Factura factura) {
        factura.setId(id);
        Factura facturaActual = facturaService.updateFactura(factura);

        if (facturaActual == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaActual);
    }

    //Eliminar factura
    @DeleteMapping(value = "{facturaId}")
    public ResponseEntity<Void> deleteFactura(@PathVariable("facturaId") Long facturaId) {
        facturaRepository.deleteById(facturaId);
        return ResponseEntity.ok(null);
    }

}
