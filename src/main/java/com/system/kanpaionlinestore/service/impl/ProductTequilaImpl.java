package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.ProductTequila;
import com.system.kanpaionlinestore.pojo.ProductTequilaPojo;
import com.system.kanpaionlinestore.repo.ProductTequilaRepo;
import com.system.kanpaionlinestore.service.ProductTequilaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTequilaImpl implements ProductTequilaService {
    public final ProductTequilaRepo productTequilaRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/kanpai_store";

    @Override
    public List<ProductTequila> fetchAll() {
        return this.productTequilaRepo.findAll();
    }

    @Override
    public String save(ProductTequilaPojo productTequilaPojo) throws IOException {
        ProductTequila productTequila=new ProductTequila();
        if(productTequila.getId()!=null){
            productTequila.setId(productTequilaPojo.getId());
        }
        productTequila.setProduct_name(productTequilaPojo.getProduct_name());
        productTequila.setProduct_quantity(productTequilaPojo.getProduct_quantity());
        productTequila.setProduct_price(productTequilaPojo.getProduct_price());
        if(productTequilaPojo.getProduct_photo()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productTequilaPojo.getProduct_photo().getOriginalFilename());
            fileNames.append(productTequilaPojo.getProduct_photo().getOriginalFilename());
            Files.write(fileNameAndPath, productTequilaPojo.getProduct_photo().getBytes());

            productTequila.setProduct_photo(productTequilaPojo.getProduct_photo().getOriginalFilename());
        }

        productTequilaRepo.save(productTequila);
        return "created";
    }
}
