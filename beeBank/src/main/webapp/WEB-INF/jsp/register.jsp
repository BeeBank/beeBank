<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/fontawesome/css/all.css">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet"  type='text/css'>
    <link rel="stylesheet" href="css/default.css">
    <title>Register</title>
</head>
<body class="d-flex align-items-center justify-context-center">
    <!--Registration Card-->
    <div class="card registration-form-card col-6 mx-auto">
        <!--Card Body-->
        <div class="card-body">
            <!--Form Header-->
            <h1 class="form-header card-title mb-3">
                <i class="fa fa-edit"></i> Register
            </h1>
            <!--End form Header-->
            
            <!-- Display Message -->
            <c:if test="${requestScope.passwordMisMatch != null}">
                <div class="alert alert-danger text-center border border-danger">
                    <b>${requestScope.passwordMisMatch}</b>
                </div>
            </c:if>
            <!-- End of Display Message -->

            <!-- Display Message -->
            <c:if test="${requestScope.success != null}">
                <div class="alert alert-success text-center border border-success">
                    <b>${requestScope.success}</b>
                </div>
            </c:if>
            <!-- End of Display Message -->

            <!--Form-->
            <form:form action="/register" class="reg-form" modelAttribute="registerUser"> 
                <!--Row-->
                <div class="row">

                 <!--Form Group-->
                 <div class="form-group col">
                    <form:input type="text" path="first_name" class="form-control form-control-lg" placeholder="Enter First Name"/>
                    <form:errors path="first_name" class="text-white bg-danger"/>
                 </div>
                 <!--End of form group-->

                 <!--Form Group-->
                 <div class="form-group col">
                    <form:input type="text" path="last_name" class="form-control form-control-lg" placeholder="Enter Last Name"/>
                    <form:erros path="last_name" class="text-white bg-danger"/>
                 </div>
                 <!--End of form group-->
                </div>
                <!--End of row-->

                <!--Form Group-->
                <div class="form-group col-15">
                    <form:input type="email" path="email" class="form-control form-control-lg" placeholder="Enter Email"/>
                    <form:erros path="email" class="text-white bg-danger"/>

                 </div>
                 <!--End of form group-->

                  <!--Row-->
                <div class="row">

                    <!--Form Group-->
                    <div class="form-group col">
                       <form:input type="password" path="password" class="form-control form-control-lg" placeholder="Enter Password"/>
                       <form:errors path="password" class="text-while bg-danger"/>
                    </div>
                    <!--End of form group-->
   
                    <!--Form Group-->
                    <div class="form-group col">
                       <input type="password" name="confirm_password" class="form-control form-control-lg" placeholder="Confirm Password"/>
                       <small class="text-while bg-danger">${confirm_pass}</small>
                    </div>
                    <!--End of form group-->
                   </div>
                   <!--End of row-->

                   <!--Form Group-->
                    <div class="form-group col-15">
                        <button class="btn btn-lg btn-primary col-3 border-0">Register</button>
                    </div>
                    <!--End of form group-->
            </form:form>
            <!--Card Text-->
            <p class="card-text">
                Already have an account? <span class="ms-2 text-warning"><a href="/login" class="btn bt-sm text-warning">Sign In</a></span>
            </p>
            <!--End card text-->

            <!-- Back Button To Landing Page-->
            <small class="text-warning">
                <i class="fa fa-arrow-left fa-beat"></i> <a href="/" class="btn btn-sm">Back</a>
            </small>
            <!-- End Back Button To Landing Page-->


            <!--End Form-->
        </div>
    </div>
    
</body>
</html>