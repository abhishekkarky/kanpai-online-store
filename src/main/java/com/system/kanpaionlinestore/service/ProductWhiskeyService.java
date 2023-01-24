package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.ProductWhiskey;
import com.system.kanpaionlinestore.pojo.ProductWhiskeyPojo;

import java.io.IOException;
import java.util.List;

public interface ProductWhiskeyService {
    List<ProductWhiskey> fetchAll();

    String save(ProductWhiskeyPojo productWhiskeyPojo) throws IOException;

}
