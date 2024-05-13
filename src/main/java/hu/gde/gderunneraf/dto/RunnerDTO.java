package hu.gde.gderunneraf.dto;

import hu.gde.gderunneraf.domain.Runner;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RunnerDTO {

    private Long id;
    private String name;
    private int age;
    private String gender;

    public RunnerDTO(Runner runner) {
        this.id = runner.getId();
        this.name = runner.getName();
        this.age = runner.getAge();
        this.gender = runner.getGender();
    }
}
