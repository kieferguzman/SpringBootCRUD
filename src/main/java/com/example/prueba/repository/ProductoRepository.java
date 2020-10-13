/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.repository;

import com.example.prueba.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author MV-06
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
