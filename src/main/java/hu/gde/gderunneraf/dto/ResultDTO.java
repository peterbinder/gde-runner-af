package hu.gde.gderunneraf.dto;

import lombok.Data;

@Data
public class ResultDTO {
    private Long runnerId;
    private Long raceId;
    private int timeInMinutes;
}
