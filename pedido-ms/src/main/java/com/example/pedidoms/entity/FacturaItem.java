/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.entity;

import com.example.pedidoms.model.Producto;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Rubén
 */
@Entity
@Table(name = "facturas_items")
@Data
public class FacturaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double cantidad;
    private Double precio;

    @Column(name = "id_producto")
    private Long productoId;

    @Transient
    private Double subTotal;

    @Transient
    private Producto producto;
    
    public Double getSubTotal() {
        if (this.precio > 0 && this.cantidad > 0) {
            return this.cantidad * this.precio;
        } else {
            return (double) 0;
        }
    }

    public FacturaItem() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;

    }
}
