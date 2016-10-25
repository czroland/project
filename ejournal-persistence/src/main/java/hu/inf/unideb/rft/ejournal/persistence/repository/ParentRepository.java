package hu.inf.unideb.rft.ejournal.persistence.repository;

import hu.inf.unideb.rft.ejournal.persistence.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Long> {

    Parent findById(Long id);

    Parent findByUserId(Long id);

    Parent findByName(String name);
}
