package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.SubjectService;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "subjectBean")
@ViewScoped
public class MBSubjects implements Serializable {

    private static final long serialVersionUID = -8998031697769938851L;

    private List<SubjectVo> subjects = new ArrayList<>();

    @EJB
    SubjectService subjectService;

    @PostConstruct
    public void init() {
        subjects = subjectService.getAllSubjects();
    }

    public SubjectVo findSubjectById(Long id) {
        return subjectService.getSubjectbyId(id);
    }

    public List<SubjectVo> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectVo> subjects) {
        this.subjects = subjects;
    }

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
}
