package com.system.kanpaionlinestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/whiskey")
    public String getWhiskeyPage() {
        return ("whiskey");
    }
    @GetMapping("/vodka")
    public String getVodkaPage() {
        return ("vodka");
    }
    @GetMapping("/wine")
    public String getWinePage() {
        return ("wine");
    }
    @GetMapping("/gin")
    public String getGinPage() {
        return ("gin");
    }
    @GetMapping("/tequila")
    public String getTequilaPage() {
        return ("tequila");
    }
    @GetMapping("/tobacco")
    public String getTobaccoPage() {
        return ("tobacco");
    }
}
