package hu.inf.unideb.rft.ejournal.persistence.repository;


import hu.inf.unideb.rft.ejournal.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    User findByName(String name);

    User findByEmail(String email);
}
