package tests;

import exceptions.CarAlreadyParkedException;
import exceptions.CarNotParkedException;
import exceptions.ParkingFullException;
import models.Car;
import models.ParkingLot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParkingTest {

    ParkingLot parkingLot;

    @Before
    public void setUp(){
        parkingLot = new ParkingLot(5);

        parkingLot.park(new Car("1234", "maruti"));
        parkingLot.park(new Car("12345", "audi"));
        parkingLot.park(new Car("123467", "honda"));

    }

    @org.junit.Test
    public void TestParkingWhenSpaceAvailable() throws Exception {
        Car c = new Car("1234456", "maruti");
        final int token = parkingLot.park(c);
        assertEquals(3, token);
    }

    @Test(expected = ParkingFullException.class)
    public void TestParkingWhenFull(){

        parkingLot.park(new Car("45646", "honda"));
        parkingLot.park(new Car("13465", "honda"));
        parkingLot.park(new Car("12657", "honda"));
    }


    @Test(expected = CarAlreadyParkedException.class)
    public void TestParkingCarWithSameRegNum(){
        Car c = new Car("1234", "maruti");
        parkingLot.park(c);
        parkingLot.park(c);
    }

    @Test
    public void TestUnparkWhenCarIsParked(){
        Car car = new Car("0987", "newCar");

        int token = parkingLot.park(car);

        assertEquals(car, parkingLot.unPark(token));
    }

    @Test(expected = CarNotParkedException.class)
    public void TestExceptionForUnparkWhenCarNotInParking(){
        parkingLot.unPark(100);
    }
}