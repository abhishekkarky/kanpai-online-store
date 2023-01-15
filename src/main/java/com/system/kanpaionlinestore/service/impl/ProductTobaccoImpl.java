package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductTobacco;
import com.system.kanpaionlinestore.pojo.ProductTobaccoPojo;
import com.system.kanpaionlinestore.repo.ProductTobaccoRepo;
import com.system.kanpaionlinestore.service.ProductTobaccoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTobaccoImpl implements ProductTobaccoService {
    public final ProductTobaccoRepo productTobaccoRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/kanpai_store";

    @Override
    public List<ProductTobacco> fetchAll() {
        return this.productTobaccoRepo.findAll();
    }
    @Override
    public String save(ProductTobaccoPojo productTobaccoPojo) throws IOException {
        ProductTobacco productTobacco=new ProductTobacco();
        if(productTobacco.getId()!=null){
            productTobacco.setId(productTobaccoPojo.getId());
        }
        productTobacco.setProduct_name(productTobaccoPojo.getProduct_name());
        productTobacco.setProduct_quantity(productTobaccoPojo.getProduct_quantity());
        productTobacco.setProduct_price(productTobaccoPojo.getProduct_price());
        if(productTobaccoPojo.getProduct_photo()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productTobaccoPojo.getProduct_photo().getOriginalFilename());
            fileNames.append(productTobaccoPojo.getProduct_photo().getOriginalFilename());
            Files.write(fileNameAndPath, productTobaccoPojo.getProduct_photo().getBytes());

            productTobacco.setProduct_photo(productTobaccoPojo.getProduct_photo().getOriginalFilename());
        }

        productTobaccoRepo.save(productTobacco);
        return "created";
    }
}
