package hu.inf.unideb.rft.ejournal.service;

import javax.mail.Session;

public interface EmailService {

    void sendMessage(String to,String firstname,String lastname);

    void passwordReset(String to,String password,String firstname,String lastname);

    void passwordChange(String to,String password,String firstname,String lastname);

    void sendForgotUsername(String to,String username,String firstname,String lastname);

    Session emailProps();

}
