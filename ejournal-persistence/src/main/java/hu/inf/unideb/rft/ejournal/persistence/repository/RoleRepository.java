package hu.inf.unideb.rft.ejournal.persistence.repository;


import hu.inf.unideb.rft.ejournal.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findById(Long id);

    Role findByName(String name);

    @Query("SELECT r FROM User u JOIN u.roles r WHERE u.id = ?1")
    List<Role> findRolesByUserId(Long userId);

}
