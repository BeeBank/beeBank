package com.beeBank.beeBank.helpers;

public class HTML{

    public static String htmlEmailTemplate(String token, int code){

        // Verify Account URL:
            // Need URL where site is launch
        String url = "http://localhost:8080/?token=" + token + "&code" + code;


        //Edit later 17
        String emailTemplate = "<!DOCTYPE html>\n" +
        "<html lang='en'>\n" +
        "<head>\n" +
        "    <meta charset='UTF-8'>\n" +
        "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
        "    <link rel='stylesheet' href='css/email.css'>\n" +
        "    <title>Document</title>\n" +
        "    <style>\n" +
        "        *{\n" +
        "    box-sizing: border-box;\n" +
        "    font-family: Helvetica, Arial, sans-serif;\n" +
        "        }\n" +
        "\n" +
        "/* Main Body Styling */\n" +
        "body{\n" +
        "    height: 100vh;\n" +
        "    background-image: url('../images/main_bg.png');\n" +
        "    display: flex;\n" +
        "    align-items: center;\n" +
        "    justify-content: center;\n" +
        "    }\n" +
        "\n" +
        "/* <!-- Wrapper --> */\n" +
        ".wrapper{\n" +
        "    width: 550px;\n" +
        "    height: auto;\n" +
        "    padding: 15px;\n" +
        "    background-color: white;\n" +
        "    border-radius: 7px;\n" +
        "}\n" +
        "/* <!-- Email MSG Header -->*/\n" +
        ".email-msg-header{\n" +
        "    text-align: center;\n" +
        "\n" +  
        "}\n" +
        "\n" +
        "/* <!-- Company Name--> */\n" +
        ".email-msg-header span{\n" +
        "    width: 100px ;\n" +
        "    text-align: center;\n" +
        "    font-size: 50px;\n" +
        "    color: #fcca00;\n" +
        "\n" +
        "}\n" +
        "/*<!--Welcome Text-->*/\n" +
        ".welcome-text{\n" +
        "    text-align: center;\n" +
        "}\n" +
        "\n" +
        "/*<!--Verify Account Button-->*/\n" +
        ".verify-account-btn{\n" +
        "    padding: 15px;\n" +
        "    background-color: #fcca00;\n" +
        "    text-decoration: none;\n" +
        "    color: white;\n" +
        "    border-radius: 5px;\n" +
        "}\n" +
        "\n" +
        "/*<!--Copy Right Wrapper-->*/\n" +
        ".copy-right{\n" +
        "    padding: 15px;\n" +
        "    font-size: 14px;\n" +
        "    color: gray;\n" +
        "    margin: 20px 0px;\n" +
        "    display: flex;\n" +
        "    align-items: center;\n" +
        "    justify-content: center;\n" +
        "}\n" +
        "    </style>\n" +
        "</head>\n" +
        "<body>\n" +
        "\n" +
        "<!-- Wrapper -->\n" +
        "<div class='wrapper'>\n" +
        "    <!-- Email MSG Header-->\n" +
        "    <h2 class='email-msg-header'>\n" +
        "        Welcome and Thank You for Choosing\n" +
        "        <span> BeeBank</span>\n" +
        "    </h2>\n" +
        "    <!-- End of Emial MSG Header-->\n" +
        "\n" +
        "    <hr>\n" +
        "    <!--Welcome Text-->\n" +
        "    <p class='welcome-text'>\n" +
        "        Your Account Has Been Successfully Registered, Please Click Below To Verify Your Account\n" +
        "    </p>\n" +
        "    <!-- End of Welcome Text-->\n" +
        "    <br>\n" +
        "    <br>\n" +
        "\n" +
        "    <!--Verify Account Button-->\n" +
        "    <center><a href='"+ url+"'' class='verify-account-btn' role='button'>Verify Account</a></center>\n" +
        "    <!--End of Verify Account Button -->\n" +
        "\n" +    
        "    <!--Copy Right Wrapper-->\n" +
        "    <div class='copy-right'>\n" +
        "    &copy; Copy Right 2023. All Rights Reserved.\n" +
        "    </div>\n" +
        "    <!--End of Copy Right Wrapper-->\n" +
        "<!-- End Of Wrapper-->\n" +
            
        "</body>\n" +
       "</html>";
        return emailTemplate;
    }

}