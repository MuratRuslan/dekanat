package kg.kgiai.dekanat.rest_api.repository;


import kg.kgiai.dekanat.rest_api.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findById(Integer id);

    Room findByName(String name);
}
