<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
 
 <!--Main Header-->
  <header class="d-flex main-page-header mb-3">
    <!--Container-->
    <div class="container d-flex">
        <!--BeeBank Logo-->
        <div class="company-logo">
            <img src="images/beebankLogo.png">
        </div>
        <!--End BeeBank Logo-->
    </div>
    <!--End Container-->

    <!--Navigation-->
    <nav class="navigation my-2">
        <li><a href="">Dashboard</a></li>
        <li><a href="">Payment History</a></li>
        <li><a href="">Transaction History</a></li>
    </nav>
    <!--End Navigation-->

    <!--Display Name-->
    <div class="d-flex justify-content-end w-27 display-name text-white my-2 ms-1">
        <i class="fa fa-circle text-success my-1 mr-1"></i>Welcome: <span> John Doe</span>
    </div>
    <!--End Display Name-->
    <!--Logout Button-->
    <a href="" class="btn btn-sm ms-2 my-1 text-white">
        <i class="fa fa-sign-out me-2 text-white"></i> Sign Out
    </a>
    <!--Logout Button-->
</header>
<!--End Main Header-->