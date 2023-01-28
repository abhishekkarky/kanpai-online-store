package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductCart;
import com.system.kanpaionlinestore.repo.ProductCartRepo;
import com.system.kanpaionlinestore.service.ProductCartService;
import com.system.kanpaionlinestore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCartServices implements ProductCartService {
    private final ProductCartRepo productCartRepo;

    @Override
    public List<ProductCart> fetchAll() {
        return this.productCartRepo.findAll();
    }
}
