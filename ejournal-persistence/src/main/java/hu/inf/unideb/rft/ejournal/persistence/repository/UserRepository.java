package hu.inf.unideb.rft.ejournal.persistence.repository;


import hu.inf.unideb.rft.ejournal.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
