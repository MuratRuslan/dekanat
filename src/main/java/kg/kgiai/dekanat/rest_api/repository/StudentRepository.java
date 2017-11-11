package kg.kgiai.dekanat.rest_api.repository;

import kg.kgiai.dekanat.rest_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
