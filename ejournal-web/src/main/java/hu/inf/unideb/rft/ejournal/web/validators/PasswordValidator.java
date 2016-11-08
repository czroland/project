package hu.inf.unideb.rft.ejournal.web.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String password = o.toString();
        ResourceBundle bundle;
        try {
            bundle = ResourceBundle.getBundle("resourcebundles.ejournal", facesContext.getViewRoot().getLocale());
        } catch (MissingResourceException e) {
            bundle = ResourceBundle.getBundle("resourcebundles.ejournal", Locale.ENGLISH);
        }

        if (password.length() < 6) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    bundle.getString("validator.passoword"),
                    bundle.getString("validator.passoword")));
        }
    }
}
