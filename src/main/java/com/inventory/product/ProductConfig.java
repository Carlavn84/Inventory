package com.inventory.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Autowired
    private ProductRepository productRepository;

    @Bean
    public List<Product> products(){
        Product Iphone12 = new Product(
                    "Iphone12",
                    "Apple",
                    "China",
                    750
            );

        Product IphoneS = new Product(
                    "IphoneS",
                    "Apple",
                    "China",
                    850
            );

        Product Galaxy = new Product(
                "Galaxy",
                "Samsung",
                "China",
                1000
        );

        Product GalaxyS = new Product(
                "GalaxyS",
                "Samsung",
                "China",
                1200
        );

    return productRepository.saveAll(List.of(Iphone12, IphoneS, Galaxy, GalaxyS));
    }
}
