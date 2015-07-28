package models;

import notifications.Notifications;

/**
 * Created by aakash on 7/27/2015.
 */
public interface ParkingLotObserver {

    public void onNotification(Notifications notification);

}
