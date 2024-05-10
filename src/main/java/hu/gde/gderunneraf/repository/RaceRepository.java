package hu.gde.gderunneraf.repository;

import hu.gde.gderunneraf.domain.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
}
