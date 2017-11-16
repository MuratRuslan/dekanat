package kg.kgiai.dekanat.rest_api.service.services;

import kg.kgiai.dekanat.rest_api.model.Lesson;
import kg.kgiai.dekanat.rest_api.service.Service;

import java.util.List;

public interface LessonService extends Service<Lesson, Long> {
    List<Lesson> getAllByDay(String weekday);

    boolean isAcceptable(Lesson lesson);
}
