<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phungo
  Date: 2022-11-30
  Time: 3:58 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<c:set var="p"
        value="${requestScope['product']}"></c:set>
<h1>Delete Product</h1>
<fieldset>
    <legend>Are you sure?</legend>
    <form method="post">
        <table>
            <tr>
                <td>ID</td>
                <td>${p.getId()}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${p.getName()}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${p.getDesc()}</td>
            </tr>
            <tr>
                <td>Price</td>
                <td>${p.getPrice()}</td>
            </tr>
            <tr>
                <td>Product will be deleted. Do you want to proceed?</td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="YES">
                </td>
                <td>
                    <a href="/products">
                        <input type="button" value="NO">
                    </a>
                </td>
            </tr>
        </table>
    </form>

</fieldset>
</body>
</html>
