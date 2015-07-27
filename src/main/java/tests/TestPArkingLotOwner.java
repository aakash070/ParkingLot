package tests;

import models.ParkingLotOwner;

/**
 * Created by aakash on 7/27/2015.
 */
public class TestParkingLotOwner extends ParkingLotOwner{

    boolean flag = false;

    public TestParkingLotOwner(){
        super();
    }

    @Override
    public void onFull() {
        flag= true;
    }
}
