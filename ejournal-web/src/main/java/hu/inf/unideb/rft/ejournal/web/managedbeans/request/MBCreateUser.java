package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "createUserBean")
@RequestScoped
public class MBCreateUser {

    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    @EJB
    UserService userService;

    public String doCreate() {

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.getUser().setPassword(bCryptPasswordEncoder.encode(user.getUser().getPassword()));
        userService.saveUser(user.getUser());
        return "200";
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
