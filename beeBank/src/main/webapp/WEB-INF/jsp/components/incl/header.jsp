<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- Main Page Header -->
<header class="d-flex main-page-header mb-3">
    <!-- Container -->
    <div class="container d-flex">
        <!-- Company Name -->
        <div class="company-logo">
            <img src="../images/beebankLogo.png">
        </div>
        <!-- Company Name -->

        <!-- Navigation -->
        <nav class="navigation my-2">
            <li><a href="/app/dashboard">Dashboard</a></li>
            <li><a href="/app/payment_history">Payment History</a></li>
            <li><a href="/app/transact_history">Transaction History</a></li>
        </nav>
        <!-- End Of Navigation -->

        <!-- Display Name -->
        <div class="d-flex justify-content-end w-27 display-name text-white my-2 ms-1">
            <i class="fa fa-circle text-success my-1 mr-1"></i> User: <span> ${user.first_name}  ${user.last_name}</span>
        </div>
        <!-- End Of Display Name -->

        <!-- Log Out BUtton -->
        <a href="/logout" class="btn btn-sm ms-2 my-1 text-white">
            <i class="fa fa-sign-out me-2 text-white"></i> Sign Out
        </a>
        <!-- End Of Log Out BUtton -->
    </div>
    <!-- End Of Container -->
</header>
<!-- End Of Main Page Header -->
