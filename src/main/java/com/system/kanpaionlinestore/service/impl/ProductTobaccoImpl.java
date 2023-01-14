package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductTobacco;
import com.system.kanpaionlinestore.pojo.ProductTobaccoPojo;
import com.system.kanpaionlinestore.repo.ProductTobaccoRepo;
import com.system.kanpaionlinestore.service.ProductTobaccoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTobaccoImpl implements ProductTobaccoService {
    public final ProductTobaccoRepo productTobaccoRepo;

    @Override
    public List<ProductTobacco> fetchAll() {
        return this.productTobaccoRepo.findAll();
    }
    @Override
    public String save(ProductTobaccoPojo productTobaccoPojo) {
        ProductTobacco productTobacco=new ProductTobacco();
        if(productTobacco.getId()!=null){
            productTobacco.setId(productTobaccoPojo.getId());
        }
        productTobacco.setProduct_name(productTobaccoPojo.getProduct_name());
        productTobacco.setProduct_quantity(productTobaccoPojo.getProduct_quantity());
        productTobacco.setProduct_price(productTobaccoPojo.getProduct_price());

        productTobaccoRepo.save(productTobacco);
        return "created";
    }
}
