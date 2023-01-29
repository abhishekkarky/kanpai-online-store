package com.system.kanpaionlinestore.controller;

import com.system.kanpaionlinestore.entity.*;
import com.system.kanpaionlinestore.pojo.ProductCartPojo;
import com.system.kanpaionlinestore.pojo.UserPojo;
import com.system.kanpaionlinestore.service.*;
import com.system.kanpaionlinestore.service.impl.ProductCartServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ProductService productService;
    private final ProductCartServices productCartServices;

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

    @GetMapping("/aboutus")
    public String getAboutUsPage() {
        return "/aboutus";
    }
    @GetMapping("/privacypolicy")
    public String getPrivacyPolicyPage() {
        return ("/privacypolicy");
    }

    @GetMapping("/sendEmail")
    public String sendRegistrationEmail() {
        this.userService.sendEmail();
        return "emailsuccess";
    }

    @GetMapping("/cart")
    public String getCartPage(Model model) {
        model.addAttribute("productcart", new ProductCartPojo());
        return "cart_page";
    }
    @PostMapping("/saveCart")
    public String saveProductCart(@Valid ProductCartPojo productCartPojo) {
        productCartServices.save(productCartPojo);
        return "redirect:/user/cart";
    }

}
