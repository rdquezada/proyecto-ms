/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.productoms.service;

import com.example.productoms.entity.Categoria;
import com.example.productoms.entity.Producto;
import com.example.productoms.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rubén
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto createProducto(Producto producto) {
        producto.setEstado("CREADO");
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Producto productoDB = getProducto(producto.getId());
        if (null == productoDB) {
            return null;
        }
        productoDB.setNombre(producto.getNombre());
        productoDB.setDescripcion(producto.getDescripcion());
        productoDB.setCategoria(producto.getCategoria());
        productoDB.setPrecio(producto.getPrecio());
        return productoRepository.save(productoDB);
    }

    @Override
    public Producto deleteProducto(Long id) {
        Producto productoDB = getProducto(id);
        if (null == productoDB) {
            return null;
        }
        productoDB.setEstado("ELIMINADO");
        return productoRepository.save(productoDB);
    }

    @Override
    public List<Producto> findProductoByCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }

}
