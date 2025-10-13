//package com.aswathy.inventory.controller;
//
//import com.aswathy.inventory.dao.SalesDAO;
//import com.aswathy.inventory.model.Sale;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.*;
//
//import java.io.IOException;
//import java.util.List;
//
//public class SalesServlet extends HttpServlet {
//
//    SalesDAO salesDAO;
//
//    @Override
//    public void init() {
//        salesDAO = new SalesDAO();
//    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Sale> sales = salesDAO.getAllSales();
//        request.setAttribute("sales", sales);
//        RequestDispatcher rd = request.getRequestDispatcher("sales.jsp");
//        rd.forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int productId = Integer.parseInt(request.getParameter("product_id"));
//        int qty = Integer.parseInt(request.getParameter("quantity"));
//        double total = Double.parseDouble(request.getParameter("total"));
//
//        Sale s = new Sale(0, productId, qty, total);
//        salesDAO.addSale(s);
//
//        response.sendRedirect("SalesServlet");
//    }
//}
