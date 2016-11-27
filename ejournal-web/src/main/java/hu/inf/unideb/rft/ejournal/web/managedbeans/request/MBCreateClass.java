package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBUser;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.xml.registry.infomodel.User;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "createClassBean")
@RequestScoped
public class MBCreateClass {

    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    @EJB
    private RoleService roleService;

    @EJB
    private UserService userService;

    private DualListModel<UserVo> students;
    // private DualListModel<Theme> themes;

    @PostConstruct
    public void init() {

        List<UserVo> studentsSource = new ArrayList<>();
        List<UserVo> studentsTarget = new ArrayList<>();

        students = new DualListModel<UserVo>(studentsSource, studentsTarget);

    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public DualListModel<UserVo> getStudents() {
        return students;
    }

    public void setStudents(DualListModel<UserVo> students) {
        this.students = students;
    }
}
