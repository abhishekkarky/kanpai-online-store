package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductTobacco;
import com.system.kanpaionlinestore.entity.ProductVodka;
import com.system.kanpaionlinestore.pojo.ProductTobaccoPojo;
import com.system.kanpaionlinestore.pojo.ProductVodkaPojo;
import com.system.kanpaionlinestore.repo.ProductVodkaRepo;
import com.system.kanpaionlinestore.service.ProductVodkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductVodkaImpl implements ProductVodkaService {
    public final ProductVodkaRepo productVodkaRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/kanpai_store";

    @Override
    public List<ProductVodka> fetchAll() {
        return this.productVodkaRepo.findAll();
    }
    @Override
    public String save(ProductVodkaPojo productVodkaPojo) throws IOException {
        ProductVodka productVodka=new ProductVodka();
        if(productVodka.getId()!=null){
            productVodka.setId(productVodkaPojo.getId());
        }
        productVodka.setProduct_name(productVodkaPojo.getProduct_name());
        productVodka.setProduct_quantity(productVodkaPojo.getProduct_quantity());
        productVodka.setProduct_price(productVodkaPojo.getProduct_price());
        if(productVodkaPojo.getProduct_photo()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productVodkaPojo.getProduct_photo().getOriginalFilename());
            fileNames.append(productVodkaPojo.getProduct_photo().getOriginalFilename());
            Files.write(fileNameAndPath, productVodkaPojo.getProduct_photo().getBytes());

            productVodka.setProduct_photo(productVodkaPojo.getProduct_photo().getOriginalFilename());
        }

        productVodkaRepo.save(productVodka);
        return "created";
    }
}
