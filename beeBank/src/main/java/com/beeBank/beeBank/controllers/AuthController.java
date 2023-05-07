package com.beeBank.beeBank.controllers;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepository

    @GetMapping("/login")
    public ModelAndView getLogin() {
        System.out.println("In Login Page Controller");
        ModelAndView getLoginPage = new ModelAndView("login");
        // Set token string:
        String token = Token.generateToken();

        // Send token to view:
        getLoginPage.addObject("token", token)
        getLoginPage.addObject("PageTitle", "Login");
        return getLoginPage;

    }
    @PostMapping("/login")
    public String login(@RequestParam("email")String email,
     @RequestParam("password") String password, 
     @RequestParam("_token") String token, Model model, HttpSession session) {

        if(email.isEmpty() || email == null || password.isEmpty() || password == null) {
            model.addAttribute("error", "Username or Password Cannot be Empty");
            return "login";
        }

        String getEmailInDatabase = userRepository.getUserEmail(email);

        if(getEmailInDatabase != null) {
            //get password in database:
            String getPasswordInDatabase = userRepository.getUserPassword(getEmailInDatabase);
            //validate password:
            if (!BCrypt.checkpw(password, getPasswordInDatabase)) {
                model.addAttribute("error", "Incorrect Username or Password");
                return "login";
            } 
        
        
        }

        else {
            model.addAttribute("error", "Something went wrong");
            return "error";
        }

        //verified account?
        
        int verified = userRespository.isVerified(getEmailInDatabase);
        if (verified != 1) {
            model.addAttribute("error", "Account is not yet verified");
            return "login";
        } 

        User user = userRepository.getUserDetails(getEmailInDatabase);

        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated", true);

        return "redirect:/app/dashboard";        

    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("logged_out", "logged out successfully");
        return "redirect:/login";
    }


    
}
