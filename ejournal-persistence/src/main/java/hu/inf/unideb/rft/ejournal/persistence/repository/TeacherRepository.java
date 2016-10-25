package hu.inf.unideb.rft.ejournal.persistence.repository;


import hu.inf.unideb.rft.ejournal.persistence.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findById(Long id);
}

