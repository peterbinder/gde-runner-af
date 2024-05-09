package hu.gde.gderunneraf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RaceDTO {
    private Long id;
    private String name;
    private int distanceInKm;
}
