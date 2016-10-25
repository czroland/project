package hu.inf.unideb.rft.ejournal.vo;

import java.io.Serializable;

public class MarkVo implements Serializable{

    private static final long serialVersionUID = 5494350187711576327L;

    private StudentVo student;

    private Long id;

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
}
