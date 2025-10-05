<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>


<%@ page import="java.util.*,com.ims.model.Product" %>
<html>
<head><title>Products</title></head>
<body>
    <h2>Product List</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Quantity</th><th>Price</th></tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            if(products != null){
                for(Product p : products){
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getQuantity() %></td>
            <td><%= p.getPrice() %></td>
        </tr>
        <% }} %>
    </table>

    <h3>Add Product</h3>
    <form action="ProductServlet" method="post">
        Name: <input type="text" name="name"><br>
        Quantity: <input type="number" name="quantity"><br>
        Price: <input type="text" name="price"><br>
        <input type="submit" value="Add Product">
    </form>
</body>
</html>
