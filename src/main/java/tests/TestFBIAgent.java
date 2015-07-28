package tests;

import models.ParkingLotObserver;
import notifications.Notifications;

/**
 * Created by aakash on 7/27/2015.
 */
public class TestFBIAgent implements ParkingLotObserver {
    boolean isFull = false;
    boolean isVacant = true;

    public TestFBIAgent(){
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

    public void onNotification(Notifications notification) {
        if(notification.getNotificationCode()==1)
            onFull();
        else
            onVacant();
    }

}
