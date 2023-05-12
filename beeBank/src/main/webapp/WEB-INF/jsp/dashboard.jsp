<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.css">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet"  type='text/css'>
    <link rel="stylesheet" href="css/main.css">
    <script src="bootstrap-5.0.2-dist/js/bootstrap.bundle.js"></script>
    <title>Dashboard</title>
</head>
<body>
  

    <c:import url="components/incl/header.jsp"/>

    <!-- Transact OffCanvas pulls from the left-->

    <c:import url="components/transact_offcanvas.jsp"/>

        <!-- Add Accounts OffCanvas pulls from the right-->

        <c:import url="components/add_account_offcanvas.jsp"/>

        <c:choose>
            <c:when test="${fn:length(userAccounts) > 0}">
                <!--when theres more than 0 accts -->
                <c:import url="components/accounts_display.jsp"/>
            </c:when>
            <c:otherwise>
                <c:import url="components/no_accounts_display.jsp"/>
            </c:otherwise>
</c:choose>


    <!-- Display Accounts-->




    <c:import url="components/incl/footer.jsp"/>



