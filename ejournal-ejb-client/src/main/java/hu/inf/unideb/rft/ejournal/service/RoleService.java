package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.RoleVo;

public interface RoleService {

    void saveRole(RoleVo roleVo);

    RoleVo getRolebyId(Long id);

    RoleVo getRolebyName(String name);
}
