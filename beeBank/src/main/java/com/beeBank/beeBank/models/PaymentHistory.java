package com.beeBank.beeBank.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_paymenthist")
public class PaymentHistory {

    @Id
    private int payment_id;
    private int account_id;
    private int user_id;
    private String beneficiary;
    private double amount; 
    private String status; 
    private String reason_code; 
    private LocalDateTime created_at;


    public int getPayment_id() {
        return payment_id;
    }
    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }
    public int getAccount_id() {
        return account_id;
    }
    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getBeneficiary() {
        return beneficiary;
    }
    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason_code() {
        return reason_code;
    }
    public void setReason_code(String reason_code) {
        this.reason_code = reason_code;
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }  
    
    

    
}
