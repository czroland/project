package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class StudentVo implements Serializable {

    private static final long serialVersionUID = 4856219201746281938L;

    private Long id;

    private String name;

    private String email;

    private String password;

    private Number Phonenumber;

    private int Age;

    private String gender;

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

    public Number getPhonenumber() { return Phonenumber; }

    public void setPhonenumber(Number phonenumber) { Phonenumber = phonenumber; }

    public int getAge() { return Age; }

    public void setAge(int age) { Age = age; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }
}
