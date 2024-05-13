package hu.gde.gderunneraf.domain;

import hu.gde.gderunneraf.dto.CreateRaceCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Race {


    public Race(String name, int distanceInKm) {
        this.name = name;
        this.distanceInKm = distanceInKm;
        this.results = new ArrayList<>();
    }

    public Race(CreateRaceCommand createRaceCommand) {
        this.name = createRaceCommand.getName();
        this.distanceInKm = createRaceCommand.getDistanceInKm();
        this.results = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int distanceInKm;

    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Result> results;

    public void addResult(Result result) {
        this.results.add(result);
    }
}
