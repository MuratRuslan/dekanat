package kg.kgiai.dekanat.rest_api.repository;

import kg.kgiai.dekanat.rest_api.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long>{
    Semester findByName(String name);
    Semester findByNameAndYear(String name, Date year);
}
