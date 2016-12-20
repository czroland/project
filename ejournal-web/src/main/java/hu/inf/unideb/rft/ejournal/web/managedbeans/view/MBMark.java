package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.MarkService;
import hu.inf.unideb.rft.ejournal.vo.MarkVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.request.MBWhatIsTheCurrentUser;
import org.primefaces.model.DualListModel;

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

    @ManagedProperty(value = "#{currentUserBean}")
    private MBWhatIsTheCurrentUser current;

    @EJB
    MarkService markService;

    private DualListModel<MarkVo> marks;

    private MarkVo mark;

    @PostConstruct
    public void init() {
        mark = new MarkVo();

        List<MarkVo> markSource = new ArrayList<>();
        List<MarkVo> markTarget = new ArrayList<>();

        markSource = markService.getMarksByStudentId(publiProfile.getProfileId());

        marks = new DualListModel<MarkVo>(markSource, markTarget);

    }

    public void addMark(StudentVo student, SubjectVo subject, int grade) {
        MarkVo mark = new MarkVo();
        mark.setTeacher(current.getTeacher().getTeacher());
        mark.setStudent(student);
        mark.setValue(grade);
        mark.setSubject(subject);
        markService.saveMark(mark);
    }


    public MarkVo findMarkById(Long id) {
        return markService.getMarkbyId(id);
    }

    public DualListModel<MarkVo> getMarks() {
        return marks;
    }

    public void setMarks(DualListModel<MarkVo> marks) {
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

    public MBWhatIsTheCurrentUser getCurrent() {
        return current;
    }

    public void setCurrent(MBWhatIsTheCurrentUser current) {
        this.current = current;
    }
}
