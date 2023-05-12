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

            <c:import url="components/transact_forms/payment_form.jsp"/>
            <c:import url="components/transact_forms/transfer_form.jsp"/>
            <c:import url="components/transact_forms/deposit_form.jsp"/>
            <c:import url="components/transact_forms/withdraw_form.jsp"/>


        

        </div>
        <!--End OffCanvas Body-->
    </div>
    <!--End of OffCanvas-->
