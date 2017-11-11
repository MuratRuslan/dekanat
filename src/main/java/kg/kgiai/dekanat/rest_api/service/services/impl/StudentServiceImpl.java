package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Student;
import kg.kgiai.dekanat.rest_api.repository.StudentRepository;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;

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
}
