
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link rel="stylesheet" type="text/css" href="../../css/checkout.css">
</head>
<body>
<div class="main-div">
    <div class="debit-card">
        <h3 style="color: white;text-align: center;">UCO Bank</h3>
        <div class="chip"><img src="../../img/chip-1-logo-png-transparent.png" width="50px" height="50px"></div>
        <input type="text"class="card-input" placeholder="Card-holder name" required/>
        <input type="text" class="card-input1" placeholder="Card-number" required/>
        <input type="text" class="card-input2" placeholder="CVV" required/>
        <input type="text" class="card-input3" value="Amount:${totalprice}" readonly/>
        <a href="/customerpage/pay"><button>Pay</button></a>
        <div class="logo"><img src="../../img/master-card.png" width="90px" height="70px"></div>
    </div>
</div>
</body>
</html>