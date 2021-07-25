<%@ page import="com.Emarket.Model.User" %>
<%@ page import="com.Emarket.DAO.ProductDAOImpl" %>
<%@ page import="com.Emarket.Model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Emarket.Model.Category" %>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="java.util.ArrayList" %>
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
    String cat=request.getParameter("category");


%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                    <a href="${pageContext.request.contextPath}/customerpage/cart" style="text-decoration: none;"><li>Cart [${productsInCart}]</li></a>
                </ul>
            </nav>
        </div>
        <div class="column" >
            <span id="welcomeholder">Welcome <%=user.getCustomer().getCustName()%>!</span>
            <a href="/logout" id="LoginLink">Logout here</a>
        </div>
    </div>
</header>
<div style="text-align: center;">
    <h3>All Products</h3>
</div>
<div class="product-type-container">


    <div class="product-type">
        <div id="categories1">Categories</div>
        <a href="${pageContext.request.contextPath}/customerpage/allproducts?category=all"> <div class="categories">
            All Products
        </div> </a>
        <c:forEach var="category" items="${categoryList}">
            <a href="${pageContext.request.contextPath}/customerpage/allproducts?category=${category.category}"> <div class="categories">
                    ${category.category}
            </div> </a>
        </c:forEach>
    </div>
    <c:set var="type" value="<%=cat%>"/>

    <div class="product-available-container">
        <c:choose>
            <c:when test="${type=='all'}">
                <c:forEach var="allproduct" items="${allProductList}">

                        <div class="product-box">

                            <div class="product-image" >
                                    ${allproduct.productName}
                            </div>
                            <div class="product-description"></div>
                            <div class="buy-cart-button">
                                <a href="${pageContext.request.contextPath}/customerpage/addtocart?productid=${allproduct.productId}&category=${type}&id=<%= user.getCustomer().getCustomerId()%>"><button  class="addtocart">Add to cart</button></a>
                                <span>&#8377; ${allproduct.price}</span>
                            </div>
                        </div>


                </c:forEach>
            </c:when>
            <c:when test="${type==null}">
                <c:forEach var="allproduct" items="${allProductList}">

                    <div class="product-box">

                        <div class="product-image" >
                                ${allproduct.productName}
                        </div>
                        <div class="product-description"></div>
                        <div class="buy-cart-button">
                            <a href="${pageContext.request.contextPath}/customerpage/addtocart?productid=${allproduct.productId}&category=${type}&id=<%= user.getCustomer().getCustomerId()%>"><button  class="addtocart">Add to cart</button></a>
                            <span>&#8377; ${allproduct.price}</span>
                        </div>
                    </div>

                </c:forEach>
            </c:when>
            <c:otherwise>
        <c:forEach var="allproduct" items="${allProductList}">
            <c:if test="${allproduct.productType==type}">
            <div class="product-box">

                <div class="product-image" >
                     ${allproduct.productName}
                </div>
                <div class="product-description"></div>
                <div class="buy-cart-button">
                    <a href="${pageContext.request.contextPath}/customerpage/addtocart?productid=${allproduct.productId}&category=${type}&id=<%= user.getCustomer().getCustomerId()%>"><button  class="addtocart">Add to cart</button></a>
                    <span>&#8377; ${allproduct.price}</span>
                </div>
            </div>
            </c:if>
        </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>


</div>

</div>
</body>
</html>