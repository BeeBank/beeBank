package com.beeBank.beeBank.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beeBank.beeBank.repository.AccountRepository;

@Controller
@RequestMapping("/transact")


public class TransactController {

    @Autowired
private AccountRepository accountRepository;
    User user;

    double currentBalance;
    double newBalance;


    @PostMapping("/deposit")
    public String deposit(@RequestParam("deposit_amount")String depositAmount, @RequestParam("account_id") String accountID, HttpSession session, RedirectAttributes redirectAttributes) {
            if(depositAmount.isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "Deposit amount or account depositing to cannot be empty");
                return "redirect:/app/dashboard";
            }

            user  = (User)session.getAttribute("user");

            int acc_id = Integer.parseInt(accountID);
            double depositAmountValue = Double.parseDouble(depositAmount);



            if(depositAmountValue == 0) {
                redirectAttributes.addFlashAttribute("error", "Deposit Ammount Cannot Be 0");
                return "redirect:/app/dashboard";
            }

            currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);
            newBalance = currentBalance + depositAmountValue;
            accountRepository.changeAccountBalanceById(newBalance, acc_id);
            redirectAttributes.addFlashAttribute("success", "Amount deposited successfully");
            return "redirect:/app/dashboard";


    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam("transfer_from") String transfer_from, 
    @RequestParam("transfer_to") String transfer_to, 
    @RequestParam("transfer_amount") String transfer_amount,
    HttpSession session,
    RedirectAttributes redirectAttributes) {

        if (transfer_from.isEmpty() || transfer_amount.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "The account transferring from and the amount cannot be empty");
            return "redirect:/app/dashboard";
        }

        int transferFromId = Integer.parseInt(transfer_from);
        int transferToId = Integer.parseInt(transfer_to);
        double transferAmount = Double.parseDouble(transfer_amount);

        if(transferFromId == transferToId) {
            redirectAttributes.addFlashAttribute("error", "Cannot transfer into the same account");
            return "redirect:/app/dashboard";

        }

        if(transferAmount == 0) {
            redirectAttributes.addFlashAttribute("error", "Amount needs to be > 0");
            return "redirect:/app/dashboard";
        }

        //gets current logged in user
       user = (User)session.getAttribute("user");
       currentBalance = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);

       //set new balance:
       newBalance = currentBalance - transferAmount;
       double newBalanceOfAccountTransferringTo = currentBalance + transferAmount;
       //change balance of acct transferring from
       accountRepository.changeAccountBalanceById(newBalance, transferFromId);
       //change balance of acct transferring to
       accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferringTo, transferToId);

       




        return "";

    }
    
}
