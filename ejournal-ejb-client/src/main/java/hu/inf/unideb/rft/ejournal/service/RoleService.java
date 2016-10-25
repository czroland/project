package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.RoleVo;

public interface RoleService {

    void saveRole(RoleVo roleVo);

    RoleVo getRoleById(Long id);

    RoleVo getRoleByName(String name);
}
