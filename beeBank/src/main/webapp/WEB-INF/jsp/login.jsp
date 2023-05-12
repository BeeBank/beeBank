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
    <title>Login</title>
</head>
<body class="d-flex align-items-center justify-context-center">
    <!--Login Card-->
    <div class="card login-form-card col-4 mx-auto">
        <!--Card Body-->
        <div class="card-body">
            <!--Form Header-->
            <h1 class="form-header card-title mb-3">
                <i class="fa fa-user"></i> Login
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
                        <c:if test="${requestScope.error != null}">
                            <div class="alert alert-danger text-center border border-danger">
                                <b>${requestScope.error}</b>
                            </div>
                        </c:if>
                        <!-- End of Display Message -->

            <!--Login Form-->
            <form action="/login" method = "POST" class="login-form">
                <!--Form Group-->
                <div class="form-group col">
                    <input type="email" name="email" class="form-control form-control-lg" placeholder="Enter Email"/>
                 </div>
                 <!--End of form group-->

                  <!--Row-->
                <div class="row">

                    <!--Form Group-->
                    <div class="form-group col">
                        <input type="password" name="password" class="form-control form-control-lg" placeholder="Enter Password"/>
                     </div>
                     <!--End of form group-->
   
                                         <!--Form Group-->
                    <div class="form-group col">
                        <input type="hidden" name="_token" value="${token}"/>
                     </div>
                     <!--End of form group-->
    
                   </div>
                   <!--End of row-->

                   <!--Form Group-->
                    <div class="form-group col-15">
                        <button class="btn btn-lg btn-primary col-3 border-0">Login</button>
                    </div>
                    <!--End of form group-->
            </form>
            <!--Card Text-->
            <p class="card-text">
                Don't have an account? <span class="ms-2 text-warning"><a href="/register" class="btn btn-sm text-warning">Sign Up</a></span>
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