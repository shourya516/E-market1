<%@ page import="com.Emarket.Model.User" %>
<%@ page import="com.Emarket.Model.Product" %>
<%@ page import="java.util.List" %>
<%

    User user=(User)session.getAttribute("current-user");
    if(user==null) {
        session.setAttribute("message","Please login");
        response.sendRedirect("login");
        return;
    }
    if(!user.getConsumerType().equalsIgnoreCase("vendor")) {
        session.setAttribute("message", "You are not vendor");
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
    <title>Availableproduct Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/agriwebsite.css">
</head>
<body>
<header>
    <div id="headerBox">
        <div class="column">
            <a href="/home"><img src="${pageContext.request.contextPath}/img/logo.png" id="logoimg"></a>
        </div>
        <div class="column">
            <nav>
                <ul class="menu1" style="padding-left: 100px;">
                    <a href="${pageContext.request.contextPath}/vendorpage/addProducts" style="text-decoration: none;"><li>Product</li></a>
                    <a href="${pageContext.request.contextPath}/vendorpage/availableproducts" style="text-decoration: none;"><li>Available</li></a>
                    <a href="${pageContext.request.contextPath}/vendorpage/sold" style="text-decoration: none;"><li>Sold</li></a>
                </ul>
            </nav>
        </div>
        <div class="column" >
            <span id="welcomeholder">Welcome <%=user.getVendor().getVendorName()%>!</span>
            <a href="/logout" id="LoginLink">Logout here</a>
        </div>
    </div>
</header>
<div style="text-align: center;">
<h3>Available product by "<%=user.getVendor().getVendorName()%>" is ${size}</h3>
</div>
<div class="product-type-container">


    <div class="product-type">
        <div id="categories1">Categories</div>
        <a href="#"> <div class="categories">
            All Products
        </div> </a>
        <c:forEach var="category" items="${categoryList}">
        <a href="#"> <div class="categories">
            ${category.category}
        </div> </a>
        </c:forEach>
    </div>

    <div class="product-available-container">
        <c:forEach var="product" items="${productList}">
        <div class="product-box">
<%--            <p>${product.productName}</p>--%>
            <div class="product-image">

            </div>

        </div>
        </c:forEach>
    </div>

</div>

<%--    <div style="width: 80%;margin: auto;">--%>
<%--<c:forEach var="product" items="${productList}">--%>
<%--    <h3>${product.productName}</h3>--%>

<%--</c:forEach>--%>
<%--    </div>--%>
</div>
<h3></h3>
<h3></h3>
</body>
</html>