package hu.inf.unideb.rft.ejournal.web.managedbeans.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

@ManagedBean(name = "localeBean")
@SessionScoped
public class MBLocale implements Serializable {

    private static final long serialVersionUID = 1358179251745548546L;
    
    private Locale locale;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLanguageToEnglish(ActionEvent event) throws IOException {
        locale = new Locale("en");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

    public void setLanguageToHungarian(ActionEvent event) throws IOException {
        locale = new Locale("hu_hu");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

}
