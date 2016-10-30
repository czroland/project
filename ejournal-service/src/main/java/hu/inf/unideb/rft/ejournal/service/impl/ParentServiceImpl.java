package hu.inf.unideb.rft.ejournal.service.impl;

import hu.inf.unideb.rft.ejournal.persistence.entity.Parent;
import hu.inf.unideb.rft.ejournal.persistence.repository.ParentRepository;
import hu.inf.unideb.rft.ejournal.service.ParentService;
import hu.inf.unideb.rft.ejournal.vo.ParentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "ParentService", mappedName = "ParentService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(ParentService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class ParentServiceImpl extends AbstractMappingService implements ParentService {
    @Autowired
    private ParentRepository parentRepository;

    @Override
    public void saveParent(ParentVo parentVo) {
        parentRepository.save(map(parentVo, Parent.class));
    }

    @Override
    public List<ParentVo> getAllUsers() {
        return map(parentRepository.findAll(), ParentVo.class);
    }

    @Override
    public ParentVo getParentById(Long id) {
        Parent parent = null;
        parent = parentRepository.findById(id);
        if (parent != null) {
            return map(parent, ParentVo.class);
        }
        return null;
    }

    @Override
    public ParentVo getParentByStudentId(Long id) {
        return null;
    }

    @Override
    public ParentVo getParentByName(String name) {

        return null;
    }

}
