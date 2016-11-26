package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "roleBean")
@ViewScoped
public class MBRoles implements Serializable {

    private static final long serialVersionUID = 7708364597183491419L;

    @EJB
    private RoleService roleService;

    private List<RoleVo> roles = new ArrayList<>();
    private String userRole;

    @PostConstruct
    public void init() {
        roles = roleService.getAllRoles();
    }

    public List<RoleVo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVo> roles) {
        this.roles = roles;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
