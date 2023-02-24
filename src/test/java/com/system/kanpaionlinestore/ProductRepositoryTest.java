package com.system.kanpaionlinestore;

import com.system.kanpaionlinestore.entity.Product;
import com.system.kanpaionlinestore.repo.ProductRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTest {
    @Autowired
    private ProductRepo productRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveProducts() {

        Product product = Product.builder()
                .name("whiskey")
                .quantity("1")
                .price("8000")
                .build();
//
        productRepo.save(product);
        Assertions.assertThat(product.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getProductTest() {
        Product product = productRepo.findById(1).get();
        Assertions.assertThat(product.getId()).isEqualTo(1);
    }

    //
    @Test
    @Order(3)
    public void fetchAll() {
        List<Product> products = productRepo.findAll();
        Assertions.assertThat(products.size()).isGreaterThan(0);
    }
    //
    @Test
    @Order(4)
    @Rollback(value = false)
    public void Update() {
        Product product = productRepo.findById(1).get();
        product.setName("whiskey");
        Product product1 = productRepo.save(product);
        Assertions.assertThat(product1.getName()).isEqualTo("whiskey");
    }
    //
    @Test
    @Order(5)
    @Rollback(value = false)
    public void Delete(){
        Product product =productRepo.findById(1).get();
        productRepo.delete(product);
        Product product1=null;
        Optional<Product> productOptional=productRepo.findByName(product1.getName());
        if(productOptional.isPresent()){
            product1 = productOptional.get();
        }
        Product product2=productRepo.save(product);
        Assertions.assertThat(product2).isNull();
    }
}
