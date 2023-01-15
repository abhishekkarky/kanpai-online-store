package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductWine;
import com.system.kanpaionlinestore.pojo.ProductWinePojo;
import com.system.kanpaionlinestore.repo.ProductWineRepo;
import com.system.kanpaionlinestore.service.ProductWineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductWineImpl implements ProductWineService {
    public final ProductWineRepo productWineRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/kanpai_store";

    @Override
    public List<ProductWine> fetchAll() {
        return this.productWineRepo.findAll();
    }
    @Override
    public String save(ProductWinePojo productWinePojo) throws IOException {
        ProductWine productWine=new ProductWine();
        if(productWine.getId()!=null){
            productWine.setId(productWinePojo.getId());
        }
        productWine.setProduct_name(productWinePojo.getProduct_name());
        productWine.setProduct_quantity(productWinePojo.getProduct_quantity());
        productWine.setProduct_price(productWinePojo.getProduct_price());
        if(productWinePojo.getProduct_photo()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productWinePojo.getProduct_photo().getOriginalFilename());
            fileNames.append(productWinePojo.getProduct_photo().getOriginalFilename());
            Files.write(fileNameAndPath, productWinePojo.getProduct_photo().getBytes());

            productWine.setProduct_photo(productWinePojo.getProduct_photo().getOriginalFilename());
        }

        productWineRepo.save(productWine);
        return "created";
    }
}
