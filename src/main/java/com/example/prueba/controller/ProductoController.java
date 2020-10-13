/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.controller;

import com.example.prueba.model.Producto;
import com.example.prueba.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MV-06
 */
@Controller
public class ProductoController {
    
    @Autowired
    private  ProductoService service;
    
    @GetMapping({"/","/login"})
    public String index(){
        return "login";
    }
    
    @RequestMapping("/list")
     public String viewHomePage(Model model) {
        List<Producto> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        System.out.println("lista"+listProducts.size());
        return "listaProducto";
    }
     @RequestMapping("/nuevop")
    public String NuevoProducto(Model model) {
    Producto product = new Producto();
    model.addAttribute("product", product);
     
    return "CrearProducto";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
      public String saveProduct(@ModelAttribute("product") Producto product) {
      service.save(product);
     
      return "listaProducto";
      
   }
    @RequestMapping("/editar/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
    ModelAndView mav = new ModelAndView("editarProducto");
    Producto product = service.get(id);
    mav.addObject("product", product);
     
    return mav;
   }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
    service.delete(id);
    return "redirect:/list";  
}
}
