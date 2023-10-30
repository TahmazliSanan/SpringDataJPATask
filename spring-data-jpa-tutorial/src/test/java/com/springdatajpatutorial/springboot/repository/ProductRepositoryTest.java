package com.springdatajpatutorial.springboot.repository;

import com.springdatajpatutorial.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // Create entity
        Product product = new Product();
        product.setName("Product 1");
        product.setSku("100ABC");
        product.setDescription("This is a Product 1");
        product.setPrice(new BigDecimal(1000));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // Save entity
        Product savedProduct = productRepository.save(product);

        // Display entity info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        // Find or retrieve on entity by id
        Product foundedProduct = productRepository.findById(1L).get();

        // Update entity info
        foundedProduct.setName("Updated Product 1");
        foundedProduct.setSku("Updated 100ABC");
        foundedProduct.setDescription("Updated This is a Product 1");
        foundedProduct.setPrice(new BigDecimal(2000));
        foundedProduct.setActive(true);
        foundedProduct.setImageUrl("Updated product1.png");

        // Save updated entity
        productRepository.save(foundedProduct);
    }

    @Test
    void findByIdMethod() {
        Product foundedProduct = productRepository.findById(1L).get();
    }

    @Test
    void saveAllMethod() {
        // Create entity
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setSku("102ABC");
        product2.setDescription("This is a Product 2");
        product2.setPrice(new BigDecimal(1500));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setSku("103ABC");
        product3.setDescription("This is a Product 3");
        product3.setPrice(new BigDecimal(2500));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        // Save all entities
        productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    void findAllMethod() {
        List<Product> productList = productRepository.findAll();
        productList.forEach((product -> {
            System.out.println(product.getName());
        }));
    }

    @Test
    void deleteByIdMethod() {
        productRepository.deleteById(3L);
    }

    @Test
    void deleteMethod() {
        Product foundedProduct = productRepository.findById(1L).get();
        productRepository.delete(foundedProduct);
    }

    @Test
    void deleteAllMethod() {
        List<Product> productList = productRepository.findAll();
        productRepository.deleteAll(productList);
    }

    @Test
    void countMethod() {
        System.out.println(productRepository.count());
    }

    @Test
    void existByIdMethod() {
        System.out.println(productRepository.existsById(1L));
    }

    @Test
    void findByCreatedDateBetweenMethod() {
        LocalDateTime beginDate = LocalDateTime.of(2023, 10, 30, 22, 1, 56);
        LocalDateTime endDate = LocalDateTime.of(2023, 10, 30, 22, 1, 57);
        List<Product> productList = productRepository.findByCreatedDateBetween(beginDate, endDate);
        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }
}