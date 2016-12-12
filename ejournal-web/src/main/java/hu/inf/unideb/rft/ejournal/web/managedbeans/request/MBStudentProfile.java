package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.MarkService;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.web.enums.Roles;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "profileBean")
@RequestScoped
public class MBStudentProfile {

    @ManagedProperty(value = "#{studentBean}")
    private MBStudent student;

    @ManagedProperty(value = "#{markBean}")
    private MBMark marks;

    @ManagedProperty(value = "#{publicProfileBean}")
    private MBProfile publiProfile;

    @ManagedProperty(value = "#{teacherBean}")
    private MBTeacher teacher;

    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    @EJB
    StudentService studentService;

    @EJB
    UserService userService;

    @EJB
    MarkService markService;

    @EJB
    TeacherService teacherService;


    public void onLoad() {
        StudentVo possibleStudent;
        user.setUser(
                userService.getUserByName(FacesContext.
                        getCurrentInstance()
                        .getExternalContext()
                        .getUserPrincipal()
                        .getName())
        );

        if (publiProfile.getProfileId() != null) {
            possibleStudent = studentService.getStudentById(publiProfile.getProfileId());
        } else {
            possibleStudent = studentService.getStudentById(user.getUser().getId());
        }

        if (possibleStudent != null) {
            marks.setMarks(markService.getMarksByStudentId(possibleStudent.getId()));
        }

        student.setStudent(possibleStudent);

        setAdmin();
        setOwner();
        setParent();
        setTeacher();
    }


    private void setAdmin() {
        for (RoleVo roleVo : user.getUser().getRoles()) {
            if (Roles.ROLE_ADMIN.toString().equals(roleVo.getName())) {
                publiProfile.setAdmin(true);
            }
        }
    }

    private void setOwner() {
        if (student.getStudent() != null) {
            if (student.getStudent().getUser().getId().equals(user.getUser().getId())) {
                publiProfile.setOwner(true);
            }
        }
    }

    private void setParent() {
        if (student.getStudent() != null) {
            if (student.getStudent().getParent().getUser().getId().equals(user.getUser().getId())) {
                publiProfile.setParent(true);
            }
        }
    }

    private void setTeacher() {
        List<ClassVo> classes;
        teacher.setTeacher(teacherService.getTeacherbyUserId(user.getUser().getId()));
        if (teacher.getTeacher().getAclasses() != null) {
            classes = teacher.getTeacher().getAclasses();
            if (student.getStudent() != null) {
                for (ClassVo classVo : classes)
                    if (student.getStudent().getAclass().getId().equals(classVo.getId())) {
                        publiProfile.setTeacher(true);
                    }
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

    public MBMark getMarks() {
        return marks;
    }

    public void setMarks(MBMark marks) {
        this.marks = marks;
    }

    public MBTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(MBTeacher teacher) {
        this.teacher = teacher;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public MarkService getMarkService() {
        return markService;
    }

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }
}
