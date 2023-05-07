package com.beeBank.beeBank.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beeBank.beeBank.models.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{
    @Query(value = "SELECT * FROM accounts WHERE user_id = :user_id", nativeQuery = true)
List<Account> getUserAccountsById(@Param("user_id")int user_id);

@Query(value = "SELECT balance FROM accounts WHERE user_id = :user_id", nativeQuery = true)
BigDecimal getTotalBalance(@Param("user_id") int user_id);





    
}
