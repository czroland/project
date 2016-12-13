package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.ClassService;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBClass;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBProfile;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBStudent;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBUser;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "classProfileBean")
@RequestScoped
public class MBClassProfile implements Serializable{

    @ManagedProperty(value = "#{classBean}")
    private MBClass aclass;

    @ManagedProperty(value = "#{studentBean}")
    private MBStudent student;

    private List<StudentVo> students= new ArrayList<StudentVo>();

    @ManagedProperty(value = "#{publicProfileBean}")
    private MBProfile publiProfile;

    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    @EJB
    private ClassService classService;

    @EJB
    private StudentService studentService;

    public void onLoad() {
        ClassVo possibleClass;
        List<StudentVo> allstudents = getStudentService().getAllStudents();
        //students = new ArrayList<StudentVo>();

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
}
