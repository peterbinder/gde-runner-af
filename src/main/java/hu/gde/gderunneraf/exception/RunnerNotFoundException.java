package hu.gde.gderunneraf.exception;

public class RunnerNotFoundException extends RuntimeException {
    public RunnerNotFoundException(Long runnerId) {
        super("Runner not found with id: " + runnerId);
    }
}
