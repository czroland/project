package hu.inf.unideb.rft.ejournal.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @ElementCollection
    @MapKeyColumn(nullable = false)
    @Column(nullable = false)
    private List<String> permissions = new ArrayList<String>();

    @Basic
    @Column(nullable = false)
    private String name;

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
