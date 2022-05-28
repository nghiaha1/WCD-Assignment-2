<%@ page import="com.ass.wcdassignment2.entity.Chef" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: maxxm
  Date: 5/28/2022
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Chef> chList = (List<Chef>) request.getAttribute("chList");
  if (chList == null) {
    chList = new ArrayList<>();
  }

%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/user/includes/head.jsp"></jsp:include>

<body>
<div class="container-xxl bg-white p-0">

  <!-- Navbar & Hero Start -->
  <jsp:include page="/user/includes/header.jsp"></jsp:include>
  <!-- Navbar & Hero End -->

  <!-- About Start -->
  <div class="container-xxl py-5">
    <div class="container">
      <div class="row g-5 align-items-center">
        <div class="col-lg-6">
          <div class="row g-3">
            <div class="col-6 text-start">
              <img class="img-fluid rounded w-100 wow zoomIn" data-wow-delay="0.1s" src="/user/dist/img/about-1.jpg">
            </div>
            <div class="col-6 text-start">
              <img class="img-fluid rounded w-75 wow zoomIn" data-wow-delay="0.3s" src="/user/dist/img/about-2.jpg" style="margin-top: 25%;">
            </div>
            <div class="col-6 text-end">
              <img class="img-fluid rounded w-75 wow zoomIn" data-wow-delay="0.5s" src="/user/dist/img/about-3.jpg">
            </div>
            <div class="col-6 text-end">
              <img class="img-fluid rounded w-100 wow zoomIn" data-wow-delay="0.7s" src="/user/dist/img/about-4.jpg">
            </div>
          </div>
        </div>
        <div class="col-lg-6">
          <h5 class="section-title ff-secondary text-start text-primary fw-normal">About Us</h5>
          <h1 class="mb-4">Welcome to <i class="fa fa-utensils text-primary me-2"></i>Restoran</h1>
          <p class="mb-4">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu diam amet diam et eos erat ipsum et lorem et sit, sed stet lorem sit.</p>
          <p class="mb-4">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu diam amet diam et eos. Clita erat ipsum et lorem et sit, sed stet lorem sit clita duo justo magna dolore erat amet</p>
          <div class="row g-4 mb-4">
            <div class="col-sm-6">
              <div class="d-flex align-items-center border-start border-5 border-primary px-3">
                <h1 class="flex-shrink-0 display-5 text-primary mb-0" data-toggle="counter-up">15</h1>
                <div class="ps-4">
                  <p class="mb-0">Years of</p>
                  <h6 class="text-uppercase mb-0">Experience</h6>
                </div>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="d-flex align-items-center border-start border-5 border-primary px-3">
                <h1 class="flex-shrink-0 display-5 text-primary mb-0" data-toggle="counter-up">50</h1>
                <div class="ps-4">
                  <p class="mb-0">Popular</p>
                  <h6 class="text-uppercase mb-0">Master Chefs</h6>
                </div>
              </div>
            </div>
          </div>
          <a class="btn btn-primary py-3 px-5 mt-2" href="">Read More</a>
        </div>
      </div>
    </div>
  </div>
  <!-- About End -->


  <!-- Team Start -->
  <div class="container-xxl pt-5 pb-3">
    <div class="container">
      <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
        <h5 class="section-title ff-secondary text-center text-primary fw-normal">Team Members</h5>
        <h1 class="mb-5">Our Master Chefs</h1>
      </div>
      <div class="row g-4">
        <% for (int i = 0; i < 4; i++) { %>
        <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
          <div class="team-item text-center rounded overflow-hidden">
            <div class="rounded-circle overflow-hidden m-4">
              <img class="img-fluid" src="<%= chList.get(i).getThumbnail() %>" alt="">
            </div>
            <h5 class="mb-0"><%= chList.get(i).getName() %></h5>
            <small><%= chList.get(i).getDescription() %></small>
          </div>
        </div>
        <% } %>
      </div>
    </div>
  </div>
  <!-- Team End -->
  
  <jsp:include page="/user/includes/footer.jsp"></jsp:include>

</div>

<!-- JavaScript Libraries -->
<jsp:include page="/user/includes/script.jsp"></jsp:include>
</body>

</html>
