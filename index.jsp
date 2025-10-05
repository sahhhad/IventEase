<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>


<%@ page language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
    <% if(request.getParameter("error") != null) { %>
        <p style="color:red;">Invalid login!</p>
    <% } %>
</body>
</html>
