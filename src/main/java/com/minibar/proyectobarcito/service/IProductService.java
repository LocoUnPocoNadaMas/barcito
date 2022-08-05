/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.model.Product;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IProductService {

    public void addProduct(Product product);
    
    public Product getProduct(Long id);
    
    public void updateProduct(Long id, String nName, String nDesc, Float nValue);

    public void deleteProduct(Long id);

    public List<Product> getProducts();
    
}
