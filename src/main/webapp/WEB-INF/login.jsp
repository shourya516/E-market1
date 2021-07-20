<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Gross Management and Distribution Portal</title>
    <link rel="stylesheet" type="text/css" href="css/agriwebsite.css">

</head>
<body>
<header>
    <div id="headerBox">
        <div class="column">
            <a href="website.html"><img src="img/logo.png" id="logoimg"></a>
        </div>
        <div class="column">
            <nav>
                <ul class="menu">
                    <a href="website.html" style="text-decoration: none;"><li>Home</li></a>
                    <a href="aboutus.html" style="text-decoration: none;"><li>About us</li></a>
                    <a href="Products.html" style="text-decoration: none;"><li>Products</li></a>
                    <a href="Partners.html" style="text-decoration: none;"><li>Partners</li></a>
                </ul>
            </nav>
        </div>

    </div>
</header>
<section>
    <div class="formcontainer">
        <div class="signinform" id="signinformContainer">

            <div class="button-box">
                <button type="button" class="toggle-btn" id="loginbtn" >Log In</button>
                <button type="button" class="toggle-btn" id="registerbtn">Register</button>
                <%@include file="message.jsp" %>
            </div>
            <form:form action="/authenticate" id="login" class="input-group" method="post" modelAttribute="user">
                <form:input type="text" class="input-field" placeholder="User Id/email" required="true" path="emailid"/>
                <form:select id="consumerType" name="consumerType" required="true" path="consumerType">
                    <option value="" selected disabled hidden="true">Log in as:</option>
                    <option value="customer">Customer</option>
                    <option value="vendor">Vendor</option>
                    <option value="dealer">Dealer</option>
                    <option value="admin">Admin</option>
                </form:select>
                <form:input type="password" class="input-field" placeholder="Enter password" required="required" path="loginPassword"/>
                <form:button type="submit" class="submit-btn" style="margin-top: 30px;" name="Login" >Log In </form:button>
            </form:form>
            <form:form id="customer" class="input-group" action="/customerRegistration" method="post" modelAttribute="customer" >
                <!-- <button type="button" class="toggle-btn1" id="customerbtn">Customer</button> -->
                <span style="margin-left: 40px; margin-right: 40px; padding-left: 10px;padding-right: 10px;"><form:button type="button" class="toggle-btn1" id="vendorbtn" onclick="vendorregister()">Vendor</form:button></span>
                <form:button type="button" class="toggle-btn1" id="dealerbtn" onclick="dealerregister()">Dealer</form:button>
                <form:input type="text" class="input-field" placeholder="Customer Name" required="required" path="custName"/>
                <form:input type="text" class="input-field" placeholder="Mobile number" pattern="[789]{1}[0-9]{9}" required="required" path="custMob"/>
                <form:input type="text" class="input-field" placeholder="User Id/email" required="required" path="custEmail"/>
                <form:input type="password" class="input-field" placeholder="Enter password" required="required" path="custPassword"/>
                <form:input type="text" class="input-field" placeholder="Enter communication address" required="required" path="custAddress"/>
                <form:input type="text" class="input-field" placeholder="State" required="required" path="custState"/>
                <form:input type="text" class="input-field" placeholder="pincode" required="required" path="custPincode"/>
                <form:input type="text" class="input-field" placeholder="City" required="required" path="custCity"/>
                <form:button type="submit" class="submit-btn" name="customerSubmit" id="customerSubmit">Submit Details </form:button>
            </form:form>

            <form:form id="Vendor" class="input-group" action="/vendorRegistration" modelAttribute="vendor" method="post">
                <span style="margin-left: 40px; margin-right: 40px;"><form:button type="button" class="toggle-btn1" id="customerbtn" onclick="customerregister()">Customer</form:button></span>
                <!-- <button type="button" class="toggle-btn1" id="vendorbtn">Vendor</button> -->
                <form:button type="button" class="toggle-btn1"  onclick="dealerregister()">Dealer</form:button>
                <form:input type="text" class="input-field" placeholder="Vendor Name" required="required" path="vendorName"/>
                <form:input type="text" class="input-field" placeholder="Mobile number" pattern="[789]{1}[0-9]{9}" required="required" path="vendorMob"/>
                <form:input type="text" class="input-field" placeholder="User Id/email" required="required" path="vendorEmail"/>
                <form:input type="password" class="input-field" placeholder="Enter password" required="required" path="vendorPassword"/>
                <form:input type="text" class="input-field" placeholder="Enter communication address" required="required" path="vendorAddress"/>
                <form:input type="text" class="input-field" placeholder="State" required="required" path="vendorState"/>
                <form:input type="text" class="input-field" placeholder="pincode" required="required" path="vendorPincode"/>
                <form:input type="text" class="input-field" placeholder="City" required="required" path="vendorCity"/>
                <form:button type="submit" class="submit-btn" name="vendorSubmit" id="vendorSubmit">Submit Details </form:button>
            </form:form>

            <form:form id="Dealer" class="input-group" action="/dealerRegistration" method="post" modelAttribute="dealer">
                <span style="margin-left: 40px; margin-right: 40px;"><form:button type="button" class="toggle-btn1"  onclick="customerregister()">Customer</form:button></span>
                <form:button type="button" class="toggle-btn1"  onclick="vendorregister()">Vendor</form:button>
                <!-- <button type="button" class="toggle-btn1" id="dealerbtn">Dealer</button> -->
                <form:input type="text" class="input-field" placeholder=" Dealer Name"  required="required" path="dealerName"/>
                <form:input type="text" class="input-field" placeholder="Mobile number" pattern="[789]{1}[0-9]{9}" required="required"  path="dealerMob"/>
                <form:input type="text" class="input-field" placeholder="User Id/email" required="required" path="dealerEmail"/>
                <form:input type="password" class="input-field" placeholder="Enter password" required="required" path="dealerPassword"/>
                <form:input type="text" class="input-field" placeholder="License number" required="required" path="licenseNumber"/>
                <form:input type="text" class="input-field" placeholder="Enter commmunication address" required="required" path="dealerAddress"/>
                <form:input type="text" class="input-field" placeholder="State" required="required" path="dealerState"/>
                <form:input type="text" class="input-field" placeholder="pincode" required="required" path="dealerPincode"/>
                <form:input type="text" class="input-field" placeholder="City" required="required" path="dealerCity"/>
                <form:button type="submit" class="submit-btn">Submit Details </form:button>
            </form:form>
        </div>
    </div>
