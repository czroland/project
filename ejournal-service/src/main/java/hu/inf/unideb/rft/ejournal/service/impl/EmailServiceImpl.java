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

    @Override
    public void sendMessage(String to, String firstname, String lastname) {
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
            message.setSubject("Enapló sikeres Regisztráció!");
            /*message.setText("Gratulálunk a sikeres regisztrációdhoz," +lastname+" "+firstname
                    + "!\n Ha bármilyen jellegű kérdésed merülne fel a szoftver használatával kérjük írj üzenetet az alábbi címre:" +
                    "\n\n\nde.ik.ejournal@gmail.com");*/
            message.setContent("<b><font size=\"5\">Gratulálunk a sikeres regisztrációdhoz "+firstname +" "+ lastname +
                    " ! </font> <br><br>Ha bármilyen kérdésed merülne fel a szoftver használatával kapcsolatban kérjük írj üzenetet az alábbi címre:<br>" +
                    "<br> E-mail: <font color=\"blue\">de.ik.ejournal@gmail.com</font> </b>", "text/html");

            Transport.send(message);

            System.out.println("Succesfully sent email!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
