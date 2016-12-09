package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;
import java.util.List;

public class TeacherVo implements Serializable {

    private static final long serialVersionUID = 5494350187711576327L;

    private Long id;

    private UserVo user;

    private List<ClassVo> aclasses;

    private List<SubjectVo> subject;

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

    public List<SubjectVo> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectVo> subject) {
        this.subject = subject;
    }

    public List<ClassVo> getAclasses() {
        return aclasses;
    }

    public void setAclasses(List<ClassVo> aclasses) {
        this.aclasses = aclasses;
    }
}
