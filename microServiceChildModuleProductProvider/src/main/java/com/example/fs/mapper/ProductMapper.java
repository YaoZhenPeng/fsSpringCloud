package com.example.fs.mapper;

import com.example.fs.model.Product;

public interface ProductMapper {

    Product findById(Long pid);
}
