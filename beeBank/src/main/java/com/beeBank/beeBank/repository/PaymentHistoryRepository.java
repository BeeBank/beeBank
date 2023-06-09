package com.beeBank.beeBank.repository;


import org.springframework.stereotype.Repository;

import com.beeBank.beeBank.models.PaymentHistory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
@Repository
public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Integer> {

    @Query(value = "SELECT * FROM v_paymenthist WHERE user_id = :user_id", nativeQuery = true)
    List<PaymentHistory> getPaymentRecordsById(@Param("user_id")int user_id);
}
