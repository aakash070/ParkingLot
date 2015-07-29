package strategies;

/**
 * Created by aakash on 7/28/2015.
 */
public class SubscriptionStrategy2 implements SubscriptionStrategy{
    public boolean apply(Events events) {
        if(events.getEventCode() == 3)
            return true;
        return false;
    }
}
