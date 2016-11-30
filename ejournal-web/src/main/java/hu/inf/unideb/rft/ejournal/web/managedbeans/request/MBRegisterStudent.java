package hu.inf.unideb.rft.ejournal.web.managedbeans.request;


import hu.inf.unideb.rft.ejournal.service.EmailService;
import hu.inf.unideb.rft.ejournal.service.ParentService;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.web.email_operations.SendEmail;
import hu.inf.unideb.rft.ejournal.web.managedbeans.view.MBStudent;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "registerStudent")
@RequestScoped
public class MBRegisterStudent {

    @ManagedProperty(value = "#{studentBean}")
    private MBStudent student;

    @EJB
    StudentService studentService;

    @EJB
    ParentService parentService;

    @EJB
    EmailService email;

    public String doCreate() {

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        student.getStudent()
                .getUser()
                .setPassword(bCryptPasswordEncoder.encode(student.getStudent()
                        .getUser()
                        .getPassword()));

        student.getStudent()
                .getParent()
                .getUser()
                .setPassword(bCryptPasswordEncoder.encode(student.getStudent().getParent()
                        .getUser()
                        .getPassword()));

        studentService.saveStudent(student.getStudent());


        //SendEmail email = new SendEmail();
        email.sendMessage(student.getStudent().getUser().getEmail(),student.getStudent().getUser().getFirstName(),student.getStudent().getUser().getLastName());
        email.sendMessage(student.getStudent().getParent().getUser().getEmail(),student.getStudent().getParent().getUser().getFirstName(),student.getStudent().getParent().getUser().getLastName());
        return "200";
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public MBStudent getStudent() {
        return student;
    }

    public void setStudent(MBStudent student) {
        this.student = student;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public ParentService getParentService() {
        return parentService;
    }

    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }
}
