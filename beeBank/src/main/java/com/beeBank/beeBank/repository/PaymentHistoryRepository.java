package com.beeBank.beeBank.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Integer{
    
    @Query(value= "SELECT * FROM v_payments WHERE user_id = user_id", nativeQuery = true)
    List <PaymentHistory> getPaymentRecordsById(@Param("uder_id")int user_id);
}
