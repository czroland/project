package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class TeacherVo implements Serializable {

    private static final long serialVersionUID = 5494350187711576327L;

    private UserVo user;

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }
}
