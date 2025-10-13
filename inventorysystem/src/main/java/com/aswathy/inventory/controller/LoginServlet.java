//package com.aswathy.inventory.controller;
//
//import com.aswathy.inventory.dao.UserDAO;
//import com.aswathy.inventory.model.User;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.*;
//
//import java.io.IOException;
//
//public class LoginServlet extends HttpServlet {
//
//    UserDAO userDAO;
//
//    @Override
//    public void init() throws ServletException {
//        userDAO = new UserDAO();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        System.out.println("Login attempt: username='" + username + "', password='" + password + "'");
//
//        if(username == null || password == null) {
//            System.out.println("Username or password is null!");
//            response.sendRedirect("home.jsp?error=1");
//            return;
//        }
//
//        User user = userDAO.validate(username, password);
//
//        if (user != null) {
//            System.out.println("Login successful for user: " + user.getUsername());
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            response.sendRedirect("dashboard.jsp");
//        } else {
//            System.out.println("Login failed for username: " + username);
//            response.sendRedirect("home.jsp?error=1");
//        }
//    }
//}
