package tests;

import exceptions.CarAlreadyParkedException;
import exceptions.CarNotParkedException;
import exceptions.ParkingFullException;
import models.Car;
import models.FBIAgent;
import models.ParkingLot;
import models.ParkingLotObserver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ParkingTest {

    ParkingLot parkingLot;
    TestParkingLotOwner testParkingLotOwner;

    TestFBIAgent testFBIAgent1;
    TestFBIAgent testFBIAgent2;

    @Before
    public void setUp(){

        testParkingLotOwner = new TestParkingLotOwner();
        parkingLot = new ParkingLot(5,testParkingLotOwner);

        testFBIAgent1 = new TestFBIAgent();
        testFBIAgent2 = new TestFBIAgent();

        parkingLot.register(testFBIAgent1);
        parkingLot.register(testFBIAgent2);

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

    @Test
    public void TestOwnerNotifiedWhenParkingFull(){
        parkingLot.park(new Car("2657", "hyundai"));
        parkingLot.park(new Car("157", "honda"));
        parkingLot.park(new Car("1259", "hyundai"));

        System.out.println(testParkingLotOwner.isFull);
        assertTrue(testParkingLotOwner.isFull);
    }

    @Test
    public void TestOwnerNotifiedWhenParkingFirstVacatedFromFull(){
        parkingLot.park(new Car("2657", "hyundai"));
        parkingLot.park(new Car("157", "honda"));
        parkingLot.unPark(4);

        assertTrue(testParkingLotOwner.isVacant);
    }

    @Test
    public void TestNotificationToOwnerAndMultipleFBIAgentsWhenParkingFull() {

        TestParkingLotOwner testParkingLotOwner = new TestParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(2,testParkingLotOwner);

        TestFBIAgent testFBIAgent1  = new TestFBIAgent();
        TestFBIAgent testFBIAgent2 = new TestFBIAgent();

        parkingLot.register(testFBIAgent1);
        parkingLot.register(testFBIAgent2);

        parkingLot.park(new Car("2657", "hyundai"));
        parkingLot.park(new Car("157", "honda"));
        parkingLot.park(new Car("1259", "hyundai"));

        assertTrue(testParkingLotOwner.isFull);
        assertTrue(testFBIAgent1.isFull);
        assertTrue(testFBIAgent2.isFull);
    }

    @Test
    public void TestNotificationToOwnerAndMultipleFBIAgentsWhenParkingFirstVacatedFromFull() {

        TestParkingLotOwner testParkingLotOwner = new TestParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(2,testParkingLotOwner);

        TestFBIAgent testFBIAgent1  = new TestFBIAgent();
        TestFBIAgent testFBIAgent2 = new TestFBIAgent();

        parkingLot.register(testFBIAgent1);
        parkingLot.register(testFBIAgent2);

        parkingLot.park(new Car("2657", "hyundai"));
        parkingLot.park(new Car("157", "honda"));
        parkingLot.unPark(1);

        assertTrue(testParkingLotOwner.isVacant);
        assertTrue(testFBIAgent1.isVacant);
        assertTrue(testFBIAgent2.isVacant);
    }
}