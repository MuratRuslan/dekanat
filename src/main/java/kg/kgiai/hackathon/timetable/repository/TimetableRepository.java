package kg.kgiai.hackathon.timetable.repository;

import kg.kgiai.hackathon.timetable.model.Gruppa;
import kg.kgiai.hackathon.timetable.model.Room;
import kg.kgiai.hackathon.timetable.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    List<Timetable> findByDayAndGruppaOrderByTime(String day, Gruppa gruppa);
    List<Timetable> findAllByRoomAndTime(Room room, Date time);
}
