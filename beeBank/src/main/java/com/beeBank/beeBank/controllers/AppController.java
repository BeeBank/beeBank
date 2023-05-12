package com.beeBank.beeBank.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beeBank.beeBank.models.Account;
import com.beeBank.beeBank.models.PaymentHistory;
import com.beeBank.beeBank.models.TransactionHistory;
import com.beeBank.beeBank.models.User;
import com.beeBank.beeBank.repository.AccountRepository;
import com.beeBank.beeBank.repository.PaymentHistoryRepository;
import com.beeBank.beeBank.repository.TransactHistoryRepository;

@Controller
@RequestMapping("/app")
public class AppController {
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    private TransactHistoryRepository transactHistoryRepository;

    User user;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session) {
        ModelAndView getDashBoardPage = new ModelAndView("dashboard");

        //this is where you get details of the logged in user

        User user = (User) session.getAttribute("user");


        //get the accounts of the user
        List<Account> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());

        //get balance
        BigDecimal totalAccountsBalance = accountRepository.getTotalBalance(user.getUser_id());

        //set objects
        getDashBoardPage.addObject("userAccounts", getUserAccounts);
        getDashBoardPage.addObject("totalBalance", totalAccountsBalance);

        return getDashBoardPage;
    }

    @GetMapping("/payment_history")
    public ModelAndView getPaymentHistory(HttpSession session){
        // Set View:
        ModelAndView getPaymentHistoryPage= new ModelAndView("PaymentHistory");

        //Get Logged in User:
        user = (User) session.getAttribute("user");

        //Get Payment History/Records:
        List<PaymentHistory> userPaymentHistory = paymentHistoryRepository.getPaymentRecordsById(user.getUser_id());

        getPaymentHistoryPage.addObject("payment_history", userPaymentHistory);

        return getPaymentHistoryPage;
    } 
    @GetMapping("/transact_history")
    public ModelAndView getTransactHistory(HttpSession session){
        // Set View:
        ModelAndView getTransactHistoryPage= new ModelAndView("transactHistory");

        //Get Logged in User:
        user = (User) session.getAttribute("user");

        //Get Transact History/Records:
        List<TransactionHistory> userTransactHistory = transactHistoryRepository.getTransactionRecordById(user.getUser_id());

        getTransactHistoryPage.addObject("transact_history", userTransactHistory);

        return getTransactHistoryPage;
    } 
    
}
