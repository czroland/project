package hu.inf.unideb.rft.ejournal.web.managedbeans.request;

import hu.inf.unideb.rft.ejournal.service.ClassService;
import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBClass;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBUser;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.xml.registry.infomodel.User;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "createClassBean")
@RequestScoped
public class MBCreateClass {

    @ManagedProperty(value = "#{classBean}")
    MBClass mbClass;

    @EJB
    ClassService classService;

    public void doCreate()
    {
        classService.createClass(mbClass.getClassVo());
    }

    public MBClass getMbClass() {
        return mbClass;
    }

    public void setMbClass(MBClass mbClass) {
        this.mbClass = mbClass;
    }

    public ClassService getClassService() {
        return classService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
}
