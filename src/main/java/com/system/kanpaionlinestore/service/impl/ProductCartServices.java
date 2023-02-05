package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductCart;
import com.system.kanpaionlinestore.pojo.ProductCartPojo;
import com.system.kanpaionlinestore.repo.ProductCartRepo;
import com.system.kanpaionlinestore.service.ProductCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCartServices implements ProductCartService {
    private final ProductCartRepo productCartRepo;

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

//    @Override
//    public String saveToCart(Integer id, Principal principal) {
//        ProductCart productCart = new ProductCart();
//
//        productCart.setProduct(productCartRepo.findById(id).orElseThrow().getProduct());
//        productCart.setName(productCart.getName());
//        productCart.setQuantity(1);
//        productCart.setPrice(productCart.getPrice());
//        ProductCartRepo.save(productCart);
//        return "Saved";
//    }
}
