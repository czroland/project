package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.vo.ParentVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "studentBean")
@ViewScoped
public class MBStudent implements Serializable {

    private static final long serialVersionUID = -844865958619742445L;

    private StudentVo student;

    @PostConstruct
    public void init() {
        student = new StudentVo();
        ParentVo parent = new ParentVo();
        parent.setUser(new UserVo());
        student.setUser(new UserVo());
        student.setParent(parent);
    }

    public StudentVo getStudent() {
        return student;
    }

    public void setStudent(StudentVo student) {
        this.student = student;
    }

}