package hu.inf.unideb.rft.ejournal.web.managedbeans.request;


import hu.inf.unideb.rft.ejournal.service.EmailService;
import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import hu.inf.unideb.rft.ejournal.web.enums.Roles;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBClass;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBTeacher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "registerTeacher")
@RequestScoped
public class MBRegisterTeacher {

    @ManagedProperty(value = "#{teacherBean}")
    private MBTeacher teacher;

    @ManagedProperty(value = "#{classBean}")
    private MBClass mbClass;

    @EJB
    TeacherService teacherService;

    @EJB
    RoleService roleService;

    @EJB
    UserService userService;

    @EJB
    EmailService email;

    public String doCreate() {

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        teacher.getTeacher()
                .getUser()
                .setPassword(bCryptPasswordEncoder.encode(teacher.getTeacher()
                        .getUser()
                        .getPassword()));

        RoleVo roleVo = roleService.getRoleByName(Roles.ROLE_TEACHER.toString());

        teacherService.saveTeacher(teacher.getTeacher());
        userService.addRoleToUser(teacher.getTeacher()
                .getUser().getName(), roleVo);
        email.sendMessage(teacher.getTeacher().getUser().getEmail(), teacher.getTeacher().getUser().getFirstName(), teacher.getTeacher().getUser().getLastName());
        return "200";
    }

    public void addClass(List<TeacherVo> teachers, ClassVo classVo) {

        for (TeacherVo teacherVo : teachers) {
            teacherService.addClassToTeacher(teacherVo.getId(), classVo);
        }
        teacher.init();
    }

    public void removeClass(List<TeacherVo> teachers, ClassVo classVo) {

        for (TeacherVo teacherVo : teachers) {
            teacherService.removeClassFromTeacher(teacherVo.getId(), classVo);
        }
        teacher.init();
    }

    public MBTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(MBTeacher teacher) {
        this.teacher = teacher;
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
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

    public MBClass getMbClass() {
        return mbClass;
    }

    public void setMbClass(MBClass mbClass) {
        this.mbClass = mbClass;
    }
}
