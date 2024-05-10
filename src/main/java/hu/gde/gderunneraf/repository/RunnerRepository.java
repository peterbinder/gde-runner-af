package hu.gde.gderunneraf.repository;

import hu.gde.gderunneraf.domain.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Long> {
}
