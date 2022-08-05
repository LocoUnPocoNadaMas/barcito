/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.model.Product;
import com.minibar.proyectobarcito.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */

@Service
public class ProductService implements IProductService{

    @Autowired
    public ProductRepository productRepository;
    
     @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }
    
     @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
     @Override
    public void updateProduct(Long id, String nName, String nDesc, Float nValue) {
         Product product = getProduct(id);
         product.setName(nName);
         product.setDescription(nDesc);
         product.setPValue(nValue);
         productRepository.save(product);
    }
    
     @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

     @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    
    
}
