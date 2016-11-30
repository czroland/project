package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBUser;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "roleMmt")
@RequestScoped
public class MBRoleManagement {
    @EJB
    private UserService userService;
    @EJB
    private RoleService roleService;

    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    public void addRole(List<UserVo> users, String role) {
        RoleVo roleVo = roleService.getRoleByName(role);

        for (UserVo userVo : users) {
            userService.addRoleToUser(userVo.getName(), roleVo);
        }
        user.init();
    }

    public void removeRole(List<UserVo> users, String role) {
        RoleVo roleVo = roleService.getRoleByName(role);

        for (UserVo userVo : users) {
            userService.removeRoleFromUser(userVo.getName(), roleVo);
        }
        user.init();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }
}