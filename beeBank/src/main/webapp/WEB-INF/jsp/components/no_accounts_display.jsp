<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
    
    <!--Container: No Accounts-->
    <div class="container">
        <!--Card: No Accounts-->
        <div class="card no-accounts-card">
            <!--Card Body-->
            <div class="card-body">
                <!--Card Title-->
                <h1 class="card-title">
                    <i class="fa fa-ban text-danger"></i> No Registered Accounts
                </h1>
                <hr>
                <!--End Card Title-->

                <!--Card Text-->
                <div class="card-text">
                    You currently do not have any registered accounts. <br>
                    Please click below to register / add a new account.
                </div>
                <!--End Card Text-->
                <br>
                <button class="btn btn-primary btn-sm" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                    <i class="fa fa-credit-card"></i>  Add New Account
                </button>
            </div>
            <!--End Card Body-->
        </div>
        <!--End of Card: No Accounts-->
    </div>
    <!--End Container: No Accounts-->