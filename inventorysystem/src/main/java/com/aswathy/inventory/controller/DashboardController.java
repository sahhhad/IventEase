//package com.aswathy.inventory.controller;
//
//import com.aswathy.inventory.model.User;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class DashboardController {
//
//    @GetMapping("/dashboard")
//    public String showDashboard(HttpSession session, Model model) {
//        // Check if user is logged in
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            return "redirect:/";
//        }
//
//        // Add user to model for JSP
//        model.addAttribute("user", user);
//        return "dashboard"; // resolves to /WEB-INF/views/dashboard.jsp
//    }
//}
//
