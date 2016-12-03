package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class ClassVo implements Serializable {

    private static final long serialVersionUID = -3771609845703002746L;

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
