/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.ProductDTO;
import com.minibar.proyectobarcito.model.ProductModel;
import com.minibar.proyectobarcito.repository.ProductRepository;

import java.util.ArrayList;
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
    public void addProduct(ProductModel productModel) {
        productModel.setVisible(true);
        productRepository.save(productModel);
    }
    
    @Override
    public ProductDTO getProduct(Long id) {
         ProductDTO productDTO = new ProductDTO();
         ProductModel rP= productRepository.findById(id).orElse(null);
         if(rP != null) {
             productDTO.setName(rP.getName());
             productDTO.setDescription(rP.getDescription());
             productDTO.setPValue(rP.getPValue());
         }
         return productDTO;
    }

    @Override
    public void updateProduct(ProductModel uP) {
        ProductModel productModel = productRepository.findById(uP.getId()).orElse(null);
        if(productModel != null) {
            productModel.setName(uP.getName());
            productModel.setDescription(uP.getDescription());
            productModel.setPValue(uP.getPValue());
            productModel.setVisible(uP.getVisible());
            productRepository.save(productModel);
        }
    }
    
    @Override
    public void deleteProduct(Long id) {
        ProductModel dP = productRepository.findById(id).orElse(null);
        //productRepository.deleteById(id);
        if(dP != null)
            dP.setVisible(false);
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO;
        for(ProductModel pM: productRepository.findAll())
        {
            if(pM.getVisible()) {
                productDTO = new ProductDTO();
                productDTO.setName(pM.getName());
                productDTO.setDescription(pM.getDescription());
                productDTO.setPValue(pM.getPValue());
                productDTOList.add(productDTO);
            }
        }
        return productDTOList;
    }
}
