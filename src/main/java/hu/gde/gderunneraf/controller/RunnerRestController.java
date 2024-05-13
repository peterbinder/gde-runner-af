package hu.gde.gderunneraf.controller;

import hu.gde.gderunneraf.dto.RaceDTO;
import hu.gde.gderunneraf.dto.ResultDTO;
import hu.gde.gderunneraf.dto.RunnerDTO;
import hu.gde.gderunneraf.dto.RunnerResultDTO;
import hu.gde.gderunneraf.service.RunnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RunnerRestController {

    private final RunnerService runnerService;

    @GetMapping("/getRunners")
    public List<RunnerDTO> getAllRunners() {
        return runnerService.getAllRunners();
    }

    @PostMapping("/addRunner")
    public RunnerDTO addRunner(@RequestBody RunnerDTO runner) {
        return runnerService.createRunner(runner);
    }

    @GetMapping("/getRaceRunners/{raceId}")
    public List<RunnerResultDTO> getRaceRunners(@PathVariable Long raceId) {
        return runnerService.findAllRunnerResultByRace(raceId);
    }

    @PostMapping("/updateRace")
    public RaceDTO updateRace(@RequestBody RaceDTO raceDTO) {
        return runnerService.updateRace(raceDTO);
    }

    @PostMapping("/addResult")
    public RunnerResultDTO addResult(@RequestBody ResultDTO resultDTO) {
        return runnerService.addResult(resultDTO);
    }

    @GetMapping("/getAverageTime/{raceId}")
    public double getAverageTime(@PathVariable Long raceId) {
        return runnerService.getAverageTime(raceId);
    }
}
