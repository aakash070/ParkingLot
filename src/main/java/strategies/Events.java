package strategies;

/**
 * Created by aakash on 7/28/2015.
 */
public enum Events {

    FULL(1), VACANT(2), EIGHTY(3);

    private int eventCode;

    Events(int eventCode) {
       this.eventCode = eventCode;
    }

    public int getEventCode(){
        return this.eventCode;
    }

}
