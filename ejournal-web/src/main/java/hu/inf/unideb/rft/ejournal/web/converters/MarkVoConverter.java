package hu.inf.unideb.rft.ejournal.web.converters;

import hu.inf.unideb.rft.ejournal.vo.MarkVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBMark;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("markVoConverter")
public class MarkVoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        MBMark mbMark = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{markBean}", MBMark.class);
        return mbMark.findMarkById(Long.valueOf(submittedValue));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object modelValue) {
        if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof MarkVo) {
            return ((MarkVo) modelValue).getId().toString();
        } else {
            return "";
        }
    }
}
