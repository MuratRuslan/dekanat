package kg.kgiai.dekanat.rest_api.repository;


import kg.kgiai.dekanat.rest_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByGruppaId(Long gruppaId);
}
