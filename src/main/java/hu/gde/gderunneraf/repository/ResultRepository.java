package hu.gde.gderunneraf.repository;

import hu.gde.gderunneraf.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findAllByRaceId(Long raceId);
}
