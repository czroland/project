package hu.inf.unideb.rft.ejournal.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
public class Class extends BaseEntity {

    private String year;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Subject> subjects;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
