package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.Product;
import com.system.kanpaionlinestore.entity.ProductCart;
import com.system.kanpaionlinestore.pojo.ProductCartPojo;
import com.system.kanpaionlinestore.repo.ProductCartRepo;
import com.system.kanpaionlinestore.repo.ProductRepo;
import com.system.kanpaionlinestore.repo.UserRepo;
import com.system.kanpaionlinestore.service.ProductCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductCartServices implements ProductCartService {
    private final UserRepo userRepo;
    private final ProductCartRepo productCartRepo;
    private final ProductRepo productRepo;

    @Override
    public List<ProductCart> fetchAll() {
        return this.productCartRepo.findAll();
    }

    @Override
    public ProductCartPojo save(ProductCartPojo productCartPojo) {
        ProductCart productCart = new ProductCart();
        if(productCartPojo.getId()!=null){
            productCart.setId(productCartPojo.getId());
        }
        productCart.setProduct(productRepo.findById(productCartPojo.getProduct_id()).orElseThrow());
        productCart.setUser(userRepo.findById(productCartPojo.getUser_id()).orElseThrow());
        productCartRepo.save(productCart);
        return new ProductCartPojo();
    }

    @Override
    public ProductCart fetchOne(Integer id) {
        return productCartRepo.findById(id).orElseThrow();
    }

    @Override
    public void deleteFromCart(Integer id) {
        productCartRepo.deleteById(id);
    }

    @Override
    public String updateQuantity(ProductCart productCart) {
        productCartRepo.save(productCart);
        return "Updated";
    }

    @Override
    public List<ProductCart> fetchAll(Integer id) {
        return findAllInList(productCartRepo.findAll());
    }
    public List<ProductCart> findAllInList(List<ProductCart> list){
        Stream<ProductCart> allCart=list.stream().map(productCart ->
                        ProductCart.builder()
                                .id(productCart.getId())
                                .product(productCart.getProduct())
                                .user(productCart.getUser())
                                .build()
        );

        list = allCart.toList();
        return list;
    }
    public Long countRows() {
        return productCartRepo.countAllRows();
    }
}
