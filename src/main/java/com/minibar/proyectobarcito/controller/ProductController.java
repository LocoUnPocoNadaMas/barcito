/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.controller;

import com.minibar.proyectobarcito.model.Product;
import com.minibar.proyectobarcito.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */

@RestController
@RequestMapping("/producto")
public class ProductController {
    
    @Autowired
    IProductService productService;
    
    @GetMapping("")
    @ResponseBody
    public List<Product> showMenu(){
        return productService.getProducts();
    }
    
    @PostMapping("/agregar")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    
    @GetMapping("/buscar/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }
    
    @PutMapping("/editar/{id}")
    public void updateProduct(@PathVariable Long id,
            @RequestParam ("name") String nName,
            @RequestParam ("description") String nDesc,
            @RequestParam ("pvalue") Float nValue) {
        
        productService.updateProduct(id, nName, nDesc, nValue);
    }
    
    @DeleteMapping("/borrar/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
}
