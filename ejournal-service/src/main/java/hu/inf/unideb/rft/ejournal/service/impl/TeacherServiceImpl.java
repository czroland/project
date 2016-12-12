package hu.inf.unideb.rft.ejournal.service.impl;


import hu.inf.unideb.rft.ejournal.persistence.entity.*;
import hu.inf.unideb.rft.ejournal.persistence.entity.Class;
import hu.inf.unideb.rft.ejournal.persistence.repository.RoleRepository;
import hu.inf.unideb.rft.ejournal.persistence.repository.TeacherRepository;
import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.vo.ClassVo;
import hu.inf.unideb.rft.ejournal.vo.SubjectVo;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;
import java.util.stream.Collectors;


@Stateless(name = "TeacherService", mappedName = "TeacherService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(TeacherService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class TeacherServiceImpl extends AbstractMappingService implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<TeacherVo> getAllTeachers() {
        return map(teacherRepository.findAll(), TeacherVo.class);
    }

    @Override
    public void saveTeacher(TeacherVo teacherVo) {
        teacherRepository.save(map(teacherVo, Teacher.class));
    }

    @Override
    public TeacherVo getTeacherbyId(Long id) {
        Teacher teacher = null;
        teacher = teacherRepository.findOne(id);
        if (teacher != null) {
            return map(teacher, TeacherVo.class);
        }
        return null;
    }

    @Override
    public void addSubjectToUser(Long id, SubjectVo subjectVo) {
        boolean contains = false;

        for (Subject subject : teacherRepository.findById(id).getSubject()) {
            contains = subject.getName().equals(subjectVo.getName());
            if (contains) break;
        }

        if (!contains) {
            teacherRepository.findById(id).getSubject().add(map(subjectVo, Subject.class));
        }
    }

    @Override
    public void removeSubjectFromUser(Long id, SubjectVo subjectVo) {

        List<Subject> newSubjects = teacherRepository.findById(id)
                .getSubject()
                .stream()
                .filter(subject -> !(subject.getName().equals(subjectVo.getName())))
                .collect(Collectors.toList());

        teacherRepository.findById(id).setSubject(newSubjects);
    }

    @Override
    public void addClassToTeacher(Long id, ClassVo classVo) {
        boolean contains = false;

        for (Class aClass : teacherRepository.findById(id).getAclasses()) {
            contains = aClass.getName().equals(classVo.getName());
            if (contains) break;
        }

        if (!contains) {
            teacherRepository.findById(id).getAclasses().add(map(classVo, Class.class));
        }
    }

    @Override
    public void removeClassFromTeacher(Long id, ClassVo classVo) {

        List<Class> newClasses = teacherRepository.findById(id)
                .getAclasses()
                .stream()
                .filter(aClass -> !(aClass.getName().equals(classVo.getName())))
                .collect(Collectors.toList());

        teacherRepository.findById(id).setAclasses(newClasses);
    }

    @Override
    public TeacherVo getTeacherbyUserId(Long id) {
        Teacher teacher = null;
        teacher = teacherRepository.findByUserId(id);
        if (teacher != null) {
            return map(teacher, TeacherVo.class);
        }
        return null;
    }
}
