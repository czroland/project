package hu.inf.unideb.rft.ejournal.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "classes")
public class Class extends BaseEntity {

    private String year;

    private String name;

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
}
