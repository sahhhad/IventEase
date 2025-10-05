package com.ims.servlet;

import com.ims.dao.SalesDAO;
import com.ims.model.Sale;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class SalesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Sale> sales = SalesDAO.getAllSales();
        request.setAttribute("sales", sales);
        RequestDispatcher rd = request.getRequestDispatcher("sales.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        int qty = Integer.parseInt(request.getParameter("quantity"));
        double total = Double.parseDouble(request.getParameter("total"));

        Sale s = new Sale(0, productId, qty, total);
        SalesDAO.addSale(s);

        response.sendRedirect("SalesServlet");
    }
}
