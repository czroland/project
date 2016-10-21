package hu.inf.unideb.rft.ejournal.vo;


import java.io.Serializable;

public class ClassVo implements Serializable {

    private static final long serialVersionUID = -3771609845703002746L;

    private TeacherVo teacher;

    private String year;

    public TeacherVo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherVo teacher) {
        this.teacher = teacher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
