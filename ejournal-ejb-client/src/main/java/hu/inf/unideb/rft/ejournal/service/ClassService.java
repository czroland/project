package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.ClassVo;

import java.util.List;

public interface ClassService {

    void createClass(ClassVo classVo);

    List<ClassVo> getAllClasses();

    ClassVo getClassById(Long id);

}
