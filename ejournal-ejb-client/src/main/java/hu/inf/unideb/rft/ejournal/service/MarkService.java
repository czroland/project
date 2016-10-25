package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.MarkVo;

public interface MarkService {

    void saveMark(MarkVo markVo);

    MarkVo getMarkbyId(Long id);
}
