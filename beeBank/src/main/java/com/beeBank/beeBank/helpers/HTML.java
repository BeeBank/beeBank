package com.beeBank.beeBank.helpers;

public class HTML{

    public static String htmlEmailTemplate(String token, String code){

        // Verify Account URL:
            // Need URL where site is launch
        String url = "?token=" + token + "&code" + code;


        //Edit later 17
        String emailTemplate = "<!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="css/email.css">
            <title>Document</title>
            <style>
            
            </style>
        </head>
        <body>
        
        <!-- Wrapper -->
        <div class="wrapper">
            <!-- Email MSG Header-->
            <h2 class="email-msg-header">
                Welcome and Thank You for Choosing
                <span> BeeBank</span>
            </h2>
            <!-- End of Emial MSG Header-->
        
            <hr>
            <!--Welcome Text-->
            <p class="welcome-text">
                Your Account Has Been Successfully Registered, Please Click Below To Verify Your Account
            </p>
            <!-- End of Welcome Text-->
            <br>
            <br>
        
            <!--Verify Account Button-->
            <center><a href='"+ url+"'' class="verify-account-btn" role="button">Verify Account</a></center>
            <!--End of Verify Account Button -->
            
            <!--Copy Right Wrapper-->
            <div class="copy-right">
            &copy; Copy Right 2023. All Rights Reserved.
            </div>
            <!--End of Copy Right Wrapper-->
        <!-- End Of Wrapper-->
            
        </body>
        </html>";
        return "";
    }

}