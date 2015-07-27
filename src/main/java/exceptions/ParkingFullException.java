package exceptions;

public class ParkingFullException extends RuntimeException {

    public ParkingFullException(String msg){
        super(msg);
    }
}
