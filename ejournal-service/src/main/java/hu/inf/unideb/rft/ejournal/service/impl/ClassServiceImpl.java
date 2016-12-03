package hu.inf.unideb.rft.ejournal.service.impl;

import hu.inf.unideb.rft.ejournal.persistence.entity.Class;
import hu.inf.unideb.rft.ejournal.persistence.repository.ClassRepository;
import hu.inf.unideb.rft.ejournal.service.ClassService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "ClassService", mappedName = "ClassService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(ClassService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class ClassServiceImpl extends AbstractMappingService implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public void createClass(ClassVo classVo) {
        classRepository.save(map(classVo, Class.class));

    }

    @Override
    public List<ClassVo> getAllClasses() {
        return map(classRepository.findAll(), ClassVo.class);
    }
}
