package hu.inf.unideb.rft.ejournal.service.impl;


import hu.inf.unideb.rft.ejournal.persistence.entity.Role;
import hu.inf.unideb.rft.ejournal.persistence.entity.User;
import hu.inf.unideb.rft.ejournal.persistence.repository.RoleRepository;
import hu.inf.unideb.rft.ejournal.persistence.repository.UserRepository;
import hu.inf.unideb.rft.ejournal.service.UserService;
import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless(name = "UserService", mappedName = "UserService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(UserService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class UserServiceImpl extends AbstractMappingService implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveUser(UserVo userVo) {

        User user = map(userVo, User.class);
        if (user.getRoles() == null) {
            user.setRoles(new ArrayList<>(1));
        }
        addUserRole(user);
        userRepository.save(user);

    }

    private void addUserRole(User userEntity) {
        Role role = roleRepository.findByName("ROLE_USER");
        userEntity.getRoles().add(role);
    }

    @Override
    public void addRoleToUser(String name, RoleVo roleVo) {
        boolean contains = false;

        for (Role role : userRepository.findByName(name).getRoles()) {
            contains = role.getName().equals(roleVo.getName());
            if (contains) break;
        }

        if (!contains) {
            userRepository.findByName(name).getRoles().add(map(roleVo, Role.class));
        }
    }

    @Override
    public void removeRoleFromUser(String name, RoleVo roleVo) {
        List<Role> newRoles = userRepository.findByName(name)
                .getRoles()
                .stream()
                .filter(role -> !(role.getName().equals(roleVo.getName())))
                .collect(Collectors.toList());

        userRepository.findByName(name).setRoles(newRoles);
    }

    @Override
    public List<UserVo> getAllUsers() {
        return map(userRepository.findAll(), UserVo.class);
    }

    @Override
    public UserVo getUserById(Long id) {
        User user;
        user = userRepository.findById(id);
        if (user != null) {
            return map(user, UserVo.class);
        }
        return null;
    }

    @Override
    public UserVo getUserByName(String name) {
        User user;
        user = userRepository.findByName(name);
        if (user != null) {
            return map(user, UserVo.class);
        }
        return null;
    }

    @Override
    public UserVo getUserByEmail(String email) {
        User user;
        user = userRepository.findByEmail(email);
        if (user != null) {
            return map(user, UserVo.class);
        }
        return null;
    }
}
