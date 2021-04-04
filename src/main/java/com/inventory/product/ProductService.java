package com.inventory.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addNewProduct(Product product){
        productRepository.save(product);

    }

    public void deleteProduct(Long id) {
        boolean exits = productRepository.existsById(id);
        if (!exits) {
            throw new IllegalStateException(
                    "product with id" + id + " does not exit"
            );
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(Long id,
                              String name,
                              String brand,
                              String origin,
                              Integer price) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id" + id + " does not exit"
        ));

        if (name != null && name.length() > 0 &&
        !Objects.equals(product.getName(), name)){
            product.setName(name);
        }

        if (brand != null && brand.length() > 0 &&
                !Objects.equals(product.getBrand(), brand)){
            product.setBrand(brand);
        }

        if (origin != null && origin.length() > 0 &&
                !Objects.equals(product.getOrigin(), origin)){
            product.setOrigin(origin);
        }

        if (price != null && price.longValue() > 0 &&
                !Objects.equals(product.getPrice(), price)){
            product.setPrice(price);
        }
    }
}
