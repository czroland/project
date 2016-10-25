package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class TeacherVo implements Serializable {

    private static final long serialVersionUID = 5494350187711576327L;

    private Long id;

    private UserVo user;

    private SubjectVo subject;

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
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

}
