package com.system.kanpaionlinestore.controller;

import com.system.kanpaionlinestore.entity.*;
import com.system.kanpaionlinestore.exception.AppException;
import com.system.kanpaionlinestore.pojo.UserPojo;
import com.system.kanpaionlinestore.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ProductWhiskeyService productWhiskeyService;
    private final ProductVodkaService productVodkaService;
    private final ProductWineService productWineService;
    private final ProductGinService productGinService;
    private final ProductTequilaService productTequilaService;
    private final ProductTobaccoService productTobaccoService;

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "register";
    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userpojo) {
        userService.save(userpojo);
        return "redirect:/login";
    }

    @GetMapping("/whiskey")
    public String getWhiskeyPage(Model model) {
        List<ProductWhiskey> productWhiskeys = productWhiskeyService.fetchAll();
        model.addAttribute("product_whiskey", productWhiskeys.stream().map(productWhiskey ->
                ProductWhiskey.builder()
                        .id(productWhiskey.getId())
                        .imageBase64(getImageBase64(productWhiskey.getProduct_photo()))
                        .product_name(productWhiskey.getProduct_name())
                        .product_quantity(productWhiskey.getProduct_quantity())
                        .product_price(productWhiskey.getProduct_price())
                        .build()
                )
        );
        return ("whiskey");
    }

    @GetMapping("/vodka")
    public String getVodkaPage(Model model) {
        List<ProductVodka> productVodkas = productVodkaService.fetchAll();
        model.addAttribute("product_vodka", productVodkas.stream().map(productVodka ->
                ProductVodka.builder()
                        .id(productVodka.getId())
                        .imageBase64(getImageBase64(productVodka.getProduct_photo()))
                        .product_name(productVodka.getProduct_name())
                        .product_quantity(productVodka.getProduct_quantity())
                        .product_price(productVodka.getProduct_price())
                        .build()
                )
        );
        return ("vodka");
    }
    @GetMapping("/wine")
    public String getWinePage(Model model) {
        List<ProductWine> productWines = productWineService.fetchAll();
        model.addAttribute("product_wine", productWines.stream().map(productWine ->
                    ProductWine.builder()
                            .id(productWine.getId())
                            .imageBase64(getImageBase64(productWine.getProduct_photo()))
                            .product_name(productWine.getProduct_name())
                            .product_quantity(productWine.getProduct_quantity())
                            .product_price(productWine.getProduct_price())
                            .build()
                    )
        );
        return ("wine");
    }
    @GetMapping("/gin")
    public String getGinPage(Model model) {
        List<ProductGin> productGins = productGinService.fetchAll();
        model.addAttribute("product_gin", productGins.stream().map(productGin ->
                ProductGin.builder()
                        .id(productGin.getId())
                        .imageBase64(getImageBase64(productGin.getProduct_photo()))
                        .product_name(productGin.getProduct_name())
                        .product_quantity(productGin.getProduct_quantity())
                        .product_price(productGin.getProduct_price())
                        .build()
                )
        );
        return ("gin");
    }
    @GetMapping("/tequila")
    public String getTequilaPage(Model model) {
        List<ProductTequila> productTequilas = productTequilaService.fetchAll();
        model.addAttribute("product_tequila", productTequilas.stream().map(productTequila ->
                ProductTequila.builder()
                        .id(productTequila.getId())
                        .imageBase64(getImageBase64(productTequila.getProduct_photo()))
                        .product_name(productTequila.getProduct_name())
                        .product_quantity(productTequila.getProduct_quantity())
                        .product_price(productTequila.getProduct_price())
                        .build()
                )
        );
        return ("tequila");
    }
    @GetMapping("/tobacco")
    public String getTobaccoPage(Model model) {
        List<ProductTobacco> productTobaccos = productTobaccoService.fetchAll();
        model.addAttribute("product_tobacco", productTobaccos.stream().map(productTobacco ->
                ProductTobacco.builder()
                        .id(productTobacco.getId())
                        .imageBase64(getImageBase64(productTobacco.getProduct_photo()))
                        .product_name(productTobacco.getProduct_name())
                        .product_quantity(productTobacco.getProduct_quantity())
                        .product_price(productTobacco.getProduct_price())
                        .build()
                )
        );
        return ("tobacco");
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

    @GetMapping("/cart")
    public String getCartPage() {
        return "cart_page";
    }

}
