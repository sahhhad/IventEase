package com.ims.servlet;

import com.ims.dao.SupplierDAO;
import com.ims.model.Supplier;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class SupplierServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Supplier> suppliers = SupplierDAO.getAllSuppliers();
        request.setAttribute("suppliers", suppliers);
        RequestDispatcher rd = request.getRequestDispatcher("suppliers.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");

        Supplier s = new Supplier(0, name, contact);
        SupplierDAO.addSupplier(s);

        response.sendRedirect("SupplierServlet");
    }
}
