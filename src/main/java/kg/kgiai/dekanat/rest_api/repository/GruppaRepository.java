package kg.kgiai.dekanat.rest_api.repository;


import kg.kgiai.dekanat.rest_api.model.Gruppa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruppaRepository extends JpaRepository<Gruppa, Long> {
    Gruppa findByName(String name);
}
