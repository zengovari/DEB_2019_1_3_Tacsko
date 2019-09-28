package Model.Error;

public class InvalidLocationError extends Exception{
    public InvalidLocationError() {
        super("Hibás helyszín");
    }
}
