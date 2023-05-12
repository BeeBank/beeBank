<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri"http://wwww.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
   
   <!--Card: Transfer-->
   <div class="card transfer-card">
    <!--Card Body-->
    <div class="card-body">
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
         <div class="form-group mb-2">
            <label for="">Enter Transfer Amount</label>
            <input type="text" name="transfer_amount" class="form-control" placeholder="Enter transfer Amount">
        </div>
        <!--End Form Group-->

        <!--Form Group-->
        <div class="form-group my-1">
            <button id="transact-btn" class="btn btn-md btn-primary">Transfer</button>
        </div>
        <!--End Form Group-->
        

    </div>
    <!--End Card Body-->
</div>
<!--End Card: Transfer-->
