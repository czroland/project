package hu.inf.unideb.rft.ejournal.service.impl;

import hu.inf.unideb.rft.ejournal.persistence.entity.Role;
import hu.inf.unideb.rft.ejournal.persistence.repository.RoleRepository;
import hu.inf.unideb.rft.ejournal.service.RoleService;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "RoleService", mappedName = "RoleService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(RoleService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class RoleServiceImpl extends AbstractMappingService implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveRole(RoleVo roleVo) {
        roleRepository.save(map(roleVo, Role.class));
    }

    @Override
    public RoleVo getRoleById(Long id) {
        Role role = null;
        role = roleRepository.findById(id);
        if (role != null) {
            return map(role, RoleVo.class);
        }
        return null;
    }

    @Override
    public RoleVo getRoleByName(String name) {
        Role role = null;
        role = roleRepository.findByName(name);
        if (role != null) {
            return map(role, RoleVo.class);
        }
        return null;
    }

    @Override
    public List<RoleVo> getRolesByUserId(Long id) {

        return map(roleRepository.findRolesByUserId(id), RoleVo.class);
    }

    @Override
    public List<RoleVo> getAllRoles() {
        return map(roleRepository.findAll(), RoleVo.class);

    }
}
