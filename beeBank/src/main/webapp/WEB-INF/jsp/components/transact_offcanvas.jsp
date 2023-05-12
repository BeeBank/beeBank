<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>


     <!--Start of OffCanvas-->
     <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
        <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasExampleLabel">Transact</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <!--Offcanvas Transact Body-->
        <div class="offcanvas-body">
            <small class="card-text">
                Choose an Option
            </small>
            <!--Transaction Type Dropdown-->
            <select name="transact-type" class="form-control my-3" id="transact-type">
                <option value="">-- Select Transaction Type --</option>
                <option value="payment">Payment</option>
                <option value="transfer">Transfer</option>
                <option value="deposit">Deposit</option>
                <option value="withdrawal">Withdrawal</option>
                
            </select>
            <!--End of Transaction Type Dropdown-->

          

          
            <!--Card: Deposit-->
            <div class="card deposit-card">
                <!--Card Body-->
                <div class="card-body">
                    <!--Deposit Form -->
                    <form action="" class="deposit-form">
                        <!--Form Group-->
                    <div class="form-group mb-2">
                        <label for="">Enter Deposit Amount</label>
                        <input type="text" name="deposit_amount" class="form-control" placeholder="Enter deposit Amount">
                    </div>
                    <!--End Form Group-->

                    <!--Form Group-->
                    <div class="form-group">
                        <label for="">Select Account</label>
                        <!--Start select account-->
                    <select name="account_id" class="form-control" id="">
                        <option value="">-- Select Account --</option>
                    </select>
                    <!--End select account-->
                    </div>
                    <!--End form Group-->

                    <!--Form Group-->
                    <div class="form-group my-1">
                        <button id="transact-btn" class="btn btn-md btn-primary">Deposit</button>
                    </div>
                    <!--End Form Group-->
                    </form>
                    <!--End Deposit Form-->
                </div>
                <!--End Card Body-->
            </div>
            <!--End Card: Deposit-->

            <!--Card: Withdrawal-->
            <div class="card withdrawal-card">
                <!--Card Body-->
                <div class="card-body">
                    <!--Withdrawal Form -->
                    <form action="" class="withdrawal-form">
                        <!--Form Group-->
                    <div class="form-group mb-2">
                        <label for="">Enter Withdrawal Amount</label>
                        <input type="text" name="withdrawal_amount" class="form-control" placeholder="Enter Withdrawal Amount">
                    </div>
                    <!--End Form Group-->

                    <!--Form Group-->
                    <div class="form-group">
                        <label for="">Select Account</label>
                        <!--Start select account-->
                    <select name="account_id" class="form-control" id="">
                        <option value="">-- Select Account --</option>
                    </select>
                    <!--End select account-->
                    </div>
                    <!--End form Group-->

                    <!--Form Group-->
                    <div class="form-group my-1">
                        <button id="transact-btn" class="btn btn-md btn-primary">Withdrawal</button>
                    </div>
                    <!--End Form Group-->
                    </form>
                    <!--End Withdrawal Form-->
                </div>
                <!--End Card Body-->
            </div>
            <!--End Card: Withdrawal-->

        </div>
        <!--End OffCanvas Body-->
    </div>
    <!--End of OffCanvas-->
