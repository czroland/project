package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.ClassService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "classBean")
@ViewScoped
public class MBClass implements Serializable {

    private static final long serialVersionUID = 8636198376892682232L;

    @EJB
    ClassService classService;

    private ClassVo classVo;
    private ClassVo classVoForStudents;
    private ClassVo classVoForTeachers;

    private DualListModel<ClassVo> classes;

    private List<ClassVo> classSource = new ArrayList<>();

    @PostConstruct
    public void init() {
        classVo= new ClassVo();
       // List<ClassVo> classSource = new ArrayList<>();
        List<ClassVo> classTarget = new ArrayList<>();

        classSource = classService.getAllClasses();

        classes = new DualListModel<ClassVo>(classSource, classTarget);

    }

    public ClassVo findClassById(Long id) {
        return classService.getClassById(id);
    }

    public ClassService getClassService() {
        return classService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    public ClassVo getClassVo() {
        return classVo;
    }

    public void setClassVo(ClassVo classVo) {
        this.classVo = classVo;
    }

    public DualListModel<ClassVo> getClasses() {
        return classes;
    }

    public void setClasses(DualListModel<ClassVo> classes) {
        this.classes = classes;
    }

    public List<ClassVo> getClassSource() {
        return classSource;
    }

    public void setClassSource(List<ClassVo> classSource) {
        this.classSource = classSource;
    }

    public ClassVo getClassVoForStudents() {
        return classVoForStudents;
    }

    public void setClassVoForStudents(ClassVo classVoForStudents) {
        this.classVoForStudents = classVoForStudents;
    }

    public ClassVo getClassVoForTeachers() {
        return classVoForTeachers;
    }

    public void setClassVoForTeachers(ClassVo classVoForTeachers) {
        this.classVoForTeachers = classVoForTeachers;
    }
}
