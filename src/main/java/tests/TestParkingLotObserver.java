package tests;

import models.ParkingLotObserver;
import strategies.Events;

/**
 * Created by aakash on 7/28/2015.
 */
public class TestParkingLotObserver implements ParkingLotObserver {

    boolean isFull = false;
    boolean isVacant = true;

    public TestParkingLotObserver(){
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

    public void onNotification(Events notification) {
        if(notification.getEventCode()==1)
            onFull();
        else
            onVacant();
    }
}
