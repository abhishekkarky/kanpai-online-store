package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.ProductTobacco;
import com.system.kanpaionlinestore.pojo.ProductTobaccoPojo;

import java.util.List;

public interface ProductTobaccoService {
    String save(ProductTobaccoPojo productTobaccoPojo);

    List<ProductTobacco> fetchAll();
}
