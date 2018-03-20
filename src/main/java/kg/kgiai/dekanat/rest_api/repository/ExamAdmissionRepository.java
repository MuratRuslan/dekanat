package kg.kgiai.dekanat.rest_api.repository;

import kg.kgiai.dekanat.rest_api.model.ExamAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by temirlan on 2/7/18.
 */
@Repository
public interface ExamAdmissionRepository extends JpaRepository<ExamAdmission, Long> {
    boolean getAdmittedByStudentIdAndSemesterId(Long studentId, Long semesterId);
}
