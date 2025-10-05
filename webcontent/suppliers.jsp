<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>


<%@ page import="java.util.*,com.ims.model.Supplier" %>
<html>
<head><title>Suppliers</title></head>
<body>
    <h2>Suppliers List</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Contact</th></tr>
        <%
            List<Supplier> suppliers = (List<Supplier>) request.getAttribute("suppliers");
            if(suppliers != null){
                for(Supplier s : suppliers){
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getContact() %></td>
        </tr>
        <% }} %>
    </table>

    <h3>Add Supplier</h3>
    <form action="SupplierServlet" method="post">
        Name: <input type="text" name="name"><br>
        Contact: <input type="text" name="contact"><br>
        <input type="submit" value="Add Supplier">
    </form>
</body>
</html>
