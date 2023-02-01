package com.system.kanpaionlinestore.controller;

import com.system.kanpaionlinestore.entity.*;
import com.system.kanpaionlinestore.pojo.ProductCartPojo;
import com.system.kanpaionlinestore.pojo.UserPojo;
import com.system.kanpaionlinestore.service.*;
import com.system.kanpaionlinestore.service.impl.ProductCartServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
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
    @GetMapping("/shipping")
    public String getShippingPolicyPage() {
        return ("/shipping");
    }

    @GetMapping("/sendEmail")
    public String sendRegistrationEmail() {
        this.userService.sendEmail();
        return "emailsuccess";
    }

    @GetMapping("/cart")
    public String getCartPage(Model model) {
//        model.addAttribute("productcart", new ProductCartPojo());
        List<ProductCart> productCarts = productCartServices.fetchAll();
        model.addAttribute("productCart", productCarts.stream().map(productCart ->
                        ProductCart.builder()
                                .id(productCart.getId())
                                .name(productCart.getName())
                                .quantity(productCart.getQuantity())
                                .price(productCart.getPrice())
                                .build()
                )
        );
        return "cart_page";
    }
    @PostMapping("/saveCart")
    public String saveProductCart(@Valid ProductCartPojo productCartPojo) {
        productCartServices.save(productCartPojo);
        return "redirect:/user/cart";
    }
    @GetMapping("/profile")
    public String getUserProfile (Integer id, Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        model.addAttribute("update", new UserPojo());
        model.addAttribute("info", userService.findByEmail(principal.getName()));
        return "accountpage";
    }
    @PostMapping("/updateUser")
    public String updateUser(@Valid UserPojo userpojo) {
        userService.update(userpojo);
        return "redirect:/user/profile";
    }

}
