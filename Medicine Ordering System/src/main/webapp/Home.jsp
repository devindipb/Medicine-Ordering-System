<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="Home.css">
  </head>

  <body>
    <nav>
      <div class="logo">
        <img src="./Images/LOGOOOO.png" width="100px" height="50px">
      </div>
      <ul>
        <li><a href="#">Home</a></li>
        <li><a href="product.jsp">Products</a></li>
        <li><a href="feedback.html">FeedBack</a></li>
        <li><a href="#">About</a></li>
        <li><a href="reg.html" class="button">Sign Up</a></li>
        <li>
          <div class="dropdown">
            <button class="button"><a href="#">Sign In</a></button>
            <div class="dropdown-content">
              <a href="reg.jsp">Customer</a>
              <a href="AddMedicine.jsp">Pharmacist</a>
              <a href="pharmacy.html">Admin1</a>
              <a href="regdeliverystaff.html">Admin2</a>
            </div>
          </div>
        </li>

      </ul>
    </nav>
    <div class="content">
      <h1>Your Health<br><span>Our Priority!</span></h1>
      <p class="par">Browse a wide range of medicines, vitamins, and wellness products, with easy ordering and doorstep
        delivery</p>



    </div>

    <div class="slideshow-container">
      <div class="mySlides fade">
        <img src="./Images/1.png" style="width:100%">
      </div>

      <div class="mySlides fade">
        <img src="./Images/2.png" style="width:100%">
      </div>
      <div class="mySlides fade">
        <img src="./Images/3.png" style="width:100%">
      </div>
    </div>

    <script>
      let slideIndex = 0;
      showSlides();

      function showSlides() {
        let i;
        let slides = document.getElementsByClassName("mySlides");

        for (i = 0; i < slides.length; i++) {
          slides[i].style.display = "none";
        }

        slideIndex++;

        if (slideIndex > slides.length) {
          slideIndex = 1;
        }

        slides[slideIndex - 1].style.display = "block";
        setTimeout(showSlides, 7000);
      }
    </script>
    <!--  
        <footer>
    <div class="footerContainer">
        <div class="socialIcons">
            <a href=""><i class="fa-brands fa-facebook"></i></a>
            <a href=""><i class="fa-brands fa-instagram"></i></a>
            <a href=""><i class="fa-brands fa-twitter"></i></a>
            <a href=""><i class="fa-brands fa-youtube"></i></a>
        </div>
        <div class="footerNav">
            <a href="">Home</a>
            <a href="">Blogs</a>
            <a href="">About</a>
            <a href="">Contact Us</a>
            
        </div>
    </div>
</footer>
 -->
  </body>

  </html>