package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Subject;
import kg.kgiai.dekanat.rest_api.repository.SubjectRepository;
import kg.kgiai.dekanat.rest_api.service.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(Integer id) {
        return subjectRepository.findOne(id);
    }

    @Override
    public Subject getByName(String name) {
        return subjectRepository.findByName(name);
    }

    @Override
    public void save(Subject object) {
        subjectRepository.save(object);
    }

    @Override
    public void save(Iterable<Subject> iterable) {
        subjectRepository.save(iterable);
    }

    @Override
    public void delete(Iterable<Subject> iterable) {
        subjectRepository.delete(iterable);
    }

    @Override
    public void delete(Integer id) {
        subjectRepository.delete(id);
    }
}
