package com.system.kanpaionlinestore.controller;
import com.system.kanpaionlinestore.entity.*;
import com.system.kanpaionlinestore.pojo.*;
import com.system.kanpaionlinestore.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final ProductCartService productCartService;

    private final UserService userService;

    @GetMapping()
    public String displayCart(Principal principal, Model model, ProductCartPojo productCartPojo){
        Integer id = userService.findByEmail(principal.getName()).getId();
        List<ProductCart> list = productCartService.fetchAll(id);
        model.addAttribute("cart", productCartPojo);
        model.addAttribute("cartItems", list);

        return "cart_page";
    }

    @GetMapping("/add/{id}")
    public String saveToCart(@PathVariable Integer id, Principal principal){
        productCartService.saveToCart(id, principal);
        return "redirect:/cart";
    }

    @PostMapping("/updateQuantity/{id}")
    public String updateQuantity(@Valid ProductCartPojo productCartPojo){
        ProductCart productCart = productCartService.fetchOne(productCartPojo.getId());
        productCart.setQuantity(productCartPojo.getQuantity());
        productCartService.updateQuantity(productCart);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String deleteCartItem(@PathVariable("id") Integer id){
        productCartService.deleteFromCart(id);
        return "redirect:/cart";
    }
}