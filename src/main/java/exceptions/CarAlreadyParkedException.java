package exceptions;

public class CarAlreadyParkedException extends RuntimeException {
    public CarAlreadyParkedException(String msg) {
        super(msg);
    }
}
