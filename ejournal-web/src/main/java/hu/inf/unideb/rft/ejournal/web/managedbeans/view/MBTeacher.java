package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "teacherBean")
@ViewScoped
public class MBTeacher implements Serializable {

    private static final long serialVersionUID = -2185688253204492252L;

    private TeacherVo teacher;

    @PostConstruct
    public void init(){
        teacher = new TeacherVo();
        teacher.setUser(new UserVo());
    }

    public TeacherVo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherVo teacher) {
        this.teacher = teacher;
    }
}
