/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.service;

import com.example.prueba.model.Producto;
import com.example.prueba.repository.ProductoRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MV-06
 */
@Service
@Transactional
public class ProductoService {
    
    @Autowired
    private ProductoRepository repo;
    
    public List<Producto> listAll() {
        return  repo.findAll();
    }
     
    public void save(Producto producto) {
        repo.save(producto);
    }
     
    public Producto get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
