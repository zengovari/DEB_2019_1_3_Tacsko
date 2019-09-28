package Model.Error;

public class InvalidCoordinatesError extends Exception {
    public InvalidCoordinatesError() {
        super("Hibás koordináták");
    }
}
