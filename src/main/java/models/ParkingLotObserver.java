package models;

import strategies.Events;

/**
 * Created by aakash on 7/27/2015.
 */
public interface ParkingLotObserver {

    public void onNotification(Events notification);

}
