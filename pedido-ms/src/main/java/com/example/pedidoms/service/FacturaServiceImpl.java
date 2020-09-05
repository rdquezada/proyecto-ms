/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.service;

import com.example.pedidoms.client.ProductoClient;
import com.example.pedidoms.client.UsuarioClient;
import com.example.pedidoms.entity.Factura;
import com.example.pedidoms.entity.FacturaItem;
import com.example.pedidoms.model.Producto;
import com.example.pedidoms.model.Usuario;
import com.example.pedidoms.repository.FacturaItemsRepository;
import com.example.pedidoms.repository.FacturaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rubén
 */
@Slf4j
@Service
public class FacturaServiceImpl implements FacturaService {
    
    @Autowired
    FacturaRepository facturaRepository;
    
    @Autowired
    FacturaItemsRepository facturaItemsRepository;
    
    @Autowired
    UsuarioClient usuarioClient;
    
    @Autowired
    ProductoClient productoClient;
    
    @Override
    public List<Factura> findFacturaAll() {
        return facturaRepository.findAll();
    }
    
    @Override
    public Factura createFactura(Factura factura) {
        Factura facturaDB = facturaRepository.findByNumeroFactura(factura.getNumeroFactura());
        if (facturaDB != null) {
            return facturaDB;
        }
        factura.setEstado("CREADO");
        facturaDB = facturaRepository.save(factura);
        //facturaDB.getItems().forEach( invoiceItem -> {
        //    productClient.updateStockProduct( invoiceItem.getProductId(), invoiceItem.getQuantity() * -1);
        //});

        //return facturaRepository.save(factura);
        return facturaDB;
    }
    
    @Override
    public Factura updateFactura(Factura factura) {
        Factura facturaDB = getFactura(factura.getId());
        if (facturaDB == null) {
            return null;
        }
        facturaDB.setUsuarioId(factura.getUsuarioId());
        facturaDB.setDescripcion(factura.getDescripcion());
        facturaDB.setNumeroFactura(factura.getNumeroFactura());
        facturaDB.getItems().clear();
        facturaDB.setItems(factura.getItems());
        return facturaRepository.save(facturaDB);
    }
    
    @Override
    public Factura deleteFactura(Factura factura) {
        Factura facturaDB = getFactura(factura.getId());
        if (facturaDB == null) {
            return null;
        }
        facturaDB.setEstado("ELIMINADO");
        return facturaRepository.save(facturaDB);
    }
    
    /*@Override
    public Factura getFactura(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }*/
    
    @Override
    public Factura getFactura(Long id) {
        Factura factura= facturaRepository.findById(id).orElse(null);
        if (null != factura ){
            Usuario usuario = usuarioClient.getUsuario(factura.getUsuarioId()).getBody();
            factura.setUsuario(usuario);
            List<FacturaItem> listItem=factura.getItems().stream().map(facturaItem -> {
                Producto producto = productoClient.getProducto(facturaItem.getProductoId()).getBody();
                facturaItem.setProducto(producto);
                return facturaItem;
            }).collect(Collectors.toList());
            factura.setItems(listItem);
        }
        return factura;
    }
    
}
