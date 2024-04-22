package org.ecommerce.products.service;

import org.ecommerce.products.dto.ProductDto;
import org.ecommerce.products.exceptions.ProductNotFoundException;
import org.ecommerce.products.model.Products;
import org.ecommerce.products.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService{


    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {

        RestTemplate restTemplate = new RestTemplate();
        String ResourceUrl = "https://fakestoreapi.com/products/";
        ProductDto[] products = restTemplate.getForObject(ResourceUrl, ProductDto[].class);

        List<ProductDto> products1 = new ArrayList<>();

        for(ProductDto p:products){
            products1.add(p);
        }
        return products1;
    }

    @Override
    public Products getbyProductID(int id) throws ProductNotFoundException {

        RestTemplate restTemplate = new RestTemplate();
        String ResourceUrl = "https://fakestoreapi.com/products/"+id;
        Products foo = restTemplate.getForObject(ResourceUrl, Products.class);
        if(foo==null){
            throw new ProductNotFoundException();
        }
        return foo;
    }

    @Override
    public Products addProduct(Products p) {
        logger.info("Product Created: "+p);
        return productRepository.addProducts(p);
    }

    @Override
    public Products updateProduct(int id, Products p) {
        logger.info("Product Updated: "+p);
        return productRepository.updateProducts(id,p);
    }

    @Override
    public List<Products> searchProductbyName(String name) {
        return productRepository.searchbyProductName(name);
    }


}
