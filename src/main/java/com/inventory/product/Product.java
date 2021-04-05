package com.inventory.product;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name="product-sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String name;
    private String brand;
    private String origin;
    private Integer price;

    public Product() {
    }

    public Product(Long id, String name, String brand, String origin, Integer price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.origin = origin;
        this.price = price;
    }

    public Product(String name, String brand, String origin, Integer price) {
        this.name = name;
        this.brand = brand;
        this.origin = origin;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                '}';
    }
}
