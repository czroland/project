package hu.inf.unideb.rft.ejournal.vo;

import java.io.Serializable;

public class MarkVo implements Serializable{

    private static final long serialVersionUID = 5494350187711576327L;

    private Long id;

    private StudentVo student;

    private SubjectVo subject;

    private TeacherVo teacher;

    public StudentVo getStudent() {
        return student;
    }

    public void setStudent(StudentVo student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubjectVo getSubject() {
        return subject;
    }

    public void setSubject(SubjectVo subject) {
        this.subject = subject;
    }

    public TeacherVo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherVo teacher) {
        this.teacher = teacher;
    }
}
