package hu.inf.unideb.rft.ejournal.vo;

import java.io.Serializable;

public class SubjectVo implements Serializable {

    private static final long serialVersionUID = 584194276884030404L;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SubjectVo subjectVo = (SubjectVo) o;

        if (!id.equals(subjectVo.id)) {
            return false;
        }
        return name.equals(subjectVo.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
