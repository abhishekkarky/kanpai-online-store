package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.Product;
import com.system.kanpaionlinestore.pojo.ProductPojo;
import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> fetchAll();

    String save(ProductPojo productPojo) throws IOException;

    Product fetchById(Integer id);

    void deleteById(Integer id);
}
