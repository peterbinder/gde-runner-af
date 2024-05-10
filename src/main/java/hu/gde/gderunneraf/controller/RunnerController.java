package hu.gde.gderunneraf.controller;

import hu.gde.gderunneraf.dto.RaceDTO;
import hu.gde.gderunneraf.service.RunnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RunnerController {

    private final RunnerService runnerService;

    @GetMapping(path = "/")
    public String home(Model model) {
        model.addAttribute("test", "Ez egy teszt");
        return "home";
    }

    @GetMapping(path = "/races")
    public String showRaces(Model model) {

        List<RaceDTO> raceList = runnerService.findAllRace();

        model.addAttribute("raceList", raceList);
        return "races";
    }

}
