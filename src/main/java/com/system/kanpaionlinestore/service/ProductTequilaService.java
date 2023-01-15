package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.ProductTequila;
import com.system.kanpaionlinestore.pojo.ProductTequilaPojo;

import java.io.IOException;
import java.util.List;

public interface ProductTequilaService {
    List<ProductTequila> fetchAll();
    String save(ProductTequilaPojo productTequilaPojo) throws IOException;
}
