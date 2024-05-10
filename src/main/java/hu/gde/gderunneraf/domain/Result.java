package hu.gde.gderunneraf.domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Runner runner;

    @ManyToOne
    private Race race;

    private int timeInMinutes;

    public Result(Runner runner, Race race, int timeInMinutes) {
        this.runner = runner;
        this.race = race;
        this.timeInMinutes = timeInMinutes;
    }
}
