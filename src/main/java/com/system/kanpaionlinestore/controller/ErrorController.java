//package com.system.kanpaionlinestore.controller;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping
//public class ErrorController implements ErrorController {
//
//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request, Model model) {
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        if (status != null) {
//            int statusCode = Integer.parseInt(status.toString());
//            model.addAttribute("statusCode", statusCode);
//            switch (statusCode) {
//                case 404:
//                    return "error404";
//                case 500:
//                    return "error500";
//            }
//        }
//        return "error";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//}
