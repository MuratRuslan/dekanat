package kg.kgiai.hackathon.timetable.repository;

import kg.kgiai.hackathon.timetable.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
