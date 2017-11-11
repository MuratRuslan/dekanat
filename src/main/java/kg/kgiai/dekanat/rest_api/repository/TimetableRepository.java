package kg.kgiai.dekanat.rest_api.repository;

import kg.kgiai.dekanat.rest_api.model.Gruppa;
import kg.kgiai.dekanat.rest_api.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    List<Timetable> findByDayAndGruppaOrderByTime(String day, Gruppa gruppa);
    List<Timetable> findByDay(String day);
}
