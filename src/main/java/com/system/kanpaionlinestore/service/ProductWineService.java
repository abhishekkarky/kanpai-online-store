package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.ProductWine;
import com.system.kanpaionlinestore.pojo.ProductWinePojo;

import java.io.IOException;
import java.util.List;

public interface ProductWineService {
    String save(ProductWinePojo productWinePojo) throws IOException;

    List<ProductWine> fetchAll();
}
