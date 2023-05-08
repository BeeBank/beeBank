package com.beeBank.beeBank.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beeBank.beeBank.repository.AccountRepository;
import com.beeBank.beeBank.repository.PaymentRepository;
import com.beeBank.beeBank.repository.TransactRepository;

@Controller
@RequestMapping("/transact")


public class TransactController {

    @Autowired
private AccountRepository accountRepository;

@Autowired
private PaymentRepository paymentRepository;

@Autowired
private TransactRepository transactRepository;


    User user;

    double currentBalance;
    double newBalance;
    LocalDateTime  currentDateTime = LocalDateTime.now();


    @PostMapping("/deposit")
    public String deposit(@RequestParam("deposit_amount")String depositAmount, @RequestParam("account_id") String accountID, HttpSession session, RedirectAttributes redirectAttributes) {
            if(depositAmount.isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "Deposit amount or account depositing to cannot be empty");
                return "redirect:/app/dashboard";
            }

            user  = (User)session.getAttribute("user");

            int acc_id = Integer.parseInt(accountID);
            double depositAmountValue = Double.parseDouble(depositAmount);



            if(depositAmountValue <= 0) {
                redirectAttributes.addFlashAttribute("error", "Deposit Amount Cannot Be 0 or less than 0");
                return "redirect:/app/dashboard";
            }

            currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);
            newBalance = currentBalance + depositAmountValue;
            accountRepository.changeAccountBalanceById(newBalance, acc_id);

            transactRepository.logTransaction(acc_id, "deposit", depositAmountValue, "online", "success", "Deposit transaction successful", currentDateTime);

            redirectAttributes.addFlashAttribute("success", "Amount deposited successfully");
            return "redirect:/app/dashboard";


    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam("transfer_from") String transfer_from, 
    @RequestParam("transfer_to") String transfer_to, 
    @RequestParam("transfer_amount") String transfer_amount,
    HttpSession session,
    RedirectAttributes redirectAttributes) {

        if (transfer_from.isEmpty() || transfer_amount.isEmpty() || transfer_to.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "The account transferring from/to and the amount cannot be empty");
            return "redirect:/app/dashboard";
        }

        int transferFromId = Integer.parseInt(transfer_from);
        int transferToId = Integer.parseInt(transfer_to);
        double transferAmount = Double.parseDouble(transfer_amount);

        if(transferFromId == transferToId) {
            redirectAttributes.addFlashAttribute("error", "Cannot transfer into the same account");
            return "redirect:/app/dashboard";

        }

        if(transferAmount <= 0) {
            redirectAttributes.addFlashAttribute("error", "Amount needs to be greater than 0");
            return "redirect:/app/dashboard";
        }


        //gets current logged in user
       user = (User)session.getAttribute("user");
       double currentBalanceOfAccountTransferringFrom = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);


       if (currentBalanceOfAccountTransferringFrom < transferAmount) {
        transactRepository.logTransaction(transferFromId, "transfer", transferAmount, "online", "failed", "insufficient funds", currentDateTime);
        redirectAttributes.addFlashAttribute("error", "You have insufficient funds to transfer.");
        return "redirect:/app/dashboard";
    }

       double currentBalanceOfAccountTransferringTo = accountRepository.getAccountBalance(user.getUser_id(), transferToId);

       //set new balance:
       double newBalanceOfAccountTransferringFrom = currentBalanceOfAccountTransferringFrom - transferAmount;

       double newBalanceOfAccountTransferringTo = currentBalanceOfAccountTransferringTo + transferAmount;
       //change balance of acct transferring from
       accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferringFrom, transferFromId);
       //change balance of acct transferring to
       accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferringTo, transferToId);


       transactRepository.logTransaction(transferFromId, "transfer", transferAmount, "online", "success", "Transfer transaction successful", currentDateTime);


       


       redirectAttributes.addFlashAttribute("success", "Successfully transferred.");
       return "redirect:/app/dashboard";

    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("withdrawal_amount")String withdrawalAmount,
    @RequestParam("account_id") String accountID, 
    HttpSession session,
    RedirectAttributes redirectAttributes) {

        if(withdrawalAmount.isEmpty() || accountID.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Withdrawal amount and account cannot be empty");
            return "redirect:/app/dashboard";
        }

        double withdrawal_amount = Double.parseDouble(withdrawalAmount);
        int account_id = Integer.parseInt(accountID);

        if (withdrawal_amount == 0) {
            redirectAttributes.addFlashAttribute("error", "Withdrawal amount cannot be 0");
            return "redirect:/app/dashboard";
        }



        user = (User) session.getAttribute("user");

        currentBalance = accountRepository.getAccountBalance(user.getUser_id(), account_id);


        if (currentBalance < withdrawal_amount) {
            transactRepository.logTransaction(account_id, "Withdrawal", withdrawal_amount, "online", "failed", "insufficient funds", currentDateTime);
            redirectAttributes.addFlashAttribute("error", "You have insufficient funds to withdraw.");
            return "redirect:/app/dashboard";
        }


        newBalance = currentBalance - withdrawal_amount;

        if (withdrawal_amount > currentBalance) {
            redirectAttributes.addFlashAttribute("error", "Withdrawal amount cannot be greater than current balance.");
            return "redirect:/app/dashboard";
        }

        //update acct balance
        accountRepository.changeAccountBalanceById(newBalance, account_id);

        transactRepository.logTransaction(account_id, "Withdrawal", withdrawal_amount, "online", "success", "Withdrawal transaction successful", currentDateTime);


        redirectAttributes.addFlashAttribute("success", "Withdraw successful.");
        return "redirect:/app/dashboard";
    }

    @PostMapping("/payment")
    public String payment(@RequestParam("beneficiary")String beneficiary,
    @RequestParam("account_number")String account_number,
    @RequestParam("account_id")String account_id,
        @RequestParam("reference")String reference,
        @RequestParam("payment_amount")String payment_amount,
        HttpSession session,
        RedirectAttributes redirectAttributes) {

            if(beneficiary.isEmpty() || account_number.isEmpty() || account_id.isEmpty() || payment_amount.isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "Beneficiary, account number, account paying from and payment amount cannot be empty");
                return "redirect:/app/dashboard";
            }

            int accountID = Integer.parseInt(account_id);
            double paymentAmount = Double.parseDouble(payment_amount);

            if (paymentAmount == 0) {
                redirectAttributes.addFlashAttribute("error", "Payment cannot be 0.");
                return "redirect:/app/dashboard";
            }

            user = (User) session.getAttribute("user");

            currentBalance = accountRepository.getAccountBalance(user.getUser_id(), accountID);

            if (currentBalance < paymentAmount) {

                String reasonCode = "Could not process payment due to insufficient funds.";
                
                paymentRepository.makePayment(accountID, beneficiary, account_number, paymentAmount, reference, "failed", reasonCode, currentDateTime);

                transactRepository.logTransaction(accountID, "Payment", paymentAmount, "online", "failed", "insufficient funds", currentDateTime);

                redirectAttributes.addFlashAttribute("error", "You have insufficient funds to complete payment.");
                return "redirect:/app/dashboard";
            }

            newBalance = currentBalance - paymentAmount;

            String reasonCode = "Payment processed.";
            paymentRepository.makePayment(accountID, beneficiary, account_number, paymentAmount, reference, "success", reasonCode, currentDateTime);
        

            //update account paying from
            accountRepository.changeAccountBalanceById(newBalance, accountID);

            transactRepository.logTransaction(accountID, "Payment", paymentAmount, "online", "success", "Payment successful", currentDateTime);


            redirectAttributes.addFlashAttribute("success", "Payment processed.");
            return "redirect:/app/dashboard";
            

         
    }
    
}
