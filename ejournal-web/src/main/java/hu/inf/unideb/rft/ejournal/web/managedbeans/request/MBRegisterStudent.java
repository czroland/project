package hu.inf.unideb.rft.ejournal.web.managedbeans.request;


import hu.inf.unideb.rft.ejournal.service.ParentService;
import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.service.EmailService;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.web.enums.Roles;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBStudent;
import org.primefaces.event.FlowEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "registerStudent")
@RequestScoped
public class MBRegisterStudent {

    @ManagedProperty(value = "#{studentBean}")
    private MBStudent student;

    @EJB
    StudentService studentService;

    @EJB
    UserService userService;

    @EJB
    RoleService roleService;

    @EJB
    ParentService parentService;

    @EJB
    EmailService email;

    public String doCreate() {

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        student.getStudent()
                .getUser()
                .setPassword(bCryptPasswordEncoder.encode(student.getStudent()
                        .getUser()
                        .getPassword()));

        student.getStudent()
                .getParent()
                .getUser()
                .setPassword(bCryptPasswordEncoder.encode(student.getStudent().getParent()
                        .getUser()
                        .getPassword()));

        studentService.saveStudent(student.getStudent());
        userService.addRoleToUser(student.getStudent()
                .getUser().getName(), role(Roles.ROLE_STUDENT.toString()));
        userService.addRoleToUser(student.getStudent().getParent()
                .getUser().getName(), role(Roles.ROLE_PARENT.toString()));

        email.sendMessage(student.getStudent().getUser().getEmail(),student.getStudent().getUser().getFirstName(),student.getStudent().getUser().getLastName());
        email.sendMessage(student.getStudent().getParent().getUser().getEmail(),student.getStudent().getParent().getUser().getFirstName(),student.getStudent().getParent().getUser().getLastName());
        return "200";
    }

    public void addClass(List<StudentVo> students, ClassVo classVo) {

        for (StudentVo studentVo : students) {
            studentService.addClassToStudent(studentVo.getId(), classVo);
        }
        student.init();
    }

    public void removeClass(List<StudentVo> students, ClassVo classVo) {


        for (StudentVo studentVo : students) {
            studentService.removeClassFromStudent(studentVo.getId(), classVo);
        }
        student.init();
    }

    RoleVo role(String role){
        return roleService.getRoleByName(role);
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public MBStudent getStudent() {
        return student;
    }

    public void setStudent(MBStudent student) {
        this.student = student;
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
}
