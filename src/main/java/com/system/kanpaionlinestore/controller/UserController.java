package com.system.kanpaionlinestore.controller;

import com.system.kanpaionlinestore.entity.*;
import com.system.kanpaionlinestore.pojo.ProductCartPojo;
import com.system.kanpaionlinestore.pojo.QueriesPojo;
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
    private final QueryService queryService;

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
    public String getAboutUsPage(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        return "/aboutus";
    }
    @GetMapping("/privacypolicy")
    public String getPrivacyPolicyPage(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        return ("/privacypolicy");
    }
    @GetMapping("/shipping")
    public String getShippingPolicyPage(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        return ("/shipping");
    }

    @GetMapping("/sendEmail")
    public String sendRegistrationEmail() {
        this.userService.sendEmail();
        return "emailsuccess";
    }

//    @GetMapping("/cart/{id}")
//    public String getCartPage(Model model, Principal principal, ProductCartPojo productCartPojo) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "login";
//        }
//        if (principal!=null) {
//            model.addAttribute("info", userService.findByEmail(principal.getName()));
//        }
//        Integer id = userService.findByEmail(principal.getName()).getId();
//        List<ProductCart> list = productCartServices.fetchAll(id);
//        model.addAttribute("cart", productCartPojo);
//        model.addAttribute("cartItems", list);
//        return "cart_page";
//    }
//    @PostMapping("/saveCart")
//    public String saveProductCart(@Valid ProductCartPojo productCartPojo) {
//        productCartServices.save(productCartPojo);
//        return "redirect:/user/cart";
//    }

    @GetMapping("/profile")
    public String getUserProfile (Integer id, Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        model.addAttribute("update", new UserPojo());
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        return "accountpage";
    }
    @PostMapping("/updateUser")
    public String updateUser(@Valid UserPojo userpojo) {
        userService.update(userpojo);
        return "redirect:/user/profile";
    }

    @GetMapping("/contact")
    public String getContactUsPage(Model model, Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        model.addAttribute("queries", new QueriesPojo());
        return "contactus";
    }
    @PostMapping("/saveQueries")
    public String saveQuery(@Valid QueriesPojo queriesPojo) {
        queryService.save(queriesPojo);
        return "redirect:/landing";
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
        return "redirect:/login";
    }

    @GetMapping("/notifications")
    public String getNotifications(Model model,Principal principal) {
        if (principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
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
