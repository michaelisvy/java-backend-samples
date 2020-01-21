package samples.validation;

public class MissingDataException extends RuntimeException {

    public MissingDataException(String message) {
        super(message);
    }
}
