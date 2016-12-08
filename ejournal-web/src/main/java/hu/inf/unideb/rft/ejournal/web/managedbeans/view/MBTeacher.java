package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "teacherBean")
@ViewScoped
public class MBTeacher implements Serializable {

    private static final long serialVersionUID = -2185688253204492252L;

    private DualListModel<TeacherVo> teachers;

    @EJB
    private TeacherService teacherService;

    private TeacherVo teacher = new TeacherVo();

    @PostConstruct
    public void init() {

        teacher.setUser(new UserVo());

        List<TeacherVo> teacherSource = new ArrayList<>();
        List<TeacherVo> teacherTarget = new ArrayList<>();

        teacherSource = teacherService.getAllTeachers();
        teachers = new DualListModel<TeacherVo>(teacherSource, teacherTarget);

    }

    public DualListModel<TeacherVo> getTeachers() {
        return teachers;
    }

    public void setTeachers(DualListModel<TeacherVo> teachers) {
        this.teachers = teachers;
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public TeacherVo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherVo teacher) {
        this.teacher = teacher;
    }
}
