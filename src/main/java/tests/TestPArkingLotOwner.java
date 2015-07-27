package tests;

import models.ParkingLotObserver;

/**
 * Created by aakash on 7/27/2015.
 */
public class TestParkingLotOwner implements ParkingLotObserver {

    boolean isFull = false;
    boolean isVacant = true;

    public TestParkingLotOwner(){
        super();
    }

    public void onFull() {
        isFull = true;
        isVacant = false;
    }

    public void onVacant() {
        isVacant = true;
        isFull = false;
    }
}
