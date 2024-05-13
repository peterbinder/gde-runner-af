package hu.gde.gderunneraf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RaceResultDetailsDTO {
    private String raceName;
    private List<RunnerResultDTO> runnerResults;
}
