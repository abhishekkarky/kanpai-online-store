package com.system.kanpaionlinestore.controller;
import com.system.kanpaionlinestore.entity.User;
import com.system.kanpaionlinestore.pojo.UserPojo;
import com.system.kanpaionlinestore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class LoginController {
    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("users", new User());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("users") User user ) {
        UserPojo authUser = userService.findByEmail(user.getEmail());
        UserPojo authUserPassword = userService.findByPassword(user.getPassword());
        System.out.print(authUser);
        System.out.print(authUserPassword);
        if(Objects.nonNull(authUser) && (Objects.nonNull(authUserPassword))) {
            return "redirect:/landing";
        } else {
            return "login";
        }
    }
}
