package hu.inf.unideb.rft.ejournal.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "classes")
public class Class extends BaseEntity {

    private String year;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
