package kg.kgiai.dekanat.rest_api.repository;

import kg.kgiai.dekanat.rest_api.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findByName(String name);
}
