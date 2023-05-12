<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
   
   <!--Card: Withdrawal-->
    <div class="card withdrawal-card">
        <!--Card Body-->
        <div class="card-body">
            <!--Withdrawal Form -->
            <form action="/transact/withdraw"method="POST" class="withdrawal-form">
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
            <div class="form-group my-2">
                <button id="" class="btn btn-md transact-btn">Withdrawal</button>
            </div>
            <!--End Form Group-->
            </form>
            <!--End Withdrawal Form-->
        </div>
        <!--End Card Body-->
    </div>
    <!--End Card: Withdrawal-->