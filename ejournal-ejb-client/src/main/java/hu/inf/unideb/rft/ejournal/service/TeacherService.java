package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.TeacherVo;

public interface TeacherService {

    void saveTeacher(TeacherVo teacherVo);

    TeacherVo getTeacherbyId(Long id);

}
