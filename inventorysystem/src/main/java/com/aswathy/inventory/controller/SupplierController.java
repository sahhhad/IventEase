package com.aswathy.inventory.controller;

import com.aswathy.inventory.dao.SupplierDAO;
import com.aswathy.inventory.model.Supplier;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierDAO supplierDAO;

    @GetMapping("/list")
    public String listSuppliers(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        List<Supplier> suppliers = supplierDAO.getAllSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers";
    }

    @PostMapping("/add")
    public String addSupplier(@RequestParam("username") String name, @RequestParam String contact,
                              HttpSession session,RedirectAttributes redirectAttrs) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (name.trim().isEmpty() || contact.trim().isEmpty()) {
            redirectAttrs.addFlashAttribute("errorMessage", "Name and contact are required!");
            return "redirect:/supplier/list";
        }

        Supplier supplier = new Supplier(0, name.trim(), contact.trim());
        supplierDAO.addSupplier(supplier);
        redirectAttrs.addFlashAttribute("successMessage", "Supplier added successfully!");
        return "redirect:/supplier/list";
    }
}
