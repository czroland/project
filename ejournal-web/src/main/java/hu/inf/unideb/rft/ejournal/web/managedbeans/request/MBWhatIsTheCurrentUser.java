package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.ParentService;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.*;
import hu.inf.unideb.rft.ejournal.web.enums.Roles;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBStudent;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBTeacher;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@ManagedBean(name = "currentUserBean")
@RequestScoped
public class MBWhatIsTheCurrentUser {

    @EJB
    private TeacherService teacherService;

    @EJB
    private UserService userService;

    @EJB
    private StudentService studentService;

    @EJB
    private ParentService parentService;

    @ManagedProperty(value = "#{teacherBean}")
    private MBTeacher teacher;

    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    @ManagedProperty(value = "#{studentBean}")
    private MBStudent student;

    @PostConstruct
    public void init() {
        user.setUser(
                userService.getUserByName(FacesContext.
                        getCurrentInstance()
                        .getExternalContext()
                        .getUserPrincipal()
                        .getName())
        );


        setStudent();
        setTeacher();

        if (user.getUser().getRoles().contains(Roles.ROLE_PARENT))
            student.getStudent().setParent(parentService.getParentByUserId(user.getUser().getId()));

    }

    private void setTeacher() {
        for (RoleVo roleVo : user.getUser().getRoles()) {
            if (Roles.ROLE_TEACHER.toString().equals(roleVo.getName())) {
                teacher.setTeacher(getTeacherService().getTeacherbyUserId(user.getUser().getId()));
            }
        }
    }

    private void setStudent() {
        for (RoleVo roleVo : user.getUser().getRoles()) {
            if (Roles.ROLE_STUDENT.toString().equals(roleVo.getName())) {
                student.setStudent(studentService.getStudentByUserId(user.getUser().getId()));
            }
        }
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public MBTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(MBTeacher teacher) {
        this.teacher = teacher;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public ParentService getParentService() {
        return parentService;
    }

    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }

    public MBStudent getStudent() {
        return student;
    }

    public void setStudent(MBStudent student) {
        this.student = student;
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }
}
