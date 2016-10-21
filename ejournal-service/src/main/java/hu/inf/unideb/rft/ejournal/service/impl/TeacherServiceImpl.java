package hu.inf.unideb.rft.ejournal.service.impl;


import hu.inf.unideb.rft.ejournal.persistence.entity.Teacher;
import hu.inf.unideb.rft.ejournal.persistence.repository.TeacherRepository;
import hu.inf.unideb.rft.ejournal.service.TeacherService;
import hu.inf.unideb.rft.ejournal.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;


@Stateless(name = "TeacherService", mappedName = "TeacherService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(TeacherService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class TeacherServiceImpl extends AbstractMappingService implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

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
}
