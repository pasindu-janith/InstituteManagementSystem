/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.institute.common;

/**
 *
 * @author pasindu hathurushigh
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

   public static void sendMail(String mailTo, String mailFrom, String mailFromPassword, 
           String mailSubject, String mailMessage) throws MessagingException {    
      // Recipient's email ID needs to be mentioned.
      String to = mailTo;

      // Sender's email ID needs to be mentioned
      String from = mailFrom;
      String frompassword = mailFromPassword;
      
      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = new Properties();

      // Setup mail server
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587");

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication(){
              return new PasswordAuthentication(from, frompassword);
          }
      });

      
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject(mailSubject);

         // Now set the actual message
         message.setText(mailMessage);
//         message.setContent("<h1>This is actual message</h1>", "text/html");
         // Send message
         Transport.send(message);

     
   }
    
}