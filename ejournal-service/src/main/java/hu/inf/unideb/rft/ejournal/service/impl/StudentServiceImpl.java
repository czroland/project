package hu.inf.unideb.rft.ejournal.service.impl;


import hu.inf.unideb.rft.ejournal.persistence.entity.Student;
import hu.inf.unideb.rft.ejournal.persistence.repository.StudentRepository;
import hu.inf.unideb.rft.ejournal.service.StudentService;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
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
    public void saveStudent(StudentVo studentVo) {
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
    public StudentVo getStudentByUserId(Long id) {
        Student student = null;
        student = studentRepository.findByUserId(id);
        if (student != null) {
            return map(student, StudentVo.class);
        }
        return null;
    }

    @Override
    public List<StudentVo> getStudentsByClassId(Long id) {

        return map(studentRepository.findByAclassId(id), StudentVo.class);
    }

    @Override
    public StudentVo getStudentByEmail(String email) {
        return null;
    }

    @Override
    public StudentVo getStudentByPhonenumber(Number Phonenumber) {
        return null;
    }
}

