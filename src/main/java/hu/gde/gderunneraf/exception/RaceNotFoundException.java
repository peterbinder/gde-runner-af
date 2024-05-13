package hu.gde.gderunneraf.exception;

public class RaceNotFoundException extends RuntimeException {
    public RaceNotFoundException(Long raceId) {
        super("Race not found with id: " + raceId);
    }
}
