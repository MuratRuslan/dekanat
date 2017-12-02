package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Semester;
import kg.kgiai.dekanat.rest_api.repository.SemesterRepository;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.SemesterService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;

@Service
public class SemesterServiceImpl extends AbstractService<Semester, Long> implements SemesterService {

    public SemesterServiceImpl(JpaRepository<Semester, Long> repository) {
        super(repository);
    }

    @Override
    public Semester getByName(String name) throws NotSupportedException {
        return ((SemesterRepository)repository).findByName(name);
    }

    @Override
    public Boolean exist(Semester semester) {
        return
                ((SemesterRepository)repository).findByNameAndYear(
                        semester.getName(), semester.getYear())
                != null;
    }
}
