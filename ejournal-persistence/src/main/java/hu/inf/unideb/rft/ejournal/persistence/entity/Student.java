package hu.inf.unideb.rft.ejournal.persistence.entity;


import javax.persistence.*;
import java.lang.*;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "class_id")
    private Class aclass;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Class getAclass() {
        return aclass;
    }

    public void setAclass(Class aclass) {
        this.aclass = aclass;
    }
}
