package com.aswathy.inventory.controller;

import com.aswathy.inventory.dao.ProductDAO;
import com.aswathy.inventory.model.Product;
import com.aswathy.inventory.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/list")
    public String listSales(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        List<Product> products = productDAO.getAllProducts();
        System.out.println(products);
        model.addAttribute("product", products);
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("username") String name, @RequestParam int quantity, @RequestParam double price,
                             HttpSession session, RedirectAttributes redirectAttrs) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (name.trim().isEmpty() || quantity < 0 || price < 0) {
            redirectAttrs.addFlashAttribute("errorMessage", "Invalid product data!");
            return "redirect:/products/list";
        }

        Product p = new Product(0, name.trim(), quantity, price);
        productDAO.addProduct(p);
        redirectAttrs.addFlashAttribute("successMessage", "Product added successfully!");
        return "redirect:/products/list";
    }
}