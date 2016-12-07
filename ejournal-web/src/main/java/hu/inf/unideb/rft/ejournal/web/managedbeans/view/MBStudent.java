package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.vo.ParentVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "studentBean")
@ViewScoped
public class MBStudent implements Serializable {

    private static final long serialVersionUID = -844865958619742445L;

    private StudentVo student;

    private DualListModel<StudentVo> students;

    @EJB
    private StudentService studentService;

    @PostConstruct
    public void init() {
        student = new StudentVo();
        ParentVo parent = new ParentVo();
        parent.setUser(new UserVo());
        student.setUser(new UserVo());
        student.setParent(parent);

        List<StudentVo> studentSource = new ArrayList<>();
        List<StudentVo> studentTarget = new ArrayList<>();

        studentSource = studentService.getAllStudents();
        students = new DualListModel<StudentVo>(studentSource, studentTarget);
    }

    public StudentVo getStudent() {
        return student;
    }

    public void setStudent(StudentVo student) {
        this.student = student;
    }

    public DualListModel<StudentVo> getStudents() {
        return students;
    }

    public void setStudents(DualListModel<StudentVo> students) {
        this.students = students;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}