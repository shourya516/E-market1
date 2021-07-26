<%@ page import="com.Emarket.Model.User" %>
<%

    User user=(User)session.getAttribute("current-user");
    if(user==null) {
        session.setAttribute("message","Please login");
        response.sendRedirect("login");
        return;
    }
    if(!user.getConsumerType().equalsIgnoreCase("admin")) {
        session.setAttribute("message","You are not admin");
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
    <title>Customer Page</title>
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
                <ul class="menu2" style="padding-left: 100px;">
                    <a href="${pageContext.request.contextPath}/adminpage/customerList" style="text-decoration: none;"><li>Customers</li></a>
                    <a href="${pageContext.request.contextPath}/adminpage/approvedealers" style="text-decoration: none;"><li>Dealers</li></a>
                    <a href="${pageContext.request.contextPath}/adminpage/vendorList" style="text-decoration: none;"><li>Vendors</li></a>
                </ul>
            </nav>
        </div>
        <div class="column" >
            <span id="welcomeholder">Welcome <%= user.getAdmin().getName()%>!</span>
            <a href="/logout" id="LoginLink">Logout here</a>
        </div>
    </div>
</header>
<div id="dealer-list">
<h3 style="text-align: center;color: black">List of Dealers to be approved</h3>
<div class="dealer-list-container">
    <table>
        <tr>
            <th class="table-column">Name</th>
            <th class="table-column">License No.</th>
            <th class="table-column">Approve/Reject</th>
        </tr>
    <c:forEach var="list" items="${unapprovedList}">
        <tr>
        <td class="table-column">${list.dealerName}</td>
        <td class="table-column">${list.licenseNumber}</td>
            <td class="table-column"><a href="${pageContext.request.contextPath}/adminpage/approve?status=verified&id=${list.dealerId}"><button class="approve-btn">Approve</button></a><a><button class="reject-btn">Reject</button></a></td>
        </tr>
    </c:forEach>
    </table>
</div>
</div>
</body>
</html>
