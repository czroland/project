package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import com.sun.org.apache.xpath.internal.SourceTree;
import hu.inf.unideb.rft.ejournal.service.ClassService;
import hu.inf.unideb.rft.ejournal.service.MarkService;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.MarkVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "classProfileBean")
@RequestScoped
public class MBClassProfile{

    @ManagedProperty(value = "#{classBean}")
    private MBClass aclass;

    @ManagedProperty(value = "#{studentBean}")
    private MBStudent student;

    @ManagedProperty(value = "#{markBean}")
    private MBMark mark;

    @ManagedProperty(value = "#{teacherBean}")
    private MBTeacher teacher;

    private List<StudentVo> students= new ArrayList<StudentVo>();

    @ManagedProperty(value = "#{publicProfileBean}")
    private MBProfile publiProfile;

    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    private int[] grades = {1,2,3,4,5};

    private int grade;

    @EJB
    private ClassService classService;

    @EJB
    private MarkService markService;

    @EJB
    private StudentService studentService;

    public void onLoad() {
        ClassVo possibleClass;
        List<StudentVo> allstudents = getStudentService().getAllStudents();

        if (publiProfile.getProfileId() != null) {
            possibleClass = classService.getClassById(publiProfile.getProfileId());
        } else {
            possibleClass = classService.getClassById(user.getUser().getId());
        }
        aclass.setClassVo(possibleClass);
        for (StudentVo i:allstudents){
            if (i.getAclass()!=null) {
                if ((i.getAclass().equals(aclass.getClassVo()))) {
                    students.add(i);
                }
            }
        }
        student.getStudents().setTarget(students);
    }

    public MBClass getAclass() {
        return aclass;
    }

    public void setAclass(MBClass aclass) {
        this.aclass = aclass;
    }

    public MBStudent getStudent() {
        return student;
    }

    public void setStudent(MBStudent student) {
        this.student = student;
    }

    public MBProfile getPubliProfile() {
        return publiProfile;
    }

    public void setPubliProfile(MBProfile publiProfile) {
        this.publiProfile = publiProfile;
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }

    public ClassService getClassService() {
        return classService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    public List<StudentVo> getStudents() {
        return students;
    }

    public void setStudents(List<StudentVo> students) {
        this.students = students;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public int[] getGrades() {
        return grades;
    }

    public MBMark getMark() {
        return mark;
    }

    public void setMark(MBMark mark) {
        this.mark = mark;
    }

    public MBTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(MBTeacher teacher) {
        this.teacher = teacher;
    }

    public MarkService getMarkService() {
        return markService;
    }

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

}
