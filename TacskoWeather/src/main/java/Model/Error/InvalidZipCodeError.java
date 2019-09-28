package Model.Error;

public class InvalidZipCodeError extends Exception{
    public InvalidZipCodeError() {
        super("Hibás irányítószám");
    }
}
