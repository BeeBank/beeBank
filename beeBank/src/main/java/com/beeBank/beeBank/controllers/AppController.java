package com.beeBank.beeBank.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beeBank.beeBank.models.Account;
import com.beeBank.beeBank.repository.AccountRepository;

@Controller
@RequestMapping("/app")
public class AppController {
    @Autowired
    private AccountRepository accountRepository;

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
    
}
