package com.beeBank.beeBank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.web.PageableDefault;

public interface TransactHistoryRepository extends CrudRepository <TransactionHistory, Integer> {

    @Query(value= "SELECT * FROM v_transaction_history WHERE user_id = :user_id", nativeQuery= true)
    List <TransactionHistory> getTransactionRecordById(@Param("user_id")int user_id);
    
}
