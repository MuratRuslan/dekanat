package kg.kgiai.hackathon.timetable.repository;

import kg.kgiai.hackathon.timetable.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
