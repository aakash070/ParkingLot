package models;

import strategies.Events;
import strategies.SubscriptionStrategy;

/**
 * Created by aakash on 7/27/2015.
 */
public class ParkingLotOwner implements ParkingLotObserver {

    private int id;

    public ParkingLotOwner(){

    }

    public ParkingLotOwner(int id) {
        this.id = id;
    }

    public void onNotification(Events notification) {

    }

    public void onFull(){

    }

   public void onVacant() {

    }


}
