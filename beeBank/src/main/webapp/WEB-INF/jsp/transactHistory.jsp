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

    <!--Container-->
    <div class="container">
        <!--Card: Transaction History Card-->
        <div class="card transaction-history shadow">
            <!--Card Header-->
            <div class="card-header">
                <i class="fas fa-credit-card me-2" aria-hidden="true"></i>Transaction History
            </div>
            <!--End Of Card Header-->

            <!--Card Body-->
            <div class="card-body">
                <c:if test=" ${requestScope.transact_history != null}">
                    <!--Payment History Table-->
                    <table class="table text-center table-striped">
                        <tr>
                            <th>Transaction ID</th>
                            <th>Transaction Type</th>
                            <th>Amount</th>
                            <th>Source</th>
                            <th>Status</th>
                            <th>Reason Code</th>
                            <th>Created at</th>
                        </tr>   
                        <c:forEach items="${requestScope.transact_history}" var = "transact_history">
                            <tr>
                                <td>${transact_history.transaction_id}</td>
                                <td>${transact_history.transaction_type}</td>
                                <td>${transact_history.amount}</td>
                                <td>${transact_history.source}</td>
                                <td>${transact_history.status}</td>
                                <td>${transact_history.reason_code}</td>
                                <td>${transact_history.created_at}</td>
                            </tr>
                        </c:forEach>  
                        <!-- End Of Loop Through Transaction History Records-->    
                    </table>
                    <!-- -->
                </c:if>
            </div>
            <!--End Of Card Body-->
        </div>
        <!--End Of Card: Transaction History Card -->
    </div>
    <!--End Of Container-->



     <!-- Footer -->
     <c:import url="components/incl/footer.jsp"/>