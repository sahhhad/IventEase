//package com.aswathy.inventory.controller;
//
//import com.aswathy.inventory.dao.ProductDAO;
//import com.aswathy.inventory.model.Product;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.*;
//import java.io.IOException;
//import java.util.List;
//
//public class ProductServlet extends HttpServlet {
//
//    ProductDAO productDAO;
//
//    @Override
//    public void init() throws ServletException {
//        productDAO = new ProductDAO();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Product> products = productDAO.getAllProducts();
//        request.setAttribute("products", products);
//        RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
//        rd.forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String name = request.getParameter("name");
//        int qty = Integer.parseInt(request.getParameter("quantity"));
//        double price = Double.parseDouble(request.getParameter("price"));
//
//        Product p = new Product(0, name, qty, price);
//        productDAO.addProduct(p);
//
//        response.sendRedirect("ProductServlet");
//    }
//}
