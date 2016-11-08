package hu.inf.unideb.rft.ejournal.web.validators;

import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.UserVo;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@FacesValidator
@ManagedBean(name = "userNameValidatorBean")
@RequestScoped
public class UserNameValidatorMB implements Validator {

    @EJB
    private UserService userService;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String username = o.toString();
        ResourceBundle bundle;

        try {
            bundle = ResourceBundle.getBundle("resourcebundles.ejournal",
                    facesContext.getViewRoot().getLocale());
        } catch (MissingResourceException e) {
            bundle = ResourceBundle.getBundle("resourcebundles.ejournal", Locale.ENGLISH);
        }

        if (username.length() < 5) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    bundle.getString("validator.uname.short"),
                    "\"" + username + "\""
                            + bundle.getString("validator.uname.lenght")));
        }

        UserVo user = userService.getUserByName(username);

        if (user != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    bundle.getString("validator.uname.exists"),
                    bundle.getString("validator.uname") + " \"" + username
                            + "\" " + bundle.getString("validator.uname.choose")));
        }
    }
}
