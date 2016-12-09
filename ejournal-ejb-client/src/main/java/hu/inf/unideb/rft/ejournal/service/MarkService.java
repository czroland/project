package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.MarkVo;

import java.util.List;

public interface MarkService {

    void saveMark(MarkVo markVo);

    MarkVo getMarkbyId(Long id);

    List<MarkVo> getMarksByStudentId(Long id);
}
