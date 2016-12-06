package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class ClassVo implements Serializable {

    private static final long serialVersionUID = -3771609845703002746L;

    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClassVo classVo = (ClassVo) o;

        if (!id.equals(classVo.id)) {
            return false;
        }
        return name.equals(classVo.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
