package kg.kgiai.dekanat.rest_api.service.services;

import kg.kgiai.dekanat.rest_api.model.Timetable;
import kg.kgiai.dekanat.rest_api.service.Service;

import java.util.List;

public interface LessonService extends Service<Timetable, Long> {
    List<Timetable> getAllByDay(String weekday);
}
