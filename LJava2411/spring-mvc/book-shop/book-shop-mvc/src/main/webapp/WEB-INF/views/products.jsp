<%--
  Created by IntelliJ IDEA.
  User: 7390
  Date: 2/26/2025
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
<h2>Product Management</h2>
<table border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>ID</th>
        <th>Book Title</th>
        <th>Author</th>
        <th>Page Count</th>
        <th>Publisher</th>
        <th>Publication Year</th>
        <th>Genre</th>
        <th>Price</th>
        <th>Discount</th>
        <th>Stock Quantity</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="productEntity" items="${products}">
        <tr>
            <td>${productEntity.id}</td>
            <td>${productEntity.bookTitle}</td>
            <td>${productEntity.author}</td>
            <td>${productEntity.pageCount}</td>
            <td>${productEntity.publisher}</td>
            <td>${productEntity.publicationYear}</td>
            <td>${productEntity.genre}</td>
            <td>${productEntity.price}</td>
            <td>${productEntity.discount}</td>
            <td>${productEntity.stockQuantity}</td>
            <td>
                <a href="view?id=${productEntity.id}">View</a> |
                <a href="edit?id=${productEntity.id}">Edit</a> |
                <a href="delete?id=${productEntity.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

