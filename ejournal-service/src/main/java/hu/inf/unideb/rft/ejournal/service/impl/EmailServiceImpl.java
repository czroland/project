package hu.inf.unideb.rft.ejournal.service.impl;


import hu.inf.unideb.rft.ejournal.service.EmailService;

import javax.ejb.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Stateless(name = "EmailService", mappedName = "EmailService")
@Local(EmailService.class)
public class EmailServiceImpl extends AbstractMappingService implements EmailService{

    final static String username = "de.ik.ejournal@gmail.com";
    final static String password = "ejournal";

    @Override
    public Session emailProps() {

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EmailServiceImpl.username, EmailServiceImpl.password);
                    }
                });
        return session;
    }

    @Override
    public void sendMessage(String to, String firstname, String lastname) {

        try {

            Message message = new MimeMessage(emailProps());
            message.setFrom(new InternetAddress(EmailServiceImpl.username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Enapló sikeres Regisztráció!");
            message.setContent("<b><font size=\"5\">Gratulálunk a sikeres regisztrációdhoz "+firstname +" "+ lastname +
                    " ! </font> <br><br>Ha bármilyen kérdésed merülne fel a szoftver használatával kapcsolatban kérjük írj üzenetet az alábbi címre:<br>" +
                    "<br> E-mail: <font color=\"blue\">de.ik.ejournal@gmail.com</font> </b>", "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void passwordReset(String to, String password, String firstname, String lastname) {
        try {

            Message message = new MimeMessage(emailProps());
            message.setFrom(new InternetAddress(EmailServiceImpl.username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Enapló jelszó resetelése (rendszer által generálva)");
            message.setContent("<b><font size=\"5\">Tisztelt "+firstname +" "+ lastname +
                    " ! </font> <br><br>Megújult jelszavad: <font color=\"red\">"+password+"</font><br>" +
                    "<br><font size=\"5\">Kérjük, hogy biztonsági okok miatt változtassa meg a jelszavát!</font> </b>", "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void passwordChange(String to, String password, String firstname, String lastname) {
        try {

            Message message = new MimeMessage(emailProps());
            message.setFrom(new InternetAddress(EmailServiceImpl.username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Enapló jelszó megváltoztatása (felhasználó által)");
            message.setContent("<b><font size=\"5\">Tisztelt "+firstname +" "+ lastname +
                    " ! </font> <br><br>Az általad módosított új jelszó: <font color=\"green\">"+password+"</font>", "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendForgotUsername(String to, String username, String firstname, String lastname) {
        try {

            Message message = new MimeMessage(emailProps());
            message.setFrom(new InternetAddress(EmailServiceImpl.username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Enapló felhasználónév emlékeztető.");
            message.setContent("<b><font size=\"5\">Tisztelt "+firstname +" "+ lastname +
                    " ! </font> <br><br>Az e-mail címedhez tartozó felhasználónév: <font color=\"green\">"+username+"</font>", "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
