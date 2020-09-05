/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pedidoms.repository;

import com.example.pedidoms.entity.FacturaItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rubén
 */
public interface FacturaItemsRepository extends JpaRepository<FacturaItem,Long> {

}
