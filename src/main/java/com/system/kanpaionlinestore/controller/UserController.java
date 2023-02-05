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
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ProductCartServices productCartServices;
    private final NotificationsService notificationsService;

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

//    @GetMapping("")
//    public String saveToCart(@PathVariable Integer id){
//        productCartServices.saveToCart(id);
//        return "cart_page";
//    }

    @GetMapping("/cart/{id}")
    public String getCartPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
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

    @GetMapping("/contact")
    public String getContactUsPage() {
        return "contactus";
    }

    @GetMapping("/request-password-reset")
    public String requestPasswordReset() {
        return "request_password_reset";
    }

    @PostMapping("/request-password-reset")
    public String processPasswordResetRequest(@RequestParam("email") String email, Model model) {
        userService.processPasswordResetRequest(email);
        model.addAttribute("message", "A password reset OTP has been sent to your email. Please check your inbox!!!");
        return "reset_password";
    }

    @GetMapping("/reset-password")
    public String resetPassword(@RequestParam("email") String email, Model model) {
        model.addAttribute("email", email);
        return "reset_password";
    }

    @PostMapping("/reset-password")
    public String processPasswordReset(@RequestParam("email") String email,
                                       @RequestParam(required=false, name = "OTP") String OTP,
                                       @RequestParam("password") String password,
                                       Model model) {
        userService.resetPassword(email, OTP, password);
        model.addAttribute("message", "Your password has been reset successfully.");
        return "reset_password";
    }

    @GetMapping("/notifications")
    public String getNotifications(Model model) {
        List<Notifications> notifications = notificationsService.fetchAll();
        model.addAttribute("notice", notifications.stream().map(notice ->
                        Notifications.builder()
                                .id(notice.getId())
                                .topic(notice.getTopic())
                                .description(notice.getDescription())
                                .build()
                )
        );
        return ("notices");
    }

}
