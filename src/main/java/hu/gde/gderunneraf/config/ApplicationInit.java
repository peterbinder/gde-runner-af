package hu.gde.gderunneraf.config;

import hu.gde.gderunneraf.domain.Race;
import hu.gde.gderunneraf.domain.Result;
import hu.gde.gderunneraf.domain.Runner;
import hu.gde.gderunneraf.repository.RaceRepository;
import hu.gde.gderunneraf.repository.RunnerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class ApplicationInit {

    private final RaceRepository raceRepository;
    private final RunnerRepository runnerRepository;

    @Transactional
    @PostConstruct
    public void createData() {
        List<Race> raceList = createRaces();
        List<Runner> runners = createRunners();
        createResults(raceList, runners);
    }

    private void createResults(List<Race> raceList, List<Runner> runners) {
        Random random = new Random();
        raceList.forEach(
                race -> {
                    runners.forEach(runner ->
                            race.addResult(
                                    new Result(runner, race, random.nextInt(120)))
                    );
                }
        );

        raceRepository.saveAll(raceList);
    }

    private List<Runner> createRunners() {
        List<Runner> runnerList = new ArrayList<>();
        runnerList.add(new Runner("Alice Johnson", 25, "Female"));
        runnerList.add(new Runner("Bob Smith", 30, "Male"));
        runnerList.add(new Runner("Carol Evans", 28, "Female"));
        runnerList.add(new Runner("Dave Brown", 35, "Male"));
        runnerList.add(new Runner("Eve Green", 32, "Female"));

        return runnerRepository.saveAll(runnerList);
    }

    private List<Race> createRaces() {
        List<Race> raceList = new ArrayList<>();
        raceList.add(new Race("Marathon", 42));
        raceList.add(new Race("Half-Marathon", 21));
        raceList.add(new Race("10K Run", 10));
        raceList.add(new Race("5K Run", 5));
        raceList.add(new Race("Sprint", 2));

        return raceRepository.saveAll(raceList);
    }

}
