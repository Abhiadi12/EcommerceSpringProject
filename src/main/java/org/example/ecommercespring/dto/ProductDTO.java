package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private  int id;
    private String title;
    private String image;
    private int price;
    private String description;
    private String brand;
    private String model;
    private  String color;
    private String category;
    private  int discount;
    private boolean onSale;
}
