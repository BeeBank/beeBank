package com.beeBank.beeBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import com.beeBank.beeBank.models.TransactionHistory;

public interface TransactHistoryRepository extends CrudRepository <TransactionHistory, Integer> {

    @Query(value= "SELECT * FROM v_transaction_history WHERE user_id = :user_id", nativeQuery= true)
    List <TransactionHistory> getTransactionRecordById(@Param("user_id")int user_id);
    
}
