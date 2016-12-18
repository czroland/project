package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBTeacher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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

    @ManagedProperty(value = "#{teacherBean}")
    private MBTeacher teacher;

    @PostConstruct
    public void init() {
        User uservo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo user = getUserService().getUserByName(uservo.getUsername());
        teacher.setTeacher(getTeacherService().getTeacherbyUserId(user.getId()));
        //); = getTeacherService().getTeacherbyUserId(user.getId());
        if (teacher != null) {
            teacher.getTeacher().setSubject(teacher.getTeacher().getSubject());
            teacher.getTeacher().setAclasses(teacher.getTeacher().getAclasses());
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

    public MBTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(MBTeacher teacher) {
        this.teacher = teacher;
    }

}
