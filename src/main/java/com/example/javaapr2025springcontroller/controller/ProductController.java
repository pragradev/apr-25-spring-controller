package com.example.javaapr2025springcontroller.controller;

import com.example.javaapr2025springcontroller.entity.Product;
import com.example.javaapr2025springcontroller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){

        return productService.getAllProduct();
    }
}
