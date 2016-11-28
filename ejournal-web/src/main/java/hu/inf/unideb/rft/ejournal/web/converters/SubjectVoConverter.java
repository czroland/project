package hu.inf.unideb.rft.ejournal.web.converters;


import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBSubjects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("subjectVoConverter")
public class SubjectVoConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        MBSubjects subject = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{subjectBean}", MBSubjects.class);
        return subject.findSubjectById(Long.valueOf(submittedValue));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object modelValue) {
        if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof SubjectVo) {
            return ((SubjectVo) modelValue).getId().toString();
        } else {
            return "";
        }
    }
}
