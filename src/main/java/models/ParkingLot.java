package models;


import exceptions.CarAlreadyParkedException;
import exceptions.CarNotParkedException;
import strategies.Events;
import strategies.SubscriptionStrategy;
import strategies.SubscriptionStrategy1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {

    private Map<ParkingLotObserver, SubscriptionStrategy> parkingLotObservers = new HashMap<ParkingLotObserver, SubscriptionStrategy>();
    private AtomicInteger counter = new AtomicInteger(0);
    private int CAPACITY = 2;
    private Map<Integer, Car> parkingSpace = new ConcurrentHashMap<Integer, Car>();

    public ParkingLot(int capacity, ParkingLotObserver parkingLotOwner){
        parkingLotObservers.put(parkingLotOwner, new SubscriptionStrategy1());
        this.CAPACITY = capacity;
    }


    public void subscribe(ParkingLotObserver parkingLotObserver, SubscriptionStrategy strategy) {
        parkingLotObservers.put(parkingLotObserver,strategy);
    }
    public int park(Car c){
        if(parkingSpace.containsValue(c))
            throw new CarAlreadyParkedException("Car already Parked");

        if(parkingSpace.keySet().size() < CAPACITY) {
            parkingSpace.put(counter.get(), c);
        }

        if(checkForEvent(parkingSpace.size())) {
            for(ParkingLotObserver p: parkingLotObservers.keySet()) {
                Events e = getEvent(parkingSpace.size());
                if(parkingLotObservers.get(p).apply(e))
                    p.onNotification(e);
            }
//            throw new ParkingFullException("Parking full");
        }

        return counter.getAndIncrement();
    }

    private boolean checkForEvent(int parkedCars) {
        if(parkedCars == CAPACITY || parkedCars == CAPACITY-1 ||
                (double)parkedCars == (double)CAPACITY*(double)0.8)
            return true;
        return false;
    }

    private Events getEvent(int parkedCars) {
        if(parkedCars == CAPACITY)
            return Events.FULL;
        else if(parkedCars == CAPACITY-1)
            return Events.VACANT;
        else
            return Events.EIGHTY;
    }

    public Car unPark(int token) {

        Car c = parkingSpace.remove(token);
        if(c==null)
            throw new CarNotParkedException();
/*        if(parkingSpace.keySet().size() == CAPACITY-1) {
            for(ParkingLotObserver p: parkingLotObservers)
                p.onNotification(Events.VACANT);}*/
        if(checkForEvent(parkingSpace.size())) {
            for(ParkingLotObserver p: parkingLotObservers.keySet()) {
                Events e = getEvent(parkingSpace.size());
                if(parkingLotObservers.get(p).apply(e))
                    p.onNotification(e);
            }
//            throw new ParkingFullException("Parking full");
        }

        return c;
    }

    public boolean hasVacantSpace() {
        if(parkingSpace.size()<CAPACITY-1)
            return true;
        return false;
    }
}
