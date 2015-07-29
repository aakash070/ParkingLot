package models;

import strategies.Events;
import strategies.SubscriptionStrategy;

/**
 * Created by aakash on 7/27/2015.
 */
public class FBIAgent implements ParkingLotObserver{

    public void onNotification(Events notification) {

    }

    public void onFull() {

    }

    public void onVacant() {

    }

    public boolean apply(int parkedCars, int capacity) {
        return false;
    }
}
