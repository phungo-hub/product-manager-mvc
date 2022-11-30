
<%--
  Created by IntelliJ IDEA.
  User: phungo
  Date: 2022-11-30
  Time: 3:16 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Customer</title>
    <style>
      .message {
        color: green;
      }
    </style>
</head>
<body>
<h1>Edit Customer</h1>
<div>
  <a href="/products">Back to product list</a>
</div>
<c:set var = "p"
        value="${requestScope['product']}"></c:set>
<c:if test='${requestScope["message"] != null}'>
  <span class="message">${requestScope["message"]}</span>
</c:if>
<fieldset>
  <legend>Product info</legend>
  <form method="post">
    <table>
      <tr>
        <td>ID</td>
        <td>
          <input type="text" name="id" value="${p.getId()}" disabled>
        </td>
      </tr>
      <tr>
        <td>Name</td>
        <td>
          <input type="text" name="name" placeholder="input name..." value="${p.getName()}">
        </td>
      </tr>
      <tr>
        <td>Description</td>
        <td>
          <input type="text" name="desc" placeholder="input description..." value="${p.getDesc()}">
        </td>
      </tr>
      <tr>
        <td>Price</td>
        <td>
          <input type="text" name="price" placeholder="input price..." value="${p.getPrice()}">
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="submit" value="Edit">
        </td>
      </tr>
    </table>
  </form>
</fieldset>
</body>
</html>
