package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ManagedBean(name = "teacherPanelBean")
@RequestScoped
public class MBTeacherPanel implements Serializable{

    @EJB
    private TeacherService teacherService;

    @EJB
    private UserService userService;

    private TeacherVo teacher;

    private List<SubjectVo> subjects;

    private List<ClassVo> classes;

    @PostConstruct
    public void init() {
        User uservo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo user = getUserService().getUserByName(uservo.getUsername());
        //List<TeacherVo> teachers= getTeacherService().getAllTeachers();
        /*for (TeacherVo i : teachers) {
            if (Objects.equals(user.getEmail(), i.getUser().getEmail())){
                teacher=i;
            }
        }*/
        teacher = getTeacherService().getTeacherbyUserId(user.getId());
        if (teacher != null) {
            subjects=teacher.getSubject();
            classes=teacher.getAclasses();
        }


    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public List<SubjectVo> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectVo> subjects) {
        this.subjects = subjects;
    }

    public TeacherVo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherVo teacher) {
        this.teacher = teacher;
    }

    public List<ClassVo> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassVo> classes) {
        this.classes = classes;
    }
}
