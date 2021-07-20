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
              <a href="/home"><img src="img/logo.png" id="logoimg"></a>
              </div>
              <div class="column">
                <nav>
                  <ul class="menu">
                    <a href="/home" style="text-decoration: none;"><li>Home</li></a>
                    <a href="/about" style="text-decoration: none;"><li>About us</li></a>
                    <a href="/products" style="text-decoration: none;"><li>Products</li></a>
                    <a href="/partners" style="text-decoration: none;"><li>Partners</li></a>
                  </ul>
              </nav>
            </div>
            <div class="column" >
              <a href="/login" id="LoginLink">Login Here</a>
            </div>
            </div>
            </header>
            <div id="main-container">
              <div id="container2">
                <div class="Content">
                  <h1>From Farmers to Consumers</h1>
                  <p>Buy best quality product directly from farmers.</p>
                </div>
                <div class="ContactDetails">
                  <p>Intrested in selling your Product</p>
                  <p>Fill in so that we can contact you</p>
                </div>
                <div class="form1">
                  <form action="Contactme">
                  <input type="text" name="name" placeholder="Enter your name" required>
                  <input type="email" name="email" placeholder="email">
                  <input type="tel" name="phone" pattern="[789]{1}[0-9]{9}" placeholder="Enter phone number" required>
                  <button type="submit" id="subbutton" value="submit">Submit Details</button>
                </form>
                </div>
              </div>
            </div>

              <div class="Steps">
                <div id="step1">
                  <h1>Step 1</h1>
                <h3>Login and select the product  you want to buy </h3>
                </div>
                <div id="step2">
                  <h1>Step 2</h1>
                  <h3>Select amount of product</h3>
                </div>
                <div id="step3">
                  <h1>Step 3</h1>
                  <h3>Select the delivery Partner</h3>
                </div>
                <div id="end">
                  <h1> And it's that Simple</h1>
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