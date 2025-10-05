<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>


<%@ page import="com.ims.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if(user == null) {
        response.sendRedirect("index.jsp");
    }
%>
<html>
<head><title>Dashboard</title></head>
<body>
    <h2>Welcome, <%= user.getUsername() %>!</h2>
    <a href="ProductServlet">Manage Products</a>
</body>
</html>

