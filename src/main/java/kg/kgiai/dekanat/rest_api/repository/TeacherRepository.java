package kg.kgiai.dekanat.rest_api.repository;

import kg.kgiai.dekanat.rest_api.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
