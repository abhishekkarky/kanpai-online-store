package com.system.kanpaionlinestore.controller;

import com.system.kanpaionlinestore.entity.Product;
import com.system.kanpaionlinestore.service.ProductService;
import com.system.kanpaionlinestore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class LandingController {
    private final ProductService productService;
    private final UserService userService;
    @GetMapping("/landing")
    public String getProductsPage(Model model, Principal principal) {
        List<Product> products = productService.fetchAll();
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        model.addAttribute("product", products.stream().map(product ->
                        Product.builder()
                                .id(product.getId())
                                .imageBase64(getImageBase64(product.getPhoto()))
                                .name(product.getName())
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .build()
                )
        );
        return ("landing");
    }
    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/kanpai_store/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }
}
