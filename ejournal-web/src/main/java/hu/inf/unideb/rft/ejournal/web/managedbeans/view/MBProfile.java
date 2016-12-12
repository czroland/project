package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.service.MarkService;
import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.vo.MarkVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "publicProfileBean")
@ViewScoped
public class MBProfile  implements Serializable {

    private static final long serialVersionUID = 8080516358512431815L;

    private Long profileId = null;

    @EJB
    private MarkService markService;

    private boolean isAdmin;
    private boolean isParent;
    private boolean isOwner;
    private boolean isTeacher;


    private List<MarkVo> studentMarks = new ArrayList<>();

    public MarkService getMarkService() {
        return markService;
    }

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    public List<MarkVo> getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(List<MarkVo> studentMarks) {
        this.studentMarks = studentMarks;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }
}
