package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class ParentVo implements Serializable {

    private static final long serialVersionUID = 584194276884030404L;

    private Long id;

    private UserVo user;

    private Long studentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public Long getStudentId() { return studentId; }

    public void setStudentId(Long studentId) { this.studentId = studentId; }
}