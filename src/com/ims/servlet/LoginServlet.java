package com.ims.servlet;

import com.ims.dao.UserDAO;
import com.ims.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Login attempt: username='" + username + "', password='" + password + "'");

        if(username == null || password == null) {
            System.out.println("Username or password is null!");
            response.sendRedirect("index.jsp?error=1");
            return;
        }

        User user = UserDAO.validate(username, password);

        if (user != null) {
            System.out.println("Login successful for user: " + user.getUsername());
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("dashboard.jsp");
        } else {
            System.out.println("Login failed for username: " + username);
            response.sendRedirect("index.jsp?error=1");
        }
    }
}
