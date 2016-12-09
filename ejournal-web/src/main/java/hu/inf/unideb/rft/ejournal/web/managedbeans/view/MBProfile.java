package hu.inf.unideb.rft.ejournal.web.managedbeans.view;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "publicProfileBean")
@ViewScoped
public class MBProfile  implements Serializable {

    private static final long serialVersionUID = 8080516358512431815L;

    private Long profileId = null;

    private boolean isAdmin;
    private boolean isParent;
    private boolean isOwner;

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
}
