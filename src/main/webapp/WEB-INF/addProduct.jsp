<%@ page import="com.Emarket.Model.User" %>
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
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Vendor Page</title>
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
                    <a href="${pageContext.request.contextPath}/vendorpage/availableproducts?id=<%= user.getVendor().getVendorId()%>"<%out.print(user.getVendor().getVendorId());%> style="text-decoration: none;"><li>Available</li></a>
                    <a href="${pageContext.request.contextPath}/vendorpage/sold" style="text-decoration: none;"><li>Sold</li></a>
                </ul>
            </nav>
        </div>
        <div class="column" >
            <span id="welcomeholder">Welcome <%= user.getVendor().getVendorName()%>!</span>
            <a href="/logout" id="LoginLink">Logout here</a>
        </div>
    </div>
</header>
<div class="addproduct">

    <div class="formcont">
        <form:form action="/vendorpage/submitProductDetails" method="post" modelAttribute="product">
            <form:select id="selector" required="true" path="productType">
                <option value="" selected disabled hidden="true" >Product type</option>
                <option value="grains">Grains</option>
                <option value="vegetables">vegetables</option>
                <option value="oilseeds">oil seed</option>
                <option value="nuts">Nuts</option>
                <option value="oil"> oil</option>
            </form:select>
            <form:input type="text" class="product-in" required="true" placeholder="product name" path="productName" />
            <form:input type="text" class="product-in" required="true" placeholder="Description" path="productDescription"/>
            <form:input type="text" class="product-in" required="true"  path="vendorId" value="<%=user.getVendor().getVendorId()%>" readonly="true" />
            <form:input type="text" class="product-in" required="true" placeholder="vendor Description" path="vendorDescription"/>
<%--            <form:input type="text" class="product-in" required="required" path=""/>--%>
            <form:input type="number" class="product-in" required="required" placeholder="quantity" path="quantity" />
            <form:input type="text" class="product-in1" required="required" placeholder="price" path="price" />

            <form:button type="submit" class="submit-prod">Submit details</form:button>
            <form:button type="reset" class="reset-prod">Reset</form:button>
        </form:form>
    </div>
</div>
</body>
</html>
