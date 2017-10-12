package kg.kgiai.hackathon.timetable.repository;

import kg.kgiai.hackathon.timetable.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    Room findById(Integer id);
}
