/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.client;

import com.example.pedidoms.model.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Rubén
 */
@FeignClient(name = "producto-ms")
@RequestMapping("/productos")
public interface ProductoClient {
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable("id") Long id);
}
