package org.ecommerce.products.model;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    private int id;
    private  String title;
    private double price;
    private String desc;
    private String category;
    private String image_url;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", category='" + category + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
