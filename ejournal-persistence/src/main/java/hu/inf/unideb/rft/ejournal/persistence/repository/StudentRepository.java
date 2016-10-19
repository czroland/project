package hu.inf.unideb.rft.ejournal.persistence.repository;


import hu.inf.unideb.rft.ejournal.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findById(Long id);

    Student findByName(String name);

    Student findByEmail(String email);

    Student findByPhonenumber(Number Phonenumber);

}
