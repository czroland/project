package hu.inf.unideb.rft.ejournal.service;


import hu.inf.unideb.rft.ejournal.vo.UserVo;

import java.util.List;

public interface UserService {

    void saveUser(UserVo userVo);

    List<UserVo> getAllUsers();

    UserVo getUserById(Long id);

    UserVo getUserByName(String name);

    UserVo getUserByEmail(String email);
}
