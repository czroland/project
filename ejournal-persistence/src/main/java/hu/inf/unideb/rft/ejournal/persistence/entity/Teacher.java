package hu.inf.unideb.rft.ejournal.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id")
    private Class aclass;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Subject> subject;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    public Class getAclass() {
        return aclass;
    }

    public void setAclass(Class aclass) {
        this.aclass = aclass;
    }
}
