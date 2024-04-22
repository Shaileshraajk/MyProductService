package org.ecommerce.products.service;

import org.ecommerce.products.dto.ProductDto;
import org.ecommerce.products.exceptions.ProductNotFoundException;
import org.ecommerce.products.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    List<ProductDto>  getAllProducts();
    Products getbyProductID(int id) throws ProductNotFoundException;

    Products addProduct(Products p);

    Products updateProduct(int id, Products p);

    List<Products> searchProductbyName(String name);


}
