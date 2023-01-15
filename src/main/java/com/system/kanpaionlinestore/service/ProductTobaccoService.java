package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.ProductTobacco;
import com.system.kanpaionlinestore.pojo.ProductTobaccoPojo;

import java.io.IOException;
import java.util.List;

public interface ProductTobaccoService {
    String save(ProductTobaccoPojo productTobaccoPojo) throws IOException;

    List<ProductTobacco> fetchAll();
}
