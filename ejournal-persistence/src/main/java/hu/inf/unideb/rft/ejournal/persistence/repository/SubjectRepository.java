package hu.inf.unideb.rft.ejournal.persistence.repository;

import hu.inf.unideb.rft.ejournal.persistence.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject findById(Long id);

    Subject findByName(String name);
}
