package hu.gde.gderunneraf.service;

import hu.gde.gderunneraf.domain.Race;
import hu.gde.gderunneraf.domain.Result;
import hu.gde.gderunneraf.domain.Runner;
import hu.gde.gderunneraf.dto.*;
import hu.gde.gderunneraf.exception.RaceNotFoundException;
import hu.gde.gderunneraf.exception.RunnerNotFoundException;
import hu.gde.gderunneraf.repository.RaceRepository;
import hu.gde.gderunneraf.repository.ResultRepository;
import hu.gde.gderunneraf.repository.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RunnerService {

    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    public Race createRace(CreateRaceCommand createRaceCommand) {
        Race race = new Race(createRaceCommand);
        return raceRepository.save(race);
    }

    public List<RaceDTO> findAllRace() {
        return raceRepository.findAll()
                .stream()
                .map(RaceDTO::new)
                .sorted(Comparator.comparing(RaceDTO::getId))
                .collect(Collectors.toList());
    }

    public List<RunnerResultDTO> findAllRunnerResultByRace(Long raceId) {
        return resultRepository.findAllByRaceId(raceId)
                .stream()
                .map(RunnerResultDTO::new)
                .sorted(Comparator.comparing(RunnerResultDTO::getTimeInMinutes))
                .collect(Collectors.toList());
    }

    public RaceResultDetailsDTO findResultDetailsByRaceId(Long raceId) {
        Optional<Race> race = raceRepository.findById(raceId);

        if (race.isPresent()) {
            return new RaceResultDetailsDTO(race.get().getName(), findAllRunnerResultByRace(raceId));
        }

        throw new RaceNotFoundException(raceId);
    }

    public List<RunnerDTO> getAllRunners() {
        return runnerRepository.findAll()
                .stream()
                .map(RunnerDTO::new)
                .collect(Collectors.toList());
    }

    public RunnerDTO createRunner(RunnerDTO createRunnerCommand) {
        Runner runner = new Runner(
                createRunnerCommand.getName(),
                createRunnerCommand.getAge(),
                createRunnerCommand.getGender());
        return new RunnerDTO(runnerRepository.save(runner));
    }

    public RaceDTO updateRace(RaceDTO raceDTO) {
        Race race = raceRepository.findById(raceDTO.getId())
                .orElseThrow(() -> new RaceNotFoundException(raceDTO.getId()));
        race.setName(raceDTO.getName());
        race.setDistanceInKm(raceDTO.getDistanceInKm());
        return new RaceDTO(raceRepository.save(race));
    }

    public RunnerResultDTO addResult(ResultDTO resultDTO) {
        Runner runner = runnerRepository.findById(resultDTO.getRunnerId())
                .orElseThrow(() -> new RunnerNotFoundException(resultDTO.getRunnerId()));
        Race race = raceRepository.findById(resultDTO.getRaceId())
                .orElseThrow(() -> new RaceNotFoundException(resultDTO.getRaceId()));

        Result result = new Result(runner, race, resultDTO.getTimeInMinutes());
        return new RunnerResultDTO(resultRepository.save(result));
    }

    public double getAverageTime(Long raceId) {
        List<Result> results = resultRepository.findAllByRaceId(raceId);
        return results.stream()
                .collect(Collectors.averagingInt(Result::getTimeInMinutes));
    }
}
