package hu.gde.gderunneraf.dto;

import hu.gde.gderunneraf.domain.Race;
import hu.gde.gderunneraf.domain.Result;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RunnerResultDTO {
    private String raceName;
    private String name;
    private int age;
    private String gender;
    private int timeInMinutes;

    public RunnerResultDTO(Result result) {
        this.raceName = result.getRace().getName();
        this.name = result.getRunner().getName();
        this.age = result.getRunner().getAge();
        this.gender = result.getRunner().getGender();
        this.timeInMinutes = result.getTimeInMinutes();
    }
}
