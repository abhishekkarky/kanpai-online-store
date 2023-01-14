package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductTequila;
import com.system.kanpaionlinestore.pojo.ProductTequilaPojo;
import com.system.kanpaionlinestore.repo.ProductTequilaRepo;
import com.system.kanpaionlinestore.service.ProductTequilaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTequilaImpl implements ProductTequilaService {
    public final ProductTequilaRepo productTequilaRepo;

    @Override
    public List<ProductTequila> fetchAll() {
        return this.productTequilaRepo.findAll();
    }

    @Override
    public String save(ProductTequilaPojo productTequilaPojo) {
        ProductTequila productTequila=new ProductTequila();
        if(productTequila.getId()!=null){
            productTequila.setId(productTequilaPojo.getId());
        }
        productTequila.setProduct_name(productTequilaPojo.getProduct_name());
        productTequila.setProduct_quantity(productTequilaPojo.getProduct_quantity());
        productTequila.setProduct_price(productTequilaPojo.getProduct_price());

        productTequilaRepo.save(productTequila);
        return "created";
    }
}
