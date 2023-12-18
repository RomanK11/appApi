package com.api.laps.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    private final String username = "fourpaws112@gmail.com";
    private final String password = "khfu seqj epkz nsbk";

        public void sendEmail(String toEmail, String subject) {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
    
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
    
            try {
             
                Message message = new MimeMessage(session);
                
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
                message.setSubject(subject);
                message.setContent("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Подтверждение адреса электронной почты</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "    \n" +
                "        h1 {\n" +
                "            font-size: 24px;\n" +
                "        }\n" +
                "    \n" +
                "        p {\n" +
                "            font-size: 14px;\n" +
                "            line-height: 1.5;\n" +
                "        }\n" +
                "    \n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Подтверждение адреса электронной почты</h1>\n" +
                "    <p>Здравствуйте!</p>\n" +
                "    <p>Вы получили это письмо, потому что зарегистрировались на нашем сайте.</p>\n" +
                "    <p>Пожалуйста, нажмите на кнопку ниже для подтверждения адреса электронной почты:</p>\n" +
                "    <a id=\"confirm\" href=\"http://127.0.0.1:8080/api/users/accept/"+ toEmail +"\">Подтвердить адрес</a>\n" +
                "    <script>\n" +
                "        document.getElementById('confirm').addEventListener('click', function() {\n" +
                "            var xhr = new XMLHttpRequest();\n" +
                "            var url = \"http://127.0.0.1:8080/api/users/accept/"+toEmail+"\"; // Замените на свой URL\n" +
                "    \n" +
                "            // Здесь нужно приготовить данные для отправки на сервер\n" +
                "            var data = {\n" +
                "                acceptType: \"1\"\n" +
                "            };\n" +
                "    \n" +
                "            xhr.open(\"POST\", url, true);\n" +
                "            xhr.setRequestHeader(\"Content-Type\", \"application/json\");\n" +
                "    \n" +
                "            xhr.onreadystatechange = function() {\n" +
                "                if (xhr.readyState === 4 && xhr.status === 200) {\n" +
                "                    alert('Адрес электронной почты подтвержден!');\n" +
                "                }\n" +
                "            };\n" +
                "    \n" +
                "            xhr.send(JSON.stringify(data));\n" +
                "        });\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>",
                "text/html; charset=utf-8");
    
                Transport.send(message);
    
                System.out.println("Email sent successfully!");
            } catch (MessagingException e) {
                System.out.println("Failed to send email. Error: " + e.getMessage());
            }
        }
    }
