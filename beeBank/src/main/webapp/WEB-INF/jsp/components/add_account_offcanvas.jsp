<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

    <!--Start of Right Off Canvas-->
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header">
            <h5 id="offcanvasRightLabel">Create / Add an Account</h5>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
    <!--Start Off Canvas Body: Acounts-->
    <div class="offcanvas-body">
        <!--Card Accounts Form-->
        <div class="card">
            <!--Card Body-->
            <div class="card-body">
                <!--Form Group-->
                <form action="" class="add-account-form">
                    <div class="form-group mb-3">
                        <label for=""> Enter Account Name</label>
                        <input type="text" name="account_name" class="form-control" placeholder="Enter Account name...">
                    </div>
                <!--End Form Group-->

                <!--Form Group-->
                    <div class="form-group mb-3">
                        <label for="">Select Account Type</label>
                        <select name="account_type" class="form-control" id="">
                            <option value="checking">Checking</option>
                            <option value="savings">Savings</option>
                            <option value="business">Business</option>
                        </select>
                    </div>
                </form>
                <!--End Form Group-->
                <!--Form Group-->
                <form action="" class="add-account-form">
                    <div class="form-group mb-3">
                        <button id="transact-btn" class="btn btn-md btn-primary">Create Account</button>
                    </div>
                <!--End Form Group-->
            </div>
            <!--End Card Body-->

        </div>

        <!--End of Card Accounts Form-->


    </div>
    <!--End Off Canvas Body: Accounts-->

    </div>
    <!--End of Right Off Canvas-->