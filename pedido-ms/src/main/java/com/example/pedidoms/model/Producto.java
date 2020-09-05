/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.model;

import lombok.Data;

/**
 *
 * @author Rubén
 */
@Data
public class Producto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String estado;
    private Categoria categoria;

}
