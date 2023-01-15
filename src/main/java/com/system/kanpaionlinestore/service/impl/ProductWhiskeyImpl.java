package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductWhiskey;
import com.system.kanpaionlinestore.pojo.ProductWhiskeyPojo;
import com.system.kanpaionlinestore.repo.ProductWhiskeyRepo;
import com.system.kanpaionlinestore.service.ProductWhiskeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductWhiskeyImpl implements ProductWhiskeyService {
    public final ProductWhiskeyRepo productWhiskeyRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/kanpai_store";

    @Override
    public List<ProductWhiskey> fetchAll() {
        return this.productWhiskeyRepo.findAll();
    }
    @Override
    public String save(ProductWhiskeyPojo productWhiskeyPojo) throws IOException {
        ProductWhiskey productWhiskey=new ProductWhiskey();
        if(productWhiskey.getId()!=null){
            productWhiskey.setId(productWhiskeyPojo.getId());
        }
        productWhiskey.setProduct_name(productWhiskeyPojo.getProduct_name());
        productWhiskey.setProduct_quantity(productWhiskeyPojo.getProduct_quantity());
        productWhiskey.setProduct_price(productWhiskeyPojo.getProduct_price());
        if(productWhiskeyPojo.getProduct_photo()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productWhiskeyPojo.getProduct_photo().getOriginalFilename());
            fileNames.append(productWhiskeyPojo.getProduct_photo().getOriginalFilename());
            Files.write(fileNameAndPath, productWhiskeyPojo.getProduct_photo().getBytes());

            productWhiskey.setProduct_photo(productWhiskeyPojo.getProduct_photo().getOriginalFilename());
        }

        productWhiskeyRepo.save(productWhiskey);
        return "created";
    }
}
