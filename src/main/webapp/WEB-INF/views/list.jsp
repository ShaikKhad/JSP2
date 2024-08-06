<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jsp.Springboot_Crud_JSP.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
    <h2>Product List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th colspan="2">Actions</th>
        </tr>
        <% 
            List<Product> products = (List<Product>) request.getAttribute("listProducts");
            for (Product product : products) { 
        %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getName() %></td>
            <td><%= product.getPrice() %></td>
            <td><a href="/updateProduct/<%= product.getId() %>">Edit</a></td>
            <td><a href="/deleteProduct/<%= product.getId() %>">Delete</a></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
