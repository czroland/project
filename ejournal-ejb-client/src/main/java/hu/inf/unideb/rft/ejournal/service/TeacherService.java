package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;

import java.util.List;

public interface TeacherService {

    List<TeacherVo> getAllTeachers();

    void saveTeacher(TeacherVo teacherVo);

    TeacherVo getTeacherbyId(Long id);

}
