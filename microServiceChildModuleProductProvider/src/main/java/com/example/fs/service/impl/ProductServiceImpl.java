package com.example.fs.service.impl;

import com.example.fs.mapper.ProductMapper;
import com.example.fs.model.Product;
import com.example.fs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public Product findById(Long pid) {
        return productMapper.findById(pid);
    }
}
