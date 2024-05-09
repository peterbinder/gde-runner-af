package hu.gde.gderunneraf.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int distanceInKm;

    @JoinColumn
    @OneToMany
    private List<Result> results;

}
