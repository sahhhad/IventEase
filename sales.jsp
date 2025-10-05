<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>


<%@ page import="java.util.*,com.ims.model.Sale" %>
<html>
<head><title>Sales</title></head>
<body>
    <h2>Sales List</h2>
    <table border="1">
        <tr><th>ID</th><th>Product ID</th><th>Quantity</th><th>Total</th></tr>
        <%
            List<Sale> sales = (List<Sale>) request.getAttribute("sales");
            if(sales != null){
                for(Sale s : sales){
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getProductId() %></td>
            <td><%= s.getQuantity() %></td>
            <td><%= s.getTotal() %></td>
        </tr>
        <% }} %>
    </table>

    <h3>Add Sale</h3>
    <form action="SalesServlet" method="post">
        Product ID: <input type="number" name="product_id"><br>
        Quantity: <input type="number" name="quantity"><br>
        Total: <input type="text" name="total"><br>
        <input type="submit" value="Add Sale">
    </form>
</body>
</html>
