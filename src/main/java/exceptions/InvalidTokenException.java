package exceptions;

/**
 * Created by aakash on 7/29/2015.
 */
public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException(String message) {
        super(message);
    }
}
