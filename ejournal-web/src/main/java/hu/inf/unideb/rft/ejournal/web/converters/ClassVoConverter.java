package hu.inf.unideb.rft.ejournal.web.converters;

import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBClass;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("classVoConverter")
public class ClassVoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        MBClass mbClass = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{classBean}", MBClass.class);
        return mbClass.findClassById(Long.valueOf(submittedValue));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object modelValue) {
        if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof ClassVo) {
            return ((ClassVo) modelValue).getId().toString();
        } else {
            return "";
        }
    }
}
