package hu.inf.unideb.rft.ejournal.service.impl;


import hu.inf.unideb.rft.ejournal.persistence.entity.User;
import hu.inf.unideb.rft.ejournal.persistence.repository.UserRepository;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "UserService", mappedName = "UserService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(UserService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class UserServiceImpl extends AbstractMappingService implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserVo userVo) {
        userRepository.save(map(userVo, User.class));
    }

    @Override
    public List<UserVo> getAllUsers() {
        return map(userRepository.findAll(), UserVo.class);
    }

    @Override
    public UserVo getUserById(Long id) {
        User user = null;
        user = userRepository.findById(id);
        if (user != null) {
            return map(user, UserVo.class);
        }
        return null;
    }

    @Override
    public UserVo getUserByName(String name) {
        User user = null;
        user = userRepository.findByName(name);
        if (user != null) {
            return map(user, UserVo.class);
        }
        return null;
    }

    @Override
    public UserVo getUserByEmail(String email) {
        User user = null;
        user = userRepository.findByEmail(email);
        if (user != null) {
            return map(user, UserVo.class);
        }
        return null;
    }
}
