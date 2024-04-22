package org.ecommerce.products.repo;

import org.ecommerce.products.model.Products;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    public static List<Products> productList = new ArrayList<>();

    public void createProducts(){
        productList = List.of(
                new Products(1,"Product 1", 15.00,"Desc 1","Category 1","URL 1" ),
                new Products(2,"Product 2", 15.00,"Desc 2","Category 2","URL 2" ),
                new Products(3,"Product 3", 15.00,"Desc 3","Category 3","URL 3" )
        );
    }

    public Products addProducts(Products p){
        productList.add(p);
        return p;
    }

    public List<Products> getAllProducts(){
        return productList;
    }


    public Products getProductbyId(int productId){
        Optional<Products> productOptional = productList.stream()
                .filter(product -> product.getId() == productId)
                .findFirst();
        return productOptional.orElse(null);
    }

    public List<Products> searchbyProductName(String name){
        return  productList.stream()
                .filter(product -> product.getTitle().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Products updateProducts(int id, Products p){

        Products pr = getProductbyId(id);
        pr.setCategory(p.getCategory()!=null?p.getCategory():pr.getCategory());
        pr.setDesc(p.getDesc()!=null?p.getDesc():pr.getDesc());
        pr.setTitle(p.getTitle()!=null?p.getTitle():pr.getTitle());
        pr.setPrice(p.getPrice()!=0?p.getPrice():pr.getPrice());
        pr.setImage_url(p.getImage_url()!=null?p.getImage_url():pr.getImage_url());

        return pr;
    }




}
