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
    }

    @ManagedProperty(value = "#{currentUserBean}")
    private MBWhatIsTheCurrentUser current;

    public void addMark(SubjectVo subject,int grade) {
        Long i=1L;
        System.out.println("DEBUG1");
        onLoad();
        for (StudentVo studentVo : students) {
            MarkVo mark = new MarkVo();
            mark.setTeacher(current.getTeacher());
            mark.setStudent(studentVo);
            System.out.println(mark.getStudent().getUser().getFirstName());
            mark.setId(i);
            System.out.println(mark.getId());
            System.out.println(subject);
            mark.setValue(grade);
            System.out.println(mark.getValue());
            mark.setSubject(subject);
            System.out.println(mark.getSubject().getName());
            markService.saveMark(mark);
            System.out.println("DEBUG");
            System.out.println(markService.getMarkbyId(i).getStudent().getUser().getFirstName());
            System.out.println(markService.getMarkbyId(i).getTeacher().getUser().getEmail());
            System.out.println(markService.getMarkbyId(i).getSubject().getName());
            System.out.println(markService.getMarkbyId(i).getValue());
            System.out.println("DEBUG");
            i=i+1;
        }
    }

    public void setGrade(StudentVo currentStudent,SubjectVo subject,int grade){
        MarkVo mark = new MarkVo();
        //teacher.init();
        //mark.setTeacher(teacher.getTeacher());
        mark.setTeacher(current.getTeacher());
        System.out.println(mark.getTeacher().getUser().getEmail());
        mark.setStudent(currentStudent);
        System.out.println(mark.getStudent().getUser().getFirstName());
        mark.setSigned(false);
        mark.setSubject(subject);
        System.out.println(mark.getSubject().getName());
        mark.setValue(grade);
        System.out.println(mark.getValue());
        mark.setId(-1L);
        markService.saveMark(mark);
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

    public MBWhatIsTheCurrentUser getCurrent() {
        return current;
    }

    public void setCurrent(MBWhatIsTheCurrentUser current) {
        this.current = current;
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
