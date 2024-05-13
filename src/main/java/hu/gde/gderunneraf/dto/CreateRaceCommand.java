package hu.gde.gderunneraf.dto;

import lombok.Data;

@Data
public class CreateRaceCommand {
    private String name;
    private int distanceInKm;
}
