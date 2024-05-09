package hu.gde.gderunneraf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RunnerController {

    @GetMapping(path = "/")
    public String home(Model model) {
        model.addAttribute("test", "Ez egy teszt");
        return "home";
    }

}
