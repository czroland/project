package hu.inf.unideb.rft.ejournal.service;

import hu.inf.unideb.rft.ejournal.vo.SubjectVo;

import java.util.List;

public interface SubjectService {

    void saveSubject(SubjectVo subjectVo);

    List<SubjectVo> getAllSubjects();

    SubjectVo getSubjectbyId(Long id);

    SubjectVo getSubjectbyName(String name);
}
