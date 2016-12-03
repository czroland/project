package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.SubjectService;
import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBSubjects;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBTeacher;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "subjectMmt")
@RequestScoped
public class MBSubjectManagement {

    @ManagedProperty(value = "#{teacherBean}")
    private MBTeacher teacher;

    @ManagedProperty(value = "#{subjectBean}")
    private MBSubjects subjects;

    @EJB
    private TeacherService teacherService;
    @EJB
    private SubjectService subjectService;

    public void addSubject(List<TeacherVo> teachers, SubjectVo subjectVo) {

        for (TeacherVo teacherVo : teachers) {
            teacherService.addSubjectToUser(teacherVo.getId(), subjectVo);
        }
        teacher.init();
    }

    public void removeSubject(List<TeacherVo> teachers, SubjectVo subjectVo) {

        for (TeacherVo teacherVo : teachers) {
            teacherService.removeSubjectFromUser(teacherVo.getId(), subjectVo);
        }
        teacher.init();
    }

    public void addNewSubject(String name){
        SubjectVo s = new SubjectVo();
        s.setName(name);
        subjectService.saveSubject(s);
        subjects.init();
    }

    public MBTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(MBTeacher teacher) {
        this.teacher = teacher;
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public MBSubjects getSubjects() {
        return subjects;
    }

    public void setSubjects(MBSubjects subjects) {
        this.subjects = subjects;
    }
}
