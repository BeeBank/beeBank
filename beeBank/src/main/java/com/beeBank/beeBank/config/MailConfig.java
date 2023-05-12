package com.beeBank.beeBank.config;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailConfig {
    
    public static JavaMailSenderImpl getMailConfig(){
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        //Set Properties:
        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttils.enable", "true");
        props.put("mail.debug", "true");

        // @TODO: Emails 
        // Set Mail Credntials:
        emailConfig.setHost("");
        emailConfig.setPort(25);
        emailConfig.setUsername("");
        emailConfig.setPassword("");
        
        return emailConfig;
    }
}
