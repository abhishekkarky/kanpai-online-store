package com.system.kanpaionlinestore.controller;

import com.system.kanpaionlinestore.pojo.*;
import com.system.kanpaionlinestore.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;
    @GetMapping("/dashboard")
    public String getAdminPage() {
        return "admin_dashboard";
    }

    @GetMapping("/add-product")
    public String getAddProductPage(Model model) {
        model.addAttribute("product", new ProductPojo());
        return "add_products";
    }
    @PostMapping("/save/product")
    public String saveProduct(@Valid ProductPojo productPojo) throws IOException {
        productService.save(productPojo);
        return "redirect:/landing";
    }
    @GetMapping("/order-list")
    public String getOrderListPage() {
        return "order_list";
    }

    @GetMapping("/notify")
    public String getNotifyCustomersPage() {
        return "notify_customers";
    }

    @GetMapping("/settings")
    public String getAdminSettingsPage() {
        return "admin_settings";
    }

}
