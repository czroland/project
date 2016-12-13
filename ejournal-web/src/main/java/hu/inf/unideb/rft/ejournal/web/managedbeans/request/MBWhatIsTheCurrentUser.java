package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.ParentService;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.ParentVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@ManagedBean(name = "currentUserBean")
@RequestScoped
public class MBWhatIsTheCurrentUser implements Serializable{

    @EJB
    private TeacherService teacherService;

    @EJB
    private UserService userService;

    @EJB
    private StudentService studentService;

    @EJB
    private ParentService parentService;

    private TeacherVo teacher;

    private UserVo user;

    private ParentVo parent;

    private StudentVo student;

    @PostConstruct
    public void init() {
        User uservo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user = getUserService().getUserByName(uservo.getUsername());
        teacher = getTeacherService().getTeacherbyUserId(user.getId());
        student = getStudentService().getStudentByUserId(user.getId());
        List<ParentVo> parents=parentService.getAllUsers();
        for (ParentVo i:parents){
            if (i.getUser().getId().equals(user.getId())){
                parent=i;
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

    public TeacherVo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherVo teacher) {
        this.teacher = teacher;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
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

    public ParentVo getParent() {
        return parent;
    }

    public void setParent(ParentVo parent) {
        this.parent = parent;
    }

    public StudentVo getStudent() {
        return student;
    }

    public void setStudent(StudentVo student) {
        this.student = student;
    }
}
