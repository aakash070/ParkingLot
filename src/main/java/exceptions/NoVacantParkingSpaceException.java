package exceptions;

/**
 * Created by aakash on 7/29/2015.
 */
public class NoVacantParkingSpaceException extends RuntimeException {

    public NoVacantParkingSpaceException(String message) {
        super(message);
    }
}
