package models;

import exceptions.CarNotParkedException;
import exceptions.InvalidTokenException;
import exceptions.NoVacantParkingSpaceException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aakash on 7/29/2015.
 */
public class ParkingAttendent {

    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public void attendToLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public Token park(Car c) {
        ParkingLot parkingLot = getParkingLotWithNoAddedFunctionality();
        Token token = new Token(parkingLot,parkingLot.park(c));
        return token;
    }

    public void unPark(Token token) {
        ParkingLot parkingLot = token.getParkingLot();
        parkingLot.unPark(token.getParkingSpaceID());
    }

    public ParkingLot getParkingLotWithNoAddedFunctionality() {
        for(ParkingLot p : parkingLots) {
            if(p.hasVacantSpace()) {
                return p;
            }
        }
        throw new NoVacantParkingSpaceException("No Vacant Space Available");
    }
}
