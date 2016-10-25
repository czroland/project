package hu.inf.unideb.rft.ejournal.service;

import hu.inf.unideb.rft.ejournal.vo.SubjectVo;

public interface SubjectService {

    void saveSubject(SubjectVo subjectVo);

    SubjectVo getSubjectbyId(Long id);

    SubjectVo getSubjectbyName(String name);
}
