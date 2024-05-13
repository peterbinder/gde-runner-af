package hu.gde.gderunneraf.controller;

import hu.gde.gderunneraf.dto.CreateRaceCommand;
import hu.gde.gderunneraf.dto.RaceDTO;
import hu.gde.gderunneraf.dto.RaceResultDetailsDTO;
import hu.gde.gderunneraf.service.RunnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RunnerController {

    private final RunnerService runnerService;

    @GetMapping(path = "/")
    public String home() {

        return "home";
    }

    @GetMapping(path = "/races")
    public String showRaces(Model model) {

        List<RaceDTO> raceList = runnerService.findAllRace();
        model.addAttribute("raceList", raceList);

        return "races";
    }

    @GetMapping(path = "/races/{id}")
    public String showRaces(@PathVariable Long id, Model model) {

        RaceResultDetailsDTO runnerResults = runnerService.findResultDetailsByRaceId(id);
        model.addAttribute("raceName", runnerResults.getRaceName());
        model.addAttribute("runnerResults", runnerResults.getRunnerResults());

        return "race";
    }

    @GetMapping("/races/create-race")
    public String showCreateRaceForm(Model model) {

        model.addAttribute("createRaceCommand", new CreateRaceCommand());

        return "create-race";
    }

    @PostMapping(path = "/races/create-race")
    public String showRaces(@ModelAttribute(value = "createRaceCommand") @Valid CreateRaceCommand createRaceCommand) {

        runnerService.createRace(createRaceCommand);

        return "redirect:/races";
    }
}
