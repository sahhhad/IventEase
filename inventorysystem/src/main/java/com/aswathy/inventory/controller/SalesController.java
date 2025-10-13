package com.aswathy.inventory.controller;

import com.aswathy.inventory.dao.SalesDAO;
import com.aswathy.inventory.model.Sale;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesDAO salesDAO;

    @GetMapping("/list")
    public String listSales(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        List<Sale> sales = salesDAO.getAllSales();
        System.out.println(sales);
        model.addAttribute("sales", sales);
        return "sales";
    }

    @PostMapping("/add")
    public String addSale(@RequestParam int productId, @RequestParam int quantity, @RequestParam double total,
            HttpSession session, RedirectAttributes redirectAttrs) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (productId <= 0 || quantity <= 0 || total <= 0) {
            redirectAttrs.addFlashAttribute("errorMessage", "Invalid sale data!");
            return "redirect:/sales/list";
        }

        Sale sale = new Sale(0, productId, quantity, total);
        salesDAO.addSale(sale);
        redirectAttrs.addFlashAttribute("successMessage", "Sale recorded successfully!");
        return "redirect:/sales/list";
    }
}