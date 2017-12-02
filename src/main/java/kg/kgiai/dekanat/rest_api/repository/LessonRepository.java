package kg.kgiai.dekanat.rest_api.repository;



import kg.kgiai.dekanat.rest_api.model.Gruppa;
import kg.kgiai.dekanat.rest_api.model.Lesson;
import kg.kgiai.dekanat.rest_api.model.Room;
import kg.kgiai.dekanat.rest_api.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByDayAndGruppaOrderByTime(String day, Gruppa gruppa);

    List<Lesson> findByDay(String day);

    List<Lesson> findByTimeAndDayAndTeachersContaining(Date time, String day, List<Teacher> teachers);

    List<Lesson> findByDayAndTimeAndRoomsContaining(String day, Date time, List<Room> rooms);

    List<Lesson> findByDayAndTime(String day, Date time);
}
