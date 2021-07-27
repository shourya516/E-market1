<%@ page import="com.Emarket.Model.User" %>
<%

    User user=(User)session.getAttribute("current-user");
    if(user==null) {
        session.setAttribute("message","Please login");
        response.sendRedirect("login");
        return;
    }
    if(!user.getConsumerType().equalsIgnoreCase("customer")) {
        session.setAttribute("message", "You are not customer");
        response.sendRedirect("login");
        return;
    }
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Availableproducts Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/agriwebsite.css">
</head>
<body>
<header>
    <div id="headerBox">
        <div class="column">
            <a href="${pageContext.request.contextPath}/customerpage"><img src="${pageContext.request.contextPath}/img/logo.png" id="logoimg" alt="logo"></a>
        </div>
        <div class="column">
            <nav>
                <ul class="menu1" style="padding-left: 100px;">
                    <a href="${pageContext.request.contextPath}/customerpage/allproducts" style="text-decoration: none;"><li>Product</li></a>
                    <a href="${pageContext.request.contextPath}/customerpage/orderhistory" style="text-decoration: none;"><li>History</li></a>
                    <a href="${pageContext.request.contextPath}/customerpage/cart" style="text-decoration: none;"><li>Cart</li></a>
                </ul>
            </nav>
        </div>
        <div class="column" >
            <span id="welcomeholder">Welcome <%=user.getCustomer().getCustName()%>!</span>
            <a href="/logout" id="LoginLink">Logout here</a>
        </div>
    </div>
</header>
<c:set var="total" value="${0}"/>
<c:forEach var="cartProduct" items="${cartList}">
    <c:set var="total" value="${total + cartProduct.price}" />
</c:forEach>
<div class="cart-holder">
    <h1 style="text-align: center;">Cart</h1>
    <div class="cart-Product">
        <table style="width: 100%;" class="cart-table">
            <c:forEach var="cartProduct" items="${cartList}">
            <tr>
                <td><div class="cart-image-holder"></div></td>
                <td>${cartProduct.productName}</td>
                <td>${cartProduct.price}</td>
                <td><a href="${pageContext.request.contextPath}/customerpage/remove?serialno=${cartProduct.serialNo}&id=${cartProduct.customerId}"><button class="remove-btn">Remove</button></a></td>
            </tr>
            </c:forEach>
        </table>

    </div>

    <button class="checkout-btn">checkout</button>
    <div class="price-box">price:${total}</div>

</div>


