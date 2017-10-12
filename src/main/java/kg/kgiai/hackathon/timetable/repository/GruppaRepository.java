package kg.kgiai.hackathon.timetable.repository;

import kg.kgiai.hackathon.timetable.model.Gruppa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruppaRepository extends JpaRepository<Gruppa, Long>{
}
