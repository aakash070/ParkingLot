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
        int pLotNo = 0;
        Token token;
        for(ParkingLot p : parkingLots) {
            if(p.hasVacantSpace()) {
                token = new Token(pLotNo,p.park(c));
                return token;
            }
            pLotNo++;
        }
        throw new NoVacantParkingSpaceException("No Vacant Space Available");
    }

    public void unPark(Token token) {
        int pLotNo = 0;
        for(ParkingLot parkingLot : parkingLots) {
            if (pLotNo == token.getParkingLotID()){
                parkingLot.unPark(token.getParkingSpaceID());
                return;
            }
            pLotNo++;
        }
        throw new InvalidTokenException("Invalid Token Provided");
    }
}
