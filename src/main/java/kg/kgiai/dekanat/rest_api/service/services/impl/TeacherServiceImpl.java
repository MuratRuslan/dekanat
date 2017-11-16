package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Teacher;
import kg.kgiai.dekanat.rest_api.model.Lesson;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;

@Service
public class TeacherServiceImpl extends AbstractService<Teacher, Long> implements TeacherService {

    @Autowired
    public TeacherServiceImpl(JpaRepository<Teacher, Long> repository) {
        super(repository);
    }

    @Override
    public Teacher getByName(String name) throws NotSupportedException {
        throw new NotSupportedException();
    }
}
