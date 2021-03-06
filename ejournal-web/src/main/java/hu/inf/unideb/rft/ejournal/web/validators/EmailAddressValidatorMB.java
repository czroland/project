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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator
@ManagedBean(name = "emailAddressValidatorBean")
@RequestScoped
public class EmailAddressValidatorMB implements Validator {

    @EJB
    private UserService userService;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = o.toString();

        String pattern = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
        Pattern emailPattern = Pattern.compile(pattern);
        Matcher matcher = emailPattern.matcher(email);

        ResourceBundle bundle;
        try {
            bundle = ResourceBundle.getBundle("resourcebundles.ejournal", facesContext.getViewRoot().getLocale());
        } catch (MissingResourceException e) {
            bundle = ResourceBundle.getBundle("resourcebundles.ejournal", Locale.ENGLISH);
        }

        if (!matcher.find()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    bundle.getString("validator.email.format"),
                    "\"" + email + "\" " + bundle.getString("validator.email.format")));
        }

        UserVo user = userService.getUserByEmail(email);

        if (user != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    bundle.getString("validator.email.exists"), "\"" + email
                    + "\" " + bundle.getString("validator.email.exists")));
        }
    }
}
