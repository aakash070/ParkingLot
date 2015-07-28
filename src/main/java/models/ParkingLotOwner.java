package models;

import notifications.Notifications;

/**
 * Created by aakash on 7/27/2015.
 */
public class ParkingLotOwner implements ParkingLotObserver{

    private int id;

    public ParkingLotOwner(){

    }

    public ParkingLotOwner(int id) {
        this.id = id;
    }

    public void onNotification(Notifications notification) {

    }

    public void onFull(){

    }

   public void onVacant() {

    }


}
