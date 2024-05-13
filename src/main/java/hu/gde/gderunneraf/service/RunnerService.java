package hu.gde.gderunneraf.service;

import hu.gde.gderunneraf.domain.Race;
import hu.gde.gderunneraf.dto.RaceDTO;
import hu.gde.gderunneraf.dto.RunnerResultDTO;
import hu.gde.gderunneraf.repository.RaceRepository;
import hu.gde.gderunneraf.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RunnerService {

    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

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

    public List<RunnerResultDTO> findAllRunnerResultByRace(Long raceId) {
        return resultRepository.findAllByRaceId(raceId)
                .stream()
                .map(RunnerResultDTO::new)
                .sorted(Comparator.comparing(RunnerResultDTO::getTimeInMinutes))
                .collect(Collectors.toList());
    }
}
