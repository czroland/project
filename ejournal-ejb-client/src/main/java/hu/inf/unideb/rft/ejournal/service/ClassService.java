package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;

import java.util.List;

public interface ClassService {

    void createClass(ClassVo classVo);

    List<ClassVo> getAllClasses();

    ClassVo getClassById(Long id);

    void addSubjectToClass(Long id, SubjectVo subjectVo);

    void removeSubjectFromClass(Long id, SubjectVo subjectVo);

}
