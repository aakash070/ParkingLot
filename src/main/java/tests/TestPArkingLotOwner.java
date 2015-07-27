package tests;

import models.ParkingLotOwner;

/**
 * Created by aakash on 7/27/2015.
 */
public class TestParkingLotOwner extends ParkingLotOwner{

    boolean isFull = false;
    boolean isVacant = true;

    public TestParkingLotOwner(){
        super();
    }

    @Override
    public void onFull() {
        isFull = true;
        isVacant = false;
    }

    @Override
    public void onVacant() {
        isVacant = true;
        isFull = false;
    }
}
