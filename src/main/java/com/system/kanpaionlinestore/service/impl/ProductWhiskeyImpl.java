package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductWhiskey;
import com.system.kanpaionlinestore.pojo.ProductWhiskeyPojo;
import com.system.kanpaionlinestore.repo.ProductWhiskeyRepo;
import com.system.kanpaionlinestore.service.ProductWhiskeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductWhiskeyImpl implements ProductWhiskeyService {
    public final ProductWhiskeyRepo productWhiskeyRepo;

    @Override
    public List<ProductWhiskey> fetchAll() {
        return this.productWhiskeyRepo.findAll();
    }
    @Override
    public String save(ProductWhiskeyPojo productWhiskeyPojo) {
        ProductWhiskey productWhiskey=new ProductWhiskey();
        if(productWhiskey.getId()!=null){
            productWhiskey.setId(productWhiskeyPojo.getId());
        }
        productWhiskey.setProduct_name(productWhiskeyPojo.getProduct_name());
        productWhiskey.setProduct_quantity(productWhiskeyPojo.getProduct_quantity());
        productWhiskey.setProduct_price(productWhiskeyPojo.getProduct_price());

        productWhiskeyRepo.save(productWhiskey);
        return "created";
    }
}
