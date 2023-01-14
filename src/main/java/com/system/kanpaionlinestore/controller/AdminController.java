package com.system.kanpaionlinestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/dashboard")
    public String getAdminPage() {
        return "admin_dashboard";
    }

    @GetMapping("/add-product")
    public String getAddProductPage() {
        return "add_product";
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
