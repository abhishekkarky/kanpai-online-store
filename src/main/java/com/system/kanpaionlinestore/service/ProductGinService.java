package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.ProductGin;
import com.system.kanpaionlinestore.pojo.ProductGinPojo;

import java.io.IOException;
import java.util.List;

public interface ProductGinService {
    List<ProductGin> fetchAll();

    String save(ProductGinPojo productGinPojo) throws IOException;


}
