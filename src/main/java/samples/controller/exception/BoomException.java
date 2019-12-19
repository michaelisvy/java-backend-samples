package samples.controller.exception;

public class BoomException extends RuntimeException {

    public BoomException(String message) {
        super(message);
    }
}
