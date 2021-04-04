package com.inventory.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
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
            productRepository.saveAll(List.of(Iphone12, IphoneS));
        };

    }
}
