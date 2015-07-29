package models;

/**
 * Created by aakash on 7/29/2015.
 */
public class Token {
    private int parkingLotID;
    private int parkingSpaceID;

    public Token(int parkingLotID, int parkingSpaceID) {
        this.parkingLotID = parkingLotID;
        this.parkingSpaceID = parkingSpaceID;
    }

    public int getParkingLotID() {
        return parkingLotID;
    }

    public int getParkingSpaceID() {
        return parkingSpaceID;
    }
}
