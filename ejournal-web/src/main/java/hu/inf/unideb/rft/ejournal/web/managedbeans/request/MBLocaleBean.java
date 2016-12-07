package hu.inf.unideb.rft.ejournal.web.managedbeans.request;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Locale;



@ManagedBean(name="localeBean")
@SessionScoped
public class MBLocaleBean {

    private Locale locale;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLanguageToEnglish() {
        locale = new Locale("en");
    }

    public void setLanguageToHungarian() {
        locale = new Locale("hu_hu");
    }

}
