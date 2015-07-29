package tests;

import models.ParkingLotObserver;
import strategies.SubscriptionStrategy;
import strategies.Events;

/**
 * Created by aakash on 7/27/2015.
 */
public class TestFBIAgent implements ParkingLotObserver {
    boolean isEightyPercentFull = false;

    public TestFBIAgent(){
        super();
    }

    public void onNotification(Events notification) {
        if(notification.getEventCode()==3)
           isEightyPercentFull = true;
    }

}
