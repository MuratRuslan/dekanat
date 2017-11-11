package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.repository.TimetableRepository;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.LessonService;
import kg.kgiai.dekanat.rest_api.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;
import java.util.List;

@Service
public class LessonServiceImpl extends AbstractService<Timetable, Long> implements LessonService {

    @Autowired
    public LessonServiceImpl(JpaRepository<Timetable, Long> repository) {
        super(repository);
    }

    @Override
    public Timetable getByName(String name) throws NotSupportedException {
        throw new NotSupportedException();
    }

    @Override
    public List<Timetable> getAllByDay(String weekday) {
        return ((TimetableRepository)repository).findByDay(weekday);
    }
}
