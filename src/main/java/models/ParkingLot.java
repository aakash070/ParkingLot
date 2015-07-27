package models;


import exceptions.CarAlreadyParkedException;
import exceptions.CarNotParkedException;
import exceptions.ParkingFullException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {

    private AtomicInteger counter = new AtomicInteger(0);
    private int CAPACITY = 2;
    private Map<Integer, Car> parkingSpace = new ConcurrentHashMap<Integer, Car>();

    public ParkingLot(int capacity){
        this.CAPACITY = capacity;
    }

    public int park(Car c){
        if(parkingSpace.containsValue(c))
            throw new CarAlreadyParkedException("Car already Parked");

        if(parkingSpace.keySet().size() == CAPACITY)
            throw new ParkingFullException("Parking full");

        parkingSpace.put(counter.get(), c);
        return counter.getAndIncrement();
    }


    public Car unPark(int token) {

        Car c = parkingSpace.remove(token);
        if(c==null)
            throw new CarNotParkedException();

        return c;
    }
}
