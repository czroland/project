package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "addRoleBean")
@RequestScoped
public class MBAddRole {
    @EJB
    private UserService userService;
    @EJB
    private RoleService roleService;

    public void addRole(List<UserVo> users, String role) {
        RoleVo roleVo = roleService.getRoleByName(role);

        for (UserVo userVo : users) {
            userService.addRoleToUser(userVo.getName(), roleVo);
        }
    }
}
