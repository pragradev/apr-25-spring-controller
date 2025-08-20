package com.example.javaapr2025springcontroller.service;

import com.example.javaapr2025springcontroller.entity.Product;
import com.example.javaapr2025springcontroller.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProduct(){
        // fetch from database - DAO/Repository
        return productRepo.getALlProducts();
    }
}
