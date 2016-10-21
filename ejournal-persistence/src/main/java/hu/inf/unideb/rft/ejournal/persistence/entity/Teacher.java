package hu.inf.unideb.rft.ejournal.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
