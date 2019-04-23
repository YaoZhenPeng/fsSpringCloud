package com.example.fs.controller;

import com.example.fs.model.Product;
import com.example.fs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/get/{id}",method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        System.out.println("lsjdfs");
        return productService.findById(id);
    }
}
