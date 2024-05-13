package hu.gde.gderunneraf.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateRaceCommand {
    @NotBlank(message = "Race name cannot be blank")
    private String name;

    @NotNull(message = "Distance cannot be null")
    @Min(value = 1, message = "Distance must be at least 1 km")
    private Integer distanceInKm;
}
