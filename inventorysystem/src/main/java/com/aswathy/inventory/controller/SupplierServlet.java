//package com.aswathy.inventory.controller;
//
//import com.aswathy.inventory.dao.SupplierDAO;
//import com.aswathy.inventory.model.Supplier;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.List;
//
//public class SupplierServlet extends HttpServlet {
//
//    SupplierDAO supplierDAO;
//
//    @Override
//    public void init(){
//        supplierDAO = new SupplierDAO();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Supplier> suppliers = supplierDAO.getAllSuppliers();
//        request.setAttribute("suppliers", suppliers);
//        RequestDispatcher rd = request.getRequestDispatcher("suppliers.jsp");
//        rd.forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String contact = request.getParameter("contact");
//
//        Supplier s = new Supplier(0, name, contact);
//        supplierDAO.addSupplier(s);
//
//        response.sendRedirect("SupplierServlet");
//    }
//}
