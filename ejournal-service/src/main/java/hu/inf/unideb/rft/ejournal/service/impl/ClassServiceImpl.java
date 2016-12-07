package hu.inf.unideb.rft.ejournal.service.impl;

import hu.inf.unideb.rft.ejournal.persistence.entity.Class;
import hu.inf.unideb.rft.ejournal.persistence.entity.Subject;
import hu.inf.unideb.rft.ejournal.persistence.repository.ClassRepository;
import hu.inf.unideb.rft.ejournal.service.ClassService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ClassVo getClassById(Long id) {
        Class aClass = classRepository.findOne(id);
        if (aClass != null) {
            return map(aClass, ClassVo.class);
        }
        return null;
    }

    @Override
    public void addSubjectToClass(Long id, SubjectVo subjectVo) {
        boolean contains = false;

        for (Subject subject : classRepository.findById(id).getSubjects()) {
            contains = subject.getName().equals(subjectVo.getName());
            if (contains) break;
        }

        if (!contains) {
            classRepository.findById(id).getSubjects().add(map(subjectVo, Subject.class));
        }
    }

    @Override
    public void removeSubjectFromClass(Long id, SubjectVo subjectVo) {
        List<Subject> newSubjects = classRepository.findById(id)
                .getSubjects()
                .stream()
                .filter(subject -> !(subject.getName().equals(subjectVo.getName())))
                .collect(Collectors.toList());

        classRepository.findById(id).setSubjects(newSubjects);
    }
}
