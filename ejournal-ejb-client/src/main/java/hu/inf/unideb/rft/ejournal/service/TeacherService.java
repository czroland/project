package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;

import java.util.List;

public interface TeacherService {

    List<TeacherVo> getAllTeachers();

    void saveTeacher(TeacherVo teacherVo);

    TeacherVo getTeacherbyId(Long id);

    void addSubjectToUser(Long id, SubjectVo subjectVo);

    void removeSubjectFromUser(Long id, SubjectVo subjectVo);

    void addClassToTeacher(Long id, ClassVo classVo);

    void removeClassFromTeacher(Long id, ClassVo classVo);

    TeacherVo getTeacherbyUserId(Long id);
}