</section>
<script>
    //login and registration btn
    var loginBtn=document.getElementById("loginbtn");
    var registerBtn=document.getElementById("registerbtn");
    var signinformholder=document.getElementById("signinformContainer");

    // Forms
    var customerFrom=document.getElementById("customer");
    var dealerForm=document.getElementById("Dealer");
    var vendorForm=document.getElementById("Vendor");
    var loginForm=document.getElementById("login");

    /* buttons for vendor, customer, Dealer */
    var Customerbtn=document.getElementById("customerbtn");
    var Vendorbtn=document.getElementById("vendorbtn");
    var Dealerbtn=document.getElementById("dealerbtn");

    registerBtn.onclick=function() {
        customerFrom.style.left="30px";
        loginForm.style.left="-450px";
        signinformholder.style.height="580px";
        vendorForm.style.left="450px";
        dealerForm.style.left="450px";

    }

    loginBtn.onclick=function() {
        customerFrom.style.left="450px";
        loginForm.style.left="40px";
        signinformholder.style.height="400px";
        vendorForm.style.left="450px";
        dealerForm.style.left="450px";
    }

    function customerregister() {
        customerFrom.style.left="30px";
        loginForm.style.left="-450px";
        signinformholder.style.height="600px";
        vendorForm.style.left="450px";
        dealerForm.style.left="450px";
    }
    function vendorregister() {
        customerFrom.style.left="450px";
        vendorForm.style.left="30px";
        signinformholder.style.height="600px";
        dealerForm.style.left="450px";
        loginForm.style.left="-450px";
    }

    function dealerregister() {
        customerFrom.style.left="450px";
        dealerForm.style.left="30px";
        loginForm.style.left="-450px";
        vendorForm.style.left="450px";
        signinformholder.style.height="650px";
    }


</script>

</body>
</html>