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

    private final ProductWhiskeyService productWhiskeyService;
    private final ProductVodkaService productVodkaService;
    private final ProductWineService productWineService;
    private final ProductGinService productGinService;
    private final ProductTequilaService productTequilaService;
    private final ProductTobaccoService productTobaccoService;
    @GetMapping("/dashboard")
    public String getAdminPage() {
        return "admin_dashboard";
    }

    @GetMapping("/add-whiskey")
    public String getAddWhiskeyPage(Model model) {
        model.addAttribute("product_whiskey", new ProductWhiskeyPojo());
        return "add_whiskey";
    }
    @GetMapping("/add-vodka")
    public String getAddVodkaPage(Model model) {
        model.addAttribute("product_vodka", new ProductVodkaPojo());
        return "add_vodka";
    }
    @GetMapping("/add-wine")
    public String getAddWinePage(Model model) {
        model.addAttribute("product_wine", new ProductWinePojo());
        return "add_wine";
    }
    @GetMapping("/add-gin")
    public String getAddGinPage(Model model) {
        model.addAttribute("product_gin", new ProductGinPojo());
        return "add_gin";
    }
    @GetMapping("/add-tequila")
    public String getAddTequilaPage(Model model) {
        model.addAttribute("product_tequila", new ProductTequilaPojo());
        return "add_tequila";
    }
    @GetMapping("/add-tobacco")
    public String getAddTobaccoPage(Model model) {
        model.addAttribute("product_tobacco", new ProductTobaccoPojo());
        return "add_tobacco";
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

    @PostMapping("/save/product-whiskey")
    public String saveProductWhiskey(@Valid ProductWhiskeyPojo productWhiskeyPojo) throws IOException {
        productWhiskeyService.save(productWhiskeyPojo);
        return "redirect:/add-whiskey";
    }
    @PostMapping("/save/product-vodka")
    public String saveProductVodka(@Valid ProductVodkaPojo productVodkaPojo) throws IOException {
        productVodkaService.save(productVodkaPojo);
        return "redirect:/product/vodka";
    }
    @PostMapping("/save/product-wine")
    public String saveProductWine(@Valid ProductWinePojo productWinePojo) throws IOException {
        productWineService.save(productWinePojo);
        return "redirect:/product/wine";
    }
    @PostMapping("/save/product-gin")
    public String saveProductGin(@Valid ProductGinPojo productGinPojo) throws IOException {
        productGinService.save(productGinPojo);
        return "add_gin";
    }
    @PostMapping("/save/product-tequila")
    public String saveProductTequila(@Valid ProductTequilaPojo productTequilaPojo) throws IOException {
        productTequilaService.save(productTequilaPojo);
        return "redirect:/product/tequila";
    }
    @PostMapping("/save/product-tobacco")
    public String saveProductTobacco(@Valid ProductTobaccoPojo productTobaccoPojo) throws IOException{
        productTobaccoService.save(productTobaccoPojo);
        return "redirect:/product/tobacco";
    }
}
