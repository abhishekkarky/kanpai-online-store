package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.ProductCart;
import com.system.kanpaionlinestore.pojo.ProductCartPojo;

import java.security.Principal;
import java.util.List;

public interface ProductCartService {
    List<ProductCart> fetchAll();

    String save(ProductCartPojo productCartPojo);

}
