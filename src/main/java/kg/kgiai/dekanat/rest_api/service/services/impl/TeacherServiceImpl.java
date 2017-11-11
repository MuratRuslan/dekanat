package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Teacher;
import kg.kgiai.dekanat.rest_api.repository.TeacherRepository;
import kg.kgiai.dekanat.rest_api.service.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(Long id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public Teacher getByName(String name) throws NotSupportedException {
        throw new NotSupportedException();
    }

    @Override
    public void save(Teacher object) {
        teacherRepository.save(object);
    }

    @Override
    public void save(Iterable<Teacher> iterable) {
        teacherRepository.save(iterable);
    }

    @Override
    public void delete(Iterable<Teacher> iterable) {
        teacherRepository.delete(iterable);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.delete(id);
    }
}
