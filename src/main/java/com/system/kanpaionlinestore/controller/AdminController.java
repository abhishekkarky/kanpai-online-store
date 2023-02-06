package com.system.kanpaionlinestore.controller;
import com.system.kanpaionlinestore.entity.Notifications;
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

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;
    private final NotificationsService notificationsService;
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
    @GetMapping("/add-notices")
    public String addNotices(Model model) {
        model.addAttribute("notice", new NotificationsPojo());
        return "notify_customers";
    }
    @PostMapping("/save/notices")
    public String saveNotices(@Valid NotificationsPojo notificationsPojo){
        notificationsService.save(notificationsPojo);
        return "redirect:/user/notifications";
    }
    @GetMapping("/order-list")
    public String getOrderListPage() {
        return "order_list";
    }
    @GetMapping("/notice-list")
    public String getNoticeList(Model model, Principal principal) {
        List<Notifications> notifications = notificationsService.fetchAll();
        model.addAttribute("notice", notifications);
        return "notice-list";
    }
    @GetMapping("/edit/{id}")
    public String editNotices(@PathVariable("id") Integer id, Model model) {
        Notifications notifications = notificationsService.fetchById(id);
        model.addAttribute("notices", new NotificationsPojo(notifications));
        return "redirect:/admin/add-notices";
    }
    @GetMapping("/delete/{id}")
    public String deleteNotices(@PathVariable("id") Integer id) {
        notificationsService.deleteById(id);
        return "redirect:/admin/notice-list";
    }

    @GetMapping("/settings")
    public String getAdminSettingsPage() {
        return "admin_settings";
    }

}
