package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class UserVo implements Serializable {

    private static final long serialVersionUID = 4856219201746281938L;

    private RoleVo role;

    private Long id;

    private String name;

    private String email;

    private String password;

    public RoleVo getRole() {
        return role;
    }

    public void setRole(RoleVo role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
