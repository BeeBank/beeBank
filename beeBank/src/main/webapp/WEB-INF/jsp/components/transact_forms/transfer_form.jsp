<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
   
   <!--Card: Transfer-->
   <div class="card transfer-card">
    <!--Card Body-->
    <div class="card-body">

        <!--Transfer Form-->
        <form action="/transact/transfer" method="POST">



  <!--Form Group-->
  <div class="form-group">
    <label for="">Select Account</label>
    <!--Start select account-->
<select name="transfer_from" class="form-control" id="">
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
  <div class="form-group">
    <label for="">Select Account</label>
    <!--Start select account-->
<select name="transfer_to" class="form-control" id="">
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
            <label for="">Enter Transfer Amount</label>
            <input type="text" name="transfer_amount" class="form-control" placeholder="Enter transfer Amount">
        </div>
        <!--End Form Group-->

        <!--Form Group-->
        <div class="form-group mb-2">
            <button id="transact-btn" class="btn btn-md btn-primary">Transfer</button>
        </div>
        <!--End Form Group-->
        
        </form>
        <!--End of Transfer Form-->

    </div>
    <!--End Card Body-->
</div>
<!--End Card: Transfer-->
