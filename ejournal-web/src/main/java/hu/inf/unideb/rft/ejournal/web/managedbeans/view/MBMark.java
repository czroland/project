package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import hu.inf.unideb.rft.ejournal.vo.MarkVo;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "markBean")
@ViewScoped
public class MBMark implements Serializable {

    private static final long serialVersionUID = -6851234272398612495L;

    private List<MarkVo> marks = new ArrayList<>();

    public List<MarkVo> getMarks() {
        return marks;
    }

    public void setMarks(List<MarkVo> marks) {
        this.marks = marks;
    }
}
