package hu.inf.unideb.rft.ejournal.service.impl;

import hu.inf.unideb.rft.ejournal.persistence.entity.Mark;
import hu.inf.unideb.rft.ejournal.persistence.repository.MarkRepository;
import hu.inf.unideb.rft.ejournal.service.MarkService;
import hu.inf.unideb.rft.ejournal.vo.MarkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "MarkService", mappedName = "MarkService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(MarkService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class MarkServiceImpl extends AbstractMappingService implements MarkService {
    @Autowired
    private MarkRepository markRepository;

    @Override
    public void saveMark(MarkVo markVo) {
        markRepository.save(map(markVo, Mark.class));
    }

    @Override
    public MarkVo getMarkbyId(Long id) {
        Mark mark = null;
        mark = markRepository.findById(id);
        if (mark != null) {
            return map(mark, MarkVo.class);
        }
        return null;
    }

    @Override
    public List<MarkVo> getMarksByStudentId(Long id) {
        return map(markRepository.findByStudentId(id), MarkVo.class);
    }

}
