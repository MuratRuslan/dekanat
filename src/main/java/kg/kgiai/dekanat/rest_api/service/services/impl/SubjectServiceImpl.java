package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Subject;
import kg.kgiai.dekanat.rest_api.repository.SubjectRepository;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends AbstractService<Subject, Integer> implements SubjectService {

    @Autowired
    public SubjectServiceImpl(JpaRepository<Subject, Integer> repository) {
        super(repository);
    }

    @Override
    public Subject getByName(String name) {
        return ((SubjectRepository)repository).findByName(name);
    }
}
