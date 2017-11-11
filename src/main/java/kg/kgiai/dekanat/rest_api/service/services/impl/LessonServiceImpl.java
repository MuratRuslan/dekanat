package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.repository.TimetableRepository;
import kg.kgiai.dekanat.rest_api.service.services.LessonService;
import kg.kgiai.dekanat.rest_api.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private TimetableRepository lessonRepository;

    @Override
    public List<Timetable> getAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Timetable getById(Long id) {
        return lessonRepository.findOne(id);
    }

    @Override
    public Timetable getByName(String name) throws NotSupportedException {
        throw new NotSupportedException();
    }

    @Override
    public void save(Timetable object) {
        lessonRepository.save(object);
    }

    @Override
    public void save(Iterable<Timetable> iterable) {
        lessonRepository.save(iterable);
    }

    @Override
    public List<Timetable> getAllByDay(String weekday) {
        return lessonRepository.findByDay(weekday);
    }

    @Override
    public void delete(Iterable<Timetable> iterable) {
        lessonRepository.delete(iterable);
    }

    @Override
    public void delete(Long id) {
        lessonRepository.delete(id);
    }
}
