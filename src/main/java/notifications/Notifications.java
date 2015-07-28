package notifications;

/**
 * Created by aakash on 7/28/2015.
 */
public enum Notifications {

    FULL(1), VACANT(2);

    private int notificationCode;

    Notifications(int notificationCode) {
       this.notificationCode  = notificationCode;
    }

    public int getNotificationCode(){
        return this.notificationCode;
    }
}
