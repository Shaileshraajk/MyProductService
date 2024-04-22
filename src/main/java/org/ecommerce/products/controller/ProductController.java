package org.ecommerce.products.controller;

import org.ecommerce.products.dto.ProductDto;
import org.ecommerce.products.exceptions.ProductNotFoundException;
import org.ecommerce.products.model.Products;
import org.ecommerce.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductDto>  getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public @ResponseBody  Products getbyProductId(@PathVariable int id) throws ProductNotFoundException {
        return productService.getbyProductID(id);
    }

    @GetMapping("/search")
    public List<Products> searchbyProductName(@RequestParam String name){
        return productService.searchProductbyName(name);
    }

    @PostMapping("/add")
    public Products addProducts(@RequestBody Products p){
        return productService.addProduct(p);
    }

    @PutMapping("/{id}")
    public Products updateProducts(@PathVariable int id, @RequestBody Products p){
        return productService.updateProduct(id,p);
    }





}
