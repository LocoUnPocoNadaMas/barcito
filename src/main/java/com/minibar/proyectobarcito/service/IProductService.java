/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.ProductDTO;
import com.minibar.proyectobarcito.model.ProductModel;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IProductService {

    public void addProduct(ProductDTO productDTO);
    
    public ProductDTO findProduct(Long id);

    public List<ProductDTO> getProducts();

    public List<ProductModel> getAllProducts();
    
    //public void updateProduct(Long id, String nName, String nDesc, Float nValue);
    public void updateProduct(ProductModel productModel);

    public void deleteProduct(Long id);


}
