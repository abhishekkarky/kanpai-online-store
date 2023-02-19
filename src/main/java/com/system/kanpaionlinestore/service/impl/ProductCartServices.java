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
    public String save(ProductCartPojo productCartPojo) {
        ProductCart productCart = new ProductCart();
        if(productCartPojo.getId()!=null){
            productCart.setId(productCartPojo.getId());
        }
        productCart.setName(productCartPojo.getName());
        productCart.setQuantity(productCartPojo.getQuantity());
        productCart.setPrice(productCartPojo.getPrice());
        productCartRepo.save(productCart);
        return "saved";
    }

    @Override
    public String saveToCart(Integer id, Principal principal) {
        ProductCart productCart = new ProductCart();
        productCart.setUser(userRepo.findByEmail(principal.getName()).orElseThrow());
        productCart.setProduct(productRepo.findById(id).orElseThrow());
        productCart.setName(productCart.getName());
        productCart.setPrice(productCart.getPrice());
        productCart.setQuantity(1);
        productCartRepo.save(productCart);

        return "Saved";
    }

    @Override
    public ProductCart fetchOne(Integer id) {
        return productCartRepo.findById(id).orElseThrow();
    }

    @Override
    public String deleteFromCart(Integer id) {
        productCartRepo.deleteById(id);
        return "Deleted";
    }

    @Override
    public String updateQuantity(ProductCart productCart) {
        productCartRepo.save(productCart);
        return "Updated";
    }

    @Override
    public List<ProductCart> fetchAll(Integer id) {
        List<ProductCart> allItems = productCartRepo.fetchAll(id).orElseThrow();
        for (ProductCart productCart : allItems){
            productCart.setProduct(Product.builder()
                    .id(productCart.getProduct().getId())
                    .quantity(productCart.getProduct().getQuantity())
                    .name(productCart.getProduct().getName())
                    .price(productCart.getProduct().getPrice())
                    .build());
        }
        return allItems;
    }
}
