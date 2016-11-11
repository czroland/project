package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.RoleVo;
import hu.inf.unideb.rft.ejournal.vo.UserVo;

import java.util.List;

public interface UserService {

    void saveUser(UserVo userVo);

    void addRoleToUser(String name, RoleVo roleVo);

    List<UserVo> getAllUsers();

    UserVo getUserById(Long id);

    UserVo getUserByName(String name);

    UserVo getUserByEmail(String email);
}
