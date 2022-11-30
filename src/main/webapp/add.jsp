<%--
  Created by IntelliJ IDEA.
  User: phungo
  Date: 2022-11-30
  Time: 1:43 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>
    <style>
      .message {
        color: green;
      }
    </style>
</head>
<body>
<h1>Add Product page</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<div>
  <a href="/products">back to product list</a>
</div>
<form method="post">
  <fieldset>
    <legend>Customer Info</legend>
    <table>
      <tr>
        <td>Name</td>
        <td>
          <input type="text" name="name" placeholder="input name...">
        </td>
      </tr>
      <tr>
        <td>Description</td>
        <td>
          <input type="text" name="desc" placeholder="input description...">
        </td>
      </tr>
      <tr>
        <td>Price</td>
        <td>
          <input type="text" name="price" placeholder="input price...">
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="submit" value="Add">
        </td>
      </tr>
    </table>
  </fieldset>
</form>

</body>
</html>
