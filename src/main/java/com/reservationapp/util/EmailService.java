package com.reservationapp.util;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendEmailWithAttachment(String to, String subject,String text, byte[] attachment,String attachmentName){
        try{
            MimeMessage message=emailSender.createMimeMessage();// This line creates a new MimeMessage object using the createMimeMessage() method of the emailSender object. This object represents the email message.
            MimeMessageHelper helper = new MimeMessageHelper(message, true);//This line creates a new MimeMessageHelper object, which is used to assist in creating a MIME message. The true parameter indicates that the message is multipart, which means it can contain attachments.
            //The helper variable will be used to configure the message object, such as setting recipients, subject, text content, and attachments, before sending the email.
            helper.setTo(to);//Sets the recipient of the email message. The to variable likely contains the email address of the recipient.


            helper.setSubject(subject);
            helper.setText(text);
        //Attach the PDF file
            DataSource dataSource= new ByteArrayDataSource(attachment,"application/pdf");//attachment is of type application/pdf
            helper.addAttachment(attachmentName, dataSource);

            emailSender.send(message);//Sends the email message using the send() method of the emailSender object. This line actually sends the email with all the specified parameters.


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
