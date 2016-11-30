package hu.inf.unideb.rft.ejournal.web.email_operations;


import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {

    public static void sendMessage(String to) {

        final String username = "de.ik.ejournal@gmail.com";
        final String password = "ejournal";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("de.ik.ejournal@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Sikeres Regisztráció");
            message.setText("Graulálunk,"
                    + "\n\n Sikeresen beregisztált a rendszerünkbe!");

            Transport.send(message);

            System.out.println("Succesfully sent email!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}