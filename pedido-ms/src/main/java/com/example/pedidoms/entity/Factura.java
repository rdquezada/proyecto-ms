/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.entity;

import com.example.pedidoms.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import lombok.Data;

/**
 *
 * @author Rubén
 */
@Entity
@Table(name = "facturas")
@Data
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_factura")
    private String numeroFactura;

    private String descripcion;

    @Column(name = "id_usuario")
    private Long usuarioId;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    //@Valid
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_factura")
    private List<FacturaItem> items;

    private String estado;

    @Transient //No se va a guardar en la BD
    private Usuario usuario;
    
    public Factura() {
        items = new ArrayList<>();
    }

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = new Date();
    }

}
