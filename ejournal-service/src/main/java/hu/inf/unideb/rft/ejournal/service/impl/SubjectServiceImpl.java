package hu.inf.unideb.rft.ejournal.service.impl;

import hu.inf.unideb.rft.ejournal.persistence.entity.Subject;
import hu.inf.unideb.rft.ejournal.persistence.repository.SubjectRepository;
import hu.inf.unideb.rft.ejournal.service.SubjectService;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;

@Stateless(name = "SubjectService", mappedName = "SubjectService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(SubjectService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class SubjectServiceImpl extends AbstractMappingService implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public void saveSubject(SubjectVo subjectVo) {
        subjectRepository.save(map(subjectVo, Subject.class));
    }

    @Override
    public SubjectVo getSubjectbyId(Long id) {
        Subject subject = null;
        subject = subjectRepository.findOne(id);
        if (subject != null) {
            return map(subject, SubjectVo.class);
        }
        return null;
    }

    @Override
    public SubjectVo getSubjectbyName(String name) {
        Subject subject = null;
        subject = subjectRepository.findByName(name);
        if (subject != null) {
            return map(subject, SubjectVo.class);
        }
        return null;
    }
}
