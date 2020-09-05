 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.model;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Rubén
 */
@Data
@Builder
public class Usuario {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String estado;
    private Region region;

}
