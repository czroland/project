package hu.inf.unideb.rft.ejournal.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoleVo implements Serializable {

    private Long id;

    private String name;

    private List<ArrayList> permissions;

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

    public List<ArrayList> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<ArrayList> permissions) {
        this.permissions = permissions;
    }
}
