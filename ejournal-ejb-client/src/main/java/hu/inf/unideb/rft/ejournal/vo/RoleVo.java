package hu.inf.unideb.rft.ejournal.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoleVo implements Serializable {

    private static final long serialVersionUID = -446040323171528192L;

    private Long id;

    private String name;

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

}
