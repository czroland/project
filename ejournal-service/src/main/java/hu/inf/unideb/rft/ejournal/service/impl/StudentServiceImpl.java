package hu.inf.unideb.rft.ejournal.service.impl;


import hu.inf.unideb.rft.ejournal.persistence.entity.Student;
import hu.inf.unideb.rft.ejournal.persistence.repository.StudentRepository;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "StudentService", mappedName = "StudentService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(StudentService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class StudentServiceImpl extends AbstractMappingService implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveUser(StudentVo studentVo) {
        studentRepository.save(map(studentVo, Student.class));
    }

    @Override
    public List<StudentVo> getAllUsers() {
        return map(studentRepository.findAll(), StudentVo.class);
    }

    @Override
    public StudentVo getStudentById(Long id) {
        Student student = null;
        student = studentRepository.findById(id);
        if (student != null) {
            return map(student, StudentVo.class);
        }
        return null;
    }

    @Override
    public StudentVo getStudentByName(String name) {
        Student student = null;
        student = studentRepository.findByName(name);
        if (student != null) {
            return map(student, StudentVo.class);
        }
        return null;
    }

    @Override
    public StudentVo getStudentByEmail(String email) {
        Student student = null;
        student = studentRepository.findByEmail(email);
        if (student != null) {
            return map(student, StudentVo.class);
        }
        return null;
    }

    @Override
    public StudentVo getStudentByPhonenumber(Number Phonenumber) {
        Student student = null;
        student = studentRepository.findByPhonenumber(Phonenumber);
        if (student != null) {
            return map(student, StudentVo.class);
        }
        return null;
    }
}

