package hu.inf.unideb.rft.ejournal.web.managedbeans.view;


import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userBean")
@ViewScoped
public class MBUser implements Serializable {

    private static final long serialVersionUID = 1556938853275925882L;

    private DualListModel<UserVo> users;

    @EJB
    private UserService userService;

    private UserVo user = new UserVo();

    @PostConstruct
    public void init() {
        List<UserVo> usersSource = new ArrayList<>();
        List<UserVo> usersTarget = new ArrayList<>();

        usersSource = userService.getAllUsers();
        users = new DualListModel<UserVo>(usersSource, usersTarget);
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public DualListModel<UserVo> getUsers() {
        return users;
    }

    public void setUsers(DualListModel<UserVo> users) {
        this.users = users;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
