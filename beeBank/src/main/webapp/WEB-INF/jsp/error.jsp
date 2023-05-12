<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet"  type='text/css'>
    <link rel="stylesheet" href="css/fontawesome/css/all.css">
    <link rel="stylesheet" href="css/default.css">
    <title>Errors</title>
</head>
<body class="d-flex align-items-center justify-content-center">
   

        <!--Error Card-->
        <div class="card col-4 alert alert-white border border-danger">
            <!--Card Title-->
            <h3 class="card-title">
                <i class="fa fa-solid fa-exclamation "></i> Errors
            <hr>
            </h3>
            <!--End of Card Title-->
                <!---Card Body-->
                <div class="card-body">
                    <!--Card Text-->
                    <p class="card text bg-transparent border-0">
                        <!-- Display Message -->
                        <c:if test="${requestScope.error != null}">
                            <div class="alert alert-danger text-center border border-danger">
                                <b>${requestScope.error}</b>
                            </div>
                        </c:if>
                        <!-- End of Display Message -->
                    </p>
                    <!--End Card Text-->
                    <hr>
                    <!--Back to login-->
                    <a href="/login" class="btn btn-sm btm-danger bg-danger text-white">
                        <i class="fa fa-arrow-left me-1"></i> Back
                    </a>
                    <!--End Back to login-->
                </div>
                <!--End of Card Body-->
            </h3>
            <!--End Card Title-->
        </div>
        <!--End Error Card-->
    
</body>
</html>