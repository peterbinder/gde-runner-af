package hu.gde.gderunneraf.service;

import hu.gde.gderunneraf.domain.Race;
import hu.gde.gderunneraf.dto.RaceDTO;
import hu.gde.gderunneraf.repository.RaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RunnerService {

    private final RaceRepository raceRepository;

    public Race createRace(String name, int distance) {
        Race race = new Race(name, distance);
        return raceRepository.save(race);
    }


    public List<RaceDTO> findAllRace() {
        return raceRepository.findAll()
                .stream()
                .map(RaceDTO::new)
                .collect(Collectors.toList());
    }
}
