<%@ page import="com.Emarket.Model.User" %>
<%

    User user=(User)session.getAttribute("current-user");
    if(user==null) {
        session.setAttribute("message","Please login");
        response.sendRedirect("login");
        return;
    }
    if(!user.getConsumerType().equalsIgnoreCase("vendor")) {
        session.setAttribute("message","You are not vendor");
        response.sendRedirect("login");
        return;
    }

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Customer Page</title>
    <link rel="stylesheet" type="text/css" href="css/agriwebsite.css">
</head>
<body>
<header>
    <div id="headerBox">
        <div class="column">
            <a href="/home"><img src="img/logo.png" id="logoimg"></a>
        </div>
        <div class="column">
            <nav>
                <ul class="menu1" style="padding-left: 100px;">
                    <a href="${pageContext.request.contextPath}/vendorpage/addProducts" style="text-decoration: none;"><li>Product</li></a>
                    <a href="${pageContext.request.contextPath}/vendorpage/availableproducts?id=<%= user.getVendor().getVendorId()%>"<%out.print(user.getVendor().getVendorId());%>" style="text-decoration: none;"><li>Available</li></a>
                    <a href="${pageContext.request.contextPath}/vendorpage/sold" style="text-decoration: none;"><li>Sold</li></a>
                </ul>
            </nav>
        </div>
    </div>
</header>
</body>
</html>