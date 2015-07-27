package models;

/**
 * Created by aakash on 7/27/2015.
 */
public interface ParkingLotObserver {

    public void onFull();
    public void onVacant();

}
