package models;


import exceptions.CarAlreadyParkedException;
import exceptions.CarNotParkedException;
import exceptions.ParkingFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParkingLot {

   private  List<ParkingLotObserver> parkingLotObserverList = new ArrayList<ParkingLotObserver>();
    private AtomicInteger counter = new AtomicInteger(0);
    private int CAPACITY = 2;
    private Map<Integer, Car> parkingSpace = new ConcurrentHashMap<Integer, Car>();

    public ParkingLot(int capacity, ParkingLotObserver parkingLotOwner){
        parkingLotObserverList.add(parkingLotOwner);
        this.CAPACITY = capacity;
    }

    public List<ParkingLotObserver> getParkingLotObserverList() {
        return parkingLotObserverList;
    }

    public void register(ParkingLotObserver parkingLotObserver) {
        parkingLotObserverList.add(parkingLotObserver);
    }
    public int park(Car c){
        if(parkingSpace.containsValue(c))
            throw new CarAlreadyParkedException("Car already Parked");

        if(parkingSpace.keySet().size() == CAPACITY) {
            for(ParkingLotObserver p: parkingLotObserverList)
                p.onFull();
//            throw new ParkingFullException("Parking full");
        }

        parkingSpace.put(counter.get(), c);
        return counter.getAndIncrement();
    }


    public Car unPark(int token) {

        Car c = parkingSpace.remove(token);
        if(c==null)
            throw new CarNotParkedException();
        if(parkingSpace.keySet().size() == CAPACITY-1)
            for(ParkingLotObserver p: parkingLotObserverList)
                p.onVacant();
        return c;
    }
}
