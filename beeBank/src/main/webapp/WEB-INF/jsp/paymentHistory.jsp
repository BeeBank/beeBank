<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap-5.0.2-dist/css/bootstrap.css">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet"  type='text/css'>
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/bootstrap.bundle.js"></script>
    <title>Dashboard</title>
</head>
<body>
  
    <!-- Header -->
    <c:import url="components/incl/header.jsp"/>



    <!-- Container -->
    <div class="container">

       <!-- Card: Payment History Card -->
       <div class="card">
            <!-- Card Header -->
            <div class="card-header">
                <i class="fas fa-credit-card me-2" aria-hidden="true"></i> Payment History
            </div>
            <!-- End Of Card Header -->
            <!-- Card Body -->
            <div class="card-body">
            <c:if test="${requestScope.payment_history != null}">
                <!-- Payment History Table -->
                <table class="table text-center table-striped">
                    <tr>
                        <th>Payment Number</th>
                        <th>Payment Type</th>
                        <!-- <th>Beneficiary Account Number</th> -->
                        <th>Amount</th>
                        <!-- <th>Status</th> -->
                        <!-- <th>Reference</th> -->
                        <th>Status</th>
                        <th>Payment Date</th>
                    </tr>
                    <!-- Loop Through Payment History Records -->
                    <c:forEach items="${requestScope.payment_history}" var="paymenthist">
                    <tr>
                        <td>${paymenthist.payment_id}</td>
                        <td>${paymenthist.beneficiary}</td>
                        <!-- <td>${payments.beneficiary_acc_no}</td> -->
                        <td>${paymenthist.amount}</td>
                        <!-- <td>${payments.status}</td> -->
                        <!-- <td>${payments.reference_no}</td> -->
                        <td>${paymenthist.reason_code}</td>
                        <td>${paymenthist.created_at}</td>
                    </tr>
                     </c:forEach>
                    <!-- End Of Loop Through Payment History Records -->

                </table>
                <!-- End Of Payment History Table -->
            </c:if>
            </div>
            <!-- End Of Card Body -->
       </div>
       <!-- End Of Card: Payment History Card -->
    </div>
    <!-- End Of Container -->




  <!-- Footer -->
   <c:import url="components/incl/footer.jsp"/>

