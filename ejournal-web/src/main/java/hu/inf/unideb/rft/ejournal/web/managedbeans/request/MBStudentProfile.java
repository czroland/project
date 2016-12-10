package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.MarkService;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.web.enums.Roles;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBMark;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBProfile;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBStudent;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBUser;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "profileBean")
@RequestScoped
public class MBStudentProfile {

    @ManagedProperty(value = "#{studentBean}")
    private MBStudent student;

    @ManagedProperty(value = "#{markBean}")
    private MBMark marks;

    @ManagedProperty(value = "#{publicProfileBean}")
    private MBProfile publiProfile;

    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    @EJB
    StudentService studentService;

    @EJB
    MarkService markService;


    public void onLoad() {
        StudentVo possibleStudent;
        setAdmin();

        if (publiProfile.getProfileId() != null) {
            possibleStudent = studentService.getStudentById(publiProfile.getProfileId());
        } else {
            possibleStudent = studentService.getStudentById(user.getUser().getId());
        }

        if(possibleStudent!= null){
            marks.setMarks(markService.getMarksByStudentId(possibleStudent.getId()));
        }

        student.setStudent(possibleStudent);
    }


    private void setAdmin() {
        for (RoleVo roleVo : user.getUser().getRoles()) {//NOTE:possible its not working well
            if (Roles.ROLE_ADMIN.toString().equals(roleVo.getName())) {
                publiProfile.setAdmin(true);
            }
        }
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

    public MBMark getMarks() {
        return marks;
    }

    public void setMarks(MBMark marks) {
        this.marks = marks;
    }
}
