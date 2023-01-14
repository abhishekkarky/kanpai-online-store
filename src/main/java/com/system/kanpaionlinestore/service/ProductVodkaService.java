package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.ProductVodka;
import com.system.kanpaionlinestore.pojo.ProductVodkaPojo;

import java.util.List;

public interface ProductVodkaService {
    String save(ProductVodkaPojo productVodkaPojo);

    List<ProductVodka> fetchAll();
}
