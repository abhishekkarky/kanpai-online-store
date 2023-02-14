package com.system.kanpaionlinestore.controller;
import com.system.kanpaionlinestore.entity.Notifications;
import com.system.kanpaionlinestore.entity.Queries;
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
    private final QueryService queryService;
    private final UserService userService;
    @GetMapping("/dashboard")
    public String getAdminPage(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        return "admin_dashboard";
    }

    @GetMapping("/add-product")
    public String getAddProductPage(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        model.addAttribute("product", new ProductPojo());
        return "add_products";
    }
    @PostMapping("/save/product")
    public String saveProduct(@Valid ProductPojo productPojo, Model model, Principal principal) throws IOException {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        productService.save(productPojo);
        return "redirect:/landing";
    }
    @GetMapping("/add-notices")
    public String addNotices(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        model.addAttribute("notice", new NotificationsPojo());
        return "notify_customers";
    }
    @PostMapping("/save/notices")
    public String saveNotices(@Valid NotificationsPojo notificationsPojo, Model model, Principal principal){
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        notificationsService.save(notificationsPojo);
        return "redirect:/user/notifications";
    }
    @GetMapping("/order-list")
    public String getOrderListPage(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        return "order_list";
    }
    @GetMapping("/notice-list")
    public String getNoticeList(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        List<Notifications> notifications = notificationsService.fetchAll();
        model.addAttribute("notice", notifications);
        return "notice-list";
    }
    @GetMapping("/edit/{id}")
    public String editNotices(@PathVariable("id") Integer id, Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        Notifications notifications = notificationsService.fetchById(id);
        model.addAttribute("notice", new NotificationsPojo(notifications));
        return "notify_customers";
    }
    @GetMapping("/delete/{id}")
    public String deleteNotices(@PathVariable("id") Integer id, Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        notificationsService.deleteById(id);
        return "redirect:/admin/notice-list";
    }
    @GetMapping("/queries")
    public String getQueryPage(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        List<Queries> queries = queryService.fetchAll();
        model.addAttribute("queries", queries);
        return "query_section";
    }

    @GetMapping("/settings")
    public String getAdminSettingsPage(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        return "admin_settings";
    }

}
