package com.beeBank.beeBank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {
    @PostMapping("/create_account")
    public String createAccount(@RequestParam("account_name")String accountName, 
    @RequestParam("account_type")String accountType, 
    RedirectAttributes redirectAttributes) {

        

    }
    
}
