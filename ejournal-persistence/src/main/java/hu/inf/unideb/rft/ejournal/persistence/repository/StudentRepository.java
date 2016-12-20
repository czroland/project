package hu.inf.unideb.rft.ejournal.persistence.repository;


import hu.inf.unideb.rft.ejournal.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findById(Long id);

    Student findByUserId(Long id);

    Student findByParentId(Long id);

    List<Student> findByAclassId(Long id);
}
