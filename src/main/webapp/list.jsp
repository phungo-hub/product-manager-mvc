<%--
  Created by IntelliJ IDEA.
  User: phungo
  Date: 2022-11-30
  Time: 11:41 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
  <link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
  <style>
    td, th {
      text-align: center;
      vertical-align: middle;
    }

  </style>
</head>
<body>
<h1>Product List</h1>
<form method="get">
  <input type="text" name="search" placeholder="search">
  <input type="submit" value="Search">
</form>
<a href="/products?action=add">Add new product</a>
<table class="table">
  <tr>
    <th scope="col">ID</th>
    <th scope="col">Product Name</th>
    <th scope="col">Description</th>
    <th scope="col">Price</th>
    <th></th>
    <th></th>
  </tr>
  <c:forEach items="${requestScope['products']}" var="prod">
    <tr>
      <td scope="row">${prod.getId()}</td>
      <td>${prod.getName()}</td>
      <td>${prod.getDesc()}</td>
      <td>${prod.getPrice()}</td>
      <td>
        <a class="btn btn-primary" href="/products?action=edit&id=${prod.getId()}">Edit</a>
      </td>
      <td>
        <a class="btn btn-primary" href="/products?action=delete&id=${prod.getId()}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
<c:forEach begin="1" end="${requestScope['totalPage']}" var="page">
  <a href="/products?page=${page}">${page}</a>
</c:forEach>
</body>
</html>
