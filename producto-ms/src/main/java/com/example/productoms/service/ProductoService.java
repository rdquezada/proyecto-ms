/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.productoms.service;

import com.example.productoms.entity.Categoria;
import com.example.productoms.entity.Producto;
import java.util.List;

/**
 *
 * @author Rubén
 */
public interface ProductoService {

    public List<Producto> listAllProducto();

    public Producto getProducto(Long id);

    public Producto createProducto(Producto producto);

    public Producto updateProducto(Producto producto);

    public Producto deleteProducto(Long id);

    public List<Producto> findProductoByCategoria(Categoria categoria);

}
