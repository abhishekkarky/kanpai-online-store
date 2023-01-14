package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductWine;
import com.system.kanpaionlinestore.pojo.ProductWinePojo;
import com.system.kanpaionlinestore.repo.ProductWineRepo;
import com.system.kanpaionlinestore.service.ProductWineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductWineImpl implements ProductWineService {
    public final ProductWineRepo productWineRepo;

    @Override
    public List<ProductWine> fetchAll() {
        return this.productWineRepo.findAll();
    }
    @Override
    public String save(ProductWinePojo productWinePojo) {
        ProductWine productWine=new ProductWine();
        if(productWine.getId()!=null){
            productWine.setId(productWinePojo.getId());
        }
        productWine.setProduct_name(productWinePojo.getProduct_name());
        productWine.setProduct_quantity(productWinePojo.getProduct_quantity());
        productWine.setProduct_price(productWinePojo.getProduct_price());

        productWineRepo.save(productWine);
        return "created";
    }
}
