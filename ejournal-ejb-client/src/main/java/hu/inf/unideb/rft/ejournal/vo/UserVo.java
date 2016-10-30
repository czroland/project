package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserVo implements Serializable {

    private static final long serialVersionUID = 4856219201746281938L;

    private Long id;

    private String name;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private List<RoleVo> roles;

    public UserVo() {
        roles = new ArrayList<>();
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

    public List<RoleVo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVo> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
