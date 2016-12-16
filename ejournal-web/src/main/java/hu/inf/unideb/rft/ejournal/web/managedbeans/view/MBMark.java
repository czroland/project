package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.MarkService;
import hu.inf.unideb.rft.ejournal.vo.MarkVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.request.MBWhatIsTheCurrentUser;

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

    @ManagedProperty(value = "#{currentUserBean}")
    private MBWhatIsTheCurrentUser current;

    public void addMark(List<StudentVo> students,SubjectVo subject, int grade) {
        Long i=1L;
        System.out.println("DEBUG1");
        for (StudentVo studentVo : students) {
            MarkVo mark = new MarkVo();
            mark.setTeacher(current.getTeacher());
            mark.setStudent(studentVo);
            System.out.println(mark.getStudent().getUser().getFirstName());
            //mark.setId(i);
            //System.out.println(mark.getId());
            System.out.println(subject);
            mark.setValue(grade);
            System.out.println(mark.getValue());
            mark.setSubject(subject);
            System.out.println(mark.getSubject().getName());
            markService.saveMark(mark);
            System.out.println("DEBUG");
            System.out.println(markService.getMarkbyId(i).getStudent().getUser().getFirstName());
            System.out.println(markService.getMarkbyId(i).getTeacher().getUser().getEmail());
            System.out.println(markService.getMarkbyId(i).getSubject().getName());
            System.out.println(markService.getMarkbyId(i).getValue());
            System.out.println("DEBUG");
            i=i+1;
        }
    }


    public MarkVo findMarkById(Long id) {
        return markService.getMarkbyId(id);
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

    public MBWhatIsTheCurrentUser getCurrent() {
        return current;
    }

    public void setCurrent(MBWhatIsTheCurrentUser current) {
        this.current = current;
    }
}
