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
    if(!user.getConsumerType().equalsIgnoreCase("customer")) {
        session.setAttribute("message","You are not admin");
        response.sendRedirect("login");
        return;
    }
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <a href="${pageContext.request.contextPath}/customerpage/allproducts?category=all" style="text-decoration: none;"><li>Product</li></a>
                    <a href="${pageContext.request.contextPath}/customerpage/History" style="text-decoration: none;"><li>History</li></a>
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
<div id="section1">
    <div id="intro">
        <h1>Thankyou for choosing E-market</h1>
        <h3>We Try our best to provide you the freshest product int the market</h3>
        <a href="${pageContext.request.contextPath}/customerpage/allproducts?category=all"><button class="shop-now">Shop Now</button></a>

    </div>
    <div class="skewed"></div>
</div>

<div class="page-discription">
    <h1 style="text-align: center;">How we work</h1>
    <div class="motive">
        <div class="consumerinfo">
            <h4>We Contact Farmers</h4>
            <img src="img/contact_farmer1.jpg" style="margin-left: 70px; height: 170px;width: 300px;">
        </div>
        <div class="consumerinfo">
            <h4>Farmer process their products </h4>
            <img src="img/farmprocess.jpg" style="margin-left: 70px;">
        </div>
        <div class="consumerinfo">
            <h4> They Sell on our Website</h4>
            <img src="img/sellProduct.jpg" style="margin-left:70px;">
        </div>
    </div>
</div>
<div class="qualitychecks">
    <h1 style="text-align: center;">Quality check</h1>
    <div class="qualitycheck-steps">
        <table class="qualitycheck-table">
            <tr>
                <td style="padding-left: 180px;">&#9989 Moisture Free</td>
                <td  style="padding-left: 180px;">&#9989 Free From adultration</td>
            </tr>
            <tr>
                <td  style="padding-left: 180px;">&#9989 Throughly Cleaned</td>
                <td style="padding-left: 180px;">&#9989 Right Grade</td>
            </tr>
            <tr>
                <td  style="padding-left: 180px;">&#9989 Free From Infestation</td>
                <td  style="padding-left: 180px;">&#9989 Free From Foreign Matter</td>
            </tr>

        </table>
    </div>
</div>
<footer>
    <div class="social-footer">
        <div class="centre">
            <img class="imgclass3" src="img/twitter.png" alt="twitter" height="48" width="55">
        </div>

    </div>
    <div class="social-footer">
        <div class="centre">
            <img class="imgclass3" src="img/facebook.png" alt="facebook" height="55" width="28">
        </div>

    </div>
    <div class="social-footer1">
        <div class="centre">
            <img  class="imgclass3"src="img/instagram.png" alt="instagram" height="52" width="52">
        </div>

    </div>
    <div class="copyright">
        <span> &copy; Copyright 2021 E-Market - Made with &hearts; in India</span>
    </div>
</footer>
</body>
</html>