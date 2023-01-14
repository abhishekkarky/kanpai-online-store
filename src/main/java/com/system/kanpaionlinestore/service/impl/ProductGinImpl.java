package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductGin;
import com.system.kanpaionlinestore.pojo.ProductGinPojo;
import com.system.kanpaionlinestore.repo.ProductGinRepo;
import com.system.kanpaionlinestore.service.ProductGinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGinImpl implements ProductGinService {
    public final ProductGinRepo productGinRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/kanpai_store";


    @Override
    public List<ProductGin> fetchAll() {
        return this.productGinRepo.findAll();
    }

    @Override
    public String save(ProductGinPojo productGinPojo) throws IOException {
        ProductGin productGin=new ProductGin();
        if(productGin.getId()!=null){
            productGin.setId(productGinPojo.getId());
        }
        productGin.setProduct_name(productGinPojo.getProduct_name());
        productGin.setProduct_quantity(productGinPojo.getProduct_quantity());
        productGin.setProduct_price(productGinPojo.getProduct_price());
        if(productGinPojo.getProduct_photo()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productGinPojo.getProduct_photo().getOriginalFilename());
            fileNames.append(productGinPojo.getProduct_photo().getOriginalFilename());
            Files.write(fileNameAndPath, productGinPojo.getProduct_photo().getBytes());

            productGin.setProduct_photo(productGinPojo.getProduct_photo().getOriginalFilename());
        }

        productGinRepo.save(productGin);
        return "created";
    }
}
