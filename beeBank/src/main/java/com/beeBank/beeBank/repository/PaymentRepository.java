package com.beeBank.beeBank.repository;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beeBank.beeBank.models.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
//payments instead of paymenthist, beneficiary_acc_no after beneficiary
    @Modifying
    @Query(value = " INSERT INTO paymenthist(account_id, beneficiary, amount, status, reason_code, created_at) " +
            "VALUES(:account_id, :beneficiary, :amount,  :status, :reason_code, :created_at )", nativeQuery = true)
    @Transactional
    void makePayment(@Param("account_id") int account_id,
                     @Param("beneficiary") String beneficiary,
                //      @Param("beneficiary_acc_no") String beneficiary_acc_no,
                     @Param("amount") double amount,
                //      @Param("reference_no") String reference_no,
                     @Param("status") String status,
                     @Param("reason_code") String reason_code,
                     @Param("created_at") LocalDateTime created_at);


}
