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
<section id="section1">
    <h1>thankyou for choosing E-market</h1>
    <div class="skewed"></div>

</section>

</div>

</body>
</html>