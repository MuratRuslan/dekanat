package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Mark;
import kg.kgiai.dekanat.rest_api.model.Student;
import kg.kgiai.dekanat.rest_api.repository.StudentRepository;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl extends AbstractService<Student, Long> implements StudentService {

    @Autowired
    public StudentServiceImpl(JpaRepository<Student, Long> repository) {
        super(repository);
    }

    @Override
    public Student getByName(String name) throws NotSupportedException {
        throw new NotSupportedException();
    }

    @Override
    public List<Student> getAllByGroupId(Long groupId) {
        return ((StudentRepository)repository).findByGruppaId(groupId);
    }

    public List<Student> getStudentMarksByGroupIdAndSemesterId(Long gruppa, Long semester) {
        List<Student> students = ((StudentRepository) repository).findByGruppaId(gruppa);
        students.stream().forEach(student -> {
            List<Mark> marks = new ArrayList<Mark>();
            student.getMarks().stream().forEach(mark -> {
                if (mark.getSemester().getId() == semester) {
                    marks.add(mark);
                }
            });
            student.setMarks(marks);
        });
        return students;
    }
}
