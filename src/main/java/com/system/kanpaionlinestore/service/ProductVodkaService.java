package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.ProductVodka;
import com.system.kanpaionlinestore.pojo.ProductVodkaPojo;

import java.io.IOException;
import java.util.List;

public interface ProductVodkaService {
    String save(ProductVodkaPojo productVodkaPojo) throws IOException;

    List<ProductVodka> fetchAll();
}
