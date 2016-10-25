package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class ParentVo implements Serializable {

    private static final long serialVersionUID = -6274509843615715616L;

    private Long id;

    private UserVo user;

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
}