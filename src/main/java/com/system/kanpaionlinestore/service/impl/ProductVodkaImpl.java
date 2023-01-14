package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductTobacco;
import com.system.kanpaionlinestore.entity.ProductVodka;
import com.system.kanpaionlinestore.pojo.ProductTobaccoPojo;
import com.system.kanpaionlinestore.pojo.ProductVodkaPojo;
import com.system.kanpaionlinestore.repo.ProductVodkaRepo;
import com.system.kanpaionlinestore.service.ProductVodkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductVodkaImpl implements ProductVodkaService {
    public final ProductVodkaRepo productVodkaRepo;

    @Override
    public List<ProductVodka> fetchAll() {
        return this.productVodkaRepo.findAll();
    }
    @Override
    public String save(ProductVodkaPojo productVodkaPojo) {
        ProductVodka productVodka=new ProductVodka();
        if(productVodka.getId()!=null){
            productVodka.setId(productVodkaPojo.getId());
        }
        productVodka.setProduct_name(productVodkaPojo.getProduct_name());
        productVodka.setProduct_quantity(productVodkaPojo.getProduct_quantity());
        productVodka.setProduct_price(productVodkaPojo.getProduct_price());

        productVodkaRepo.save(productVodka);
        return "created";
    }
}
