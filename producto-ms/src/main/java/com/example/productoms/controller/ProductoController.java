/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.productoms.controller;

import com.example.productoms.entity.Categoria;
import com.example.productoms.entity.Producto;
import com.example.productoms.repository.ProductoRepository;
import com.example.productoms.service.ProductoService;
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
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    //Lista todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> listAllProducto(@RequestParam(name = "categoriaId", required = false) Long categoriaId) {
        List<Producto> productos = new ArrayList<>();
        if (null == categoriaId) {
            productos = productoService.listAllProducto();
            if (productos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            productos = productoService.findProductoByCategoria(Categoria.builder().id(categoriaId).build());
            if (productos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(productos);
    }

    //Busca por el id del producto
    @GetMapping(value = "/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable("id") Long id) {
        Producto producto = productoService.getProducto(id);
        if (null == producto) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    //Crea producto
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto productoCreado = productoService.createProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    //Actualiza producto
    @PutMapping(value = "/{productoId}")
    public ResponseEntity<Producto> updateProducto(@PathVariable("productoId") Long productoId, @RequestBody Producto producto) {
        producto.setId(productoId);
        Producto productoDB = productoService.updateProducto(producto);
        if (productoDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoDB);
    }

    //Elimina producto
    @DeleteMapping(value = "{productoId}")
    public ResponseEntity<Void> deleteProducto(@PathVariable("productoId") Long productoId) {
        productoRepository.deleteById(productoId);
        return ResponseEntity.ok(null);
    }

    /*@DeleteMapping(value = "/{productoId}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable("productoId") Long productoId){
        Producto productoEliminado = productoService.deleteProducto(productoId);
        if (productoEliminado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoEliminado);
    }*/
}
