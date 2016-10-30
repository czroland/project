package hu.inf.unideb.rft.ejournal.web.managedbeans.view;


import hu.inf.unideb.rft.ejournal.vo.UserVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "userBean")
@ViewScoped
public class MBUser implements Serializable {

    private static final long serialVersionUID = 1556938853275925882L;

    private UserVo user = new UserVo();

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }
}
