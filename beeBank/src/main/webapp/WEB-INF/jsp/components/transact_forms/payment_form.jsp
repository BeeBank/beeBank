<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
  
  <!--Card: Payment-->
  <div class="card payment-card">
    <!--Card Body-->
    <div class="card-body">
     
        <!--Payment Form-->

        <form action = "/transact/payment" method="POST">
               <!--Form Group-->
        <div class="form-group mb-2">
            <label for="">Account Holder / Beneficiary</label>
            <input type="text" name="beneficiary" class="form-control" placeholder="Enter beneficiary name">
        </div>
        <!--End Form Group-->

         <!--Form Group-->
         <div class="form-group mb-2">
            <label for="">Beneficiary Account Number</label>
            <input type="text" name="account_number" class="form-control" placeholder="Enter beneficiary account number">
        </div>
        <!--End Form Group-->


  <!--Form Group-->
  <div class="form-group">
    <label for="">Select Account</label>
    <!--Start select account-->
<select name="account_id" class="form-control" id="">
    <option value="">-- Select Account --</option>
    <c:if test="${userAccounts != null}">
        <c:forEach items ="${userAccounts}" var="selectAccount">
            <option value="${selectAccount.account_id}">${selectAccount.account_name}</option>
    </c:forEach>

    </c:if>
</select>
<!--End select account-->
</div>
<!--End form Group-->

         <!--Form Group-->
         <div class="form-group mb-2">
            <label for="">Reference</label>
            <input type="text" name="reference" class="form-control" placeholder="Enter reference">
        </div>
        <!--End Form Group-->

         <!--Form Group-->
         <div class="form-group mb-2">
            <label for="">Enter Payment Amount</label>
            <input type="text" name="payment_amount" class="form-control" placeholder="Enter Payment Amount">
        </div>
        <!--End Form Group-->

        <!--Form Group-->
        <div class="form-group">
            <button id="transact-btn" class="btn btn-md btn-primary">Pay</button>
        </div>
        <!--End Form Group-->
        


        </form>

        <!--End of Payment Form-->

    </div>
    <!--End Card Body-->
</div>
<!--End Card: Payment-->