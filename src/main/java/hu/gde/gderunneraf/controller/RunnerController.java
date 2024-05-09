package hu.gde.gderunneraf.controller;

import hu.gde.gderunneraf.dto.RaceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RunnerController {

    @GetMapping(path = "/")
    public String home(Model model) {
        model.addAttribute("test", "Ez egy teszt");
        return "home";
    }

    @GetMapping(path = "/races")
    public String showRaces(Model model) {

        List<RaceDTO> raceList = Arrays.asList(
                new RaceDTO(1l, "Race 1", 10),
                new RaceDTO(2l, "Race 2", 20),
                new RaceDTO(3l, "Race 3", 40),
                new RaceDTO(4l, "Race 4", 35),
                new RaceDTO(5l, "Race 5", 120)
        );

        model.addAttribute("raceList", raceList);
        return "races";
    }

}
