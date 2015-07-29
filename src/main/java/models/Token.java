package models;

/**
 * Created by aakash on 7/29/2015.
 */
public class Token {
    private ParkingLot parkingLot;
    private int parkingSpaceID;

    public Token(ParkingLot parkingLot, int parkingSpaceID) {
        this.parkingLot = parkingLot;
        this.parkingSpaceID = parkingSpaceID;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public int getParkingSpaceID() {
        return parkingSpaceID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (parkingSpaceID != token.parkingSpaceID) return false;
        return !(parkingLot != null ? !parkingLot.equals(token.parkingLot) : token.parkingLot != null);

    }

    @Override
    public int hashCode() {
        int result = parkingLot != null ? parkingLot.hashCode() : 0;
        result = 31 * result + parkingSpaceID;
        return result;
    }
}
