package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.StudentVo;

import java.util.List;

public interface StudentService {

    void saveUser(StudentVo studentVo);

    List<StudentVo> getAllUsers();

    StudentVo getStudentById(Long id);

    StudentVo getStudentByName(String name);

    StudentVo getStudentByEmail(String email);

    StudentVo getStudentByPhonenumber(Number Phonenumber);
}
