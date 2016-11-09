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

@FacesValidator("checkboxValidator")
public class CheckboxValidator implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        ResourceBundle bundle;
        try {
            bundle = ResourceBundle.getBundle("resourcebundles.ejournal", context.getViewRoot().getLocale());
        } catch (MissingResourceException e) {
            bundle = ResourceBundle.getBundle("resourcebundles.ejournal", Locale.ENGLISH);
        }

        if (value.equals(Boolean.FALSE)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    bundle.getString("validator.terms"),
                    bundle.getString("validator.terms")));
        }


    }
}
