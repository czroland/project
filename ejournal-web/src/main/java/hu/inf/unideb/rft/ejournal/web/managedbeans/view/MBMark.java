package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.MarkService;
import hu.inf.unideb.rft.ejournal.vo.MarkVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "markBean")
@ViewScoped
public class MBMark implements Serializable {

    private static final long serialVersionUID = -6851234272398612495L;

    @ManagedProperty(value = "#{publicProfileBean}")
    private MBProfile publiProfile;

    @EJB
    MarkService markService;

    private List<MarkVo> marks = new ArrayList<>();

    private MarkVo mark;

    @PostConstruct
    public void init() {
        mark = new MarkVo();
        marks = markService.getMarksByStudentId(publiProfile.getProfileId());
    }

    public List<MarkVo> getMarks() {
        return marks;
    }

    public void setMarks(List<MarkVo> marks) {
        this.marks = marks;
    }

    public MBProfile getPubliProfile() {
        return publiProfile;
    }

    public void setPubliProfile(MBProfile publiProfile) {
        this.publiProfile = publiProfile;
    }

    public MarkService getMarkService() {
        return markService;
    }

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    public MarkVo getMark() {
        return mark;
    }

    public void setMark(MarkVo mark) {
        this.mark = mark;
    }
}
