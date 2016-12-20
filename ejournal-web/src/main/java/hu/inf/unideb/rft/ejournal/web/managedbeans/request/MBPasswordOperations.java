package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.EmailService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.ResourceBundle;

@ManagedBean(name="passwordOperations")
@RequestScoped
public class MBPasswordOperations {

    @EJB
    private UserService userService;

    @EJB
    private EmailService emailService;

    @ManagedProperty("#{msg}")
    private ResourceBundle bundle;

    private String emailadress;

    private String username;

    private String password;

    private String newpassword;

    public String newGeneratedPassword() throws ServletException, IOException {

        UserVo user = userService.getUserByName(username);
        if (user == null) {
            FacesMessage msg = new FacesMessage();
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            msg.setSummary(bundle.getString("login.user.null"));
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }


        user.setPassword(new BigInteger(30, new SecureRandom()).toString(32));
        emailService.passwordReset(user.getEmail(),user.getPassword(),user.getFirstName(),user.getLastName());
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<RoleVo> roles= user.getRoles();
        user.setRoles(null);
        userService.saveUser(user);
        for (RoleVo role:roles){
            userService.addRoleToUser(user.getName(),role);
        }
        return null;
    }

    public String modifyPassword() throws ServletException, IOException {
        User uservo = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo user = getUserService().getUserByName(uservo.getUsername());
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(newpassword));
        emailService.passwordChange(user.getEmail(),newpassword,user.getFirstName(),user.getLastName());


        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        externalContext.redirect("/../ejournal/login.xhtml");

        RequestDispatcher dispatcher = ((ServletRequest) externalContext.getRequest())
                .getRequestDispatcher("/logout");

        dispatcher.forward((ServletRequest) externalContext.getRequest(),
                (ServletResponse) externalContext.getResponse());

        FacesContext.getCurrentInstance().responseComplete();
        //ec.redirect(ec.getRequestContextPath() + "/home.xhtml");
        return null;
    }

    public String sendUsername(){
        UserVo user = userService.getUserByEmail(emailadress);
        if (user == null) {
            FacesMessage msg = new FacesMessage();
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            msg.setSummary(bundle.getString("login.email.null"));
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
        emailService.sendForgotUsername(user.getEmail(),user.getName(),user.getFirstName(),user.getLastName());
        return null;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }
}
