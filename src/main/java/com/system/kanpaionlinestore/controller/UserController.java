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
        model.addAttribute("product_whiskey", productWhiskeys);
        return ("whiskey");
    }

    @GetMapping("/vodka")
    public String getVodkaPage(Model model) {
        List<ProductVodka> productVodkas = productVodkaService.fetchAll();
        model.addAttribute("product_vodka", productVodkas);
        return ("vodka");
    }
    @GetMapping("/wine")
    public String getWinePage(Model model) {
        List<ProductWine> productWines = productWineService.fetchAll();
        model.addAttribute("product_wine", productWines);
        return ("wine");
    }
    @GetMapping("/gin")
    public String getGinPage(Model model) {
        List<ProductGin> productGins = productGinService.fetchAll();
        model.addAttribute("product_gin", productGins);
        return ("gin");
    }
    @GetMapping("/tequila")
    public String getTequilaPage(Model model) {
        List<ProductTequila> productTequilas = productTequilaService.fetchAll();
        model.addAttribute("product_tequila", productTequilas);
        return ("tequila");
    }
    @GetMapping("/tobacco")
    public String getTobaccoPage(Model model) {
        List<ProductTobacco> productTobaccos = productTobaccoService.fetchAll();
        model.addAttribute("product_tobacco", productTobaccos);
        return ("tobacco");
    }

    @GetMapping("/cart")
    public String getCartPage() {
        return "cart_page";
    }

}
