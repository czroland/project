package hu.inf.unideb.rft.ejournal.service;

import hu.inf.unideb.rft.ejournal.vo.ParentVo;

import java.util.List;

public interface ParentService {
    void saveUser(ParentVo parentVo);

    List<ParentVo> getAllUsers();

    ParentVo getParentById(Long id);

    ParentVo getParentByName(String name);

    ParentVo getParentByStudentId(Long id);
}
