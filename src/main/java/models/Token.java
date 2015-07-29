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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (parkingLotID != token.parkingLotID) return false;
        return parkingSpaceID == token.parkingSpaceID;

    }

    @Override
    public int hashCode() {
        int result = parkingLotID;
        result = 31 * result + parkingSpaceID;
        return result;
    }


    /*@Override
    public boolean equals(Object obj) {
        return this.parkingLotID==(Token)obj.getParkingLotID();
    }*/
}
