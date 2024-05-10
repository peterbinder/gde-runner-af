package hu.gde.gderunneraf.dto;

import hu.gde.gderunneraf.domain.Race;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RaceDTO {
    private Long id;
    private String name;
    private int distanceInKm;

    public RaceDTO(Race race) {
        this.id = race.getId();
        this.name = race.getName();
        this.distanceInKm = race.getDistanceInKm();
    }
}
