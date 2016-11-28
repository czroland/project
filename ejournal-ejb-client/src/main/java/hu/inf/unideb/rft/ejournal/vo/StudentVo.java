package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class StudentVo implements Serializable {

    private static final long serialVersionUID = 1100142290568181816L;

    private Long id;

    private UserVo user;

    private ParentVo parent;

    private ClassVo aclass;

    public StudentVo() {
    }

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

    public ClassVo getAclass() {
        return aclass;
    }

    public void setAclass(ClassVo aclass) {
        this.aclass = aclass;
    }

    public ParentVo getParent() {
        return parent;
    }

    public void setParent(ParentVo parent) {
        this.parent = parent;
    }
}


