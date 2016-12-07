package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.StudentVo;

import java.util.List;

public interface StudentService {

    void saveStudent(StudentVo studentVo);

    List<StudentVo> getAllStudents();

    StudentVo getStudentById(Long id);

    StudentVo getStudentByUserId(Long id);

    List<StudentVo> getStudentsByClassId(Long id);

    StudentVo getStudentByEmail(String email);

    StudentVo getStudentByPhonenumber(Number Phonenumber);

    void addClassToStudent(Long id, ClassVo classVo);

    void removeClassFromStudent(Long id, ClassVo classVo);

}
