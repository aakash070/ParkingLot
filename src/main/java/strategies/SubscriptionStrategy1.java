package strategies;

/**
 * Created by aakash on 7/28/2015.
 */
public class SubscriptionStrategy1 implements SubscriptionStrategy{
    public boolean apply(Events events) {
        if(events.getEventCode()==1 || events.getEventCode() == 2)
            return true;
        return false;
    }
}
