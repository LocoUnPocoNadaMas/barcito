/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.controller;

import com.minibar.proyectobarcito.dto.ProductDTO;
import com.minibar.proyectobarcito.model.ProductModel;
import com.minibar.proyectobarcito.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<List<ProductDTO>> showMenu(){

        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }/*
    public void showMenu(){
        productService.getProducts2();
    }*/
    
    @PostMapping("/agregar")
    public ResponseEntity<Void> addProduct(@RequestBody @Validated ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        // Responde con el objeto o un error...
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    /*
    @PutMapping("/editar/{id}")
    public void updateProduct(@PathVariable Long id,
            @RequestParam ("name") String nName,
            @RequestParam ("description") String nDesc,
            @RequestParam ("pvalue") Float nValue) {
        
        //productService.updateProduct(id, nName, nDesc, nValue);
    }*/

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> updateProduct(@RequestBody @Validated ProductModel productModel) {
        productService.updateProduct(productModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
