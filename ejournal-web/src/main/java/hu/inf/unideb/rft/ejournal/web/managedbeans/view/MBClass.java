package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.ClassService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;

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

    ClassVo classVo;

    private List<ClassVo> classes = new ArrayList<>();

    @PostConstruct
    void init(){
        classVo=new ClassVo();
        classes = classService.getAllClasses();
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

    public List<ClassVo> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassVo> classes) {
        this.classes = classes;
    }
}
