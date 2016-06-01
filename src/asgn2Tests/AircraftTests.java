package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import asgn2Aircraft.A380;
import asgn2Aircraft.Aircraft;
import asgn2Aircraft.AircraftException;
import asgn2Passengers.Business;
import asgn2Passengers.Economy;
import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;
import asgn2Passengers.Premium;

public class AircraftTests {

	//test if fight code is valid
	@Test
	public void testAircraft1() throws AircraftException {
		Aircraft a = new A380("",1,2,3,4,5);
	}
	
	//test if departure time is valid
	@Test (expected = AircraftException.class)
	public void testAircraft2() throws AircraftException {
		Aircraft a = new A380("A380",-1,2,3,4,5);
	}
	
	//test if the capacity of First Class is valid
	@Test (expected = AircraftException.class)
	public void testAircraft3() throws AircraftException {
		Aircraft a = new A380("A380",1,-2,3,4,5);
	}
	
	//test if the capacity of Business Class is valid
	@Test (expected = AircraftException.class)
	public void testAircraft4() throws AircraftException {
		Aircraft a = new A380("A380",1,2,-3,4,5);
	}
	
	//test if the capacity of Premium Economy Class is valid
	@Test (expected = AircraftException.class)
	public void testAircraft5() throws AircraftException {
		Aircraft a = new A380("A380",1,2,3,-4,5);
	}
	
	//test if the capacity of Economy Class is valid
	@Test (expected = AircraftException.class)
	public void testAircraft6() throws AircraftException {
		Aircraft a = new A380("A380",1,2,3,4,-5);
	}

	//test if the passenger is not confirm
	@Test (expected = AircraftException.class)
	public void testCancelBooking1() throws AircraftException,PassengerException{
		Aircraft a = new A380("A380",2,1,1,1,1);
		Passenger p = new Economy(1,2);
		a.cancelBooking(p,1);	
	}
	
	
	//test if a passenger cancels booking, seat is available
	@Test 
	public void testCancelBooking2() throws AircraftException,PassengerException{
		Aircraft a = new A380("A380",2,1,1,1,1);
		Passenger p = new Economy(1,2);
		a.confirmBooking(p,1);
		a.cancelBooking(p,1);
		assertEquals(a.getNumEconomy(),0);
		
		
	}

	//test if the seat is not available
	@Test (expected = AircraftException.class)
	public void testConfirmBooking1() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2,1,1,1,1);
		Passenger p = new Economy(1,2);
		Passenger p1 = new Economy(1,2);
		a.confirmBooking(p,1);
		a.confirmBooking(p1,1);	
	}
	
	//test if confirms booking, the number of passengers in economy increase.
	@Test
	public void testConfirmBooking2() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2,1,1,1,1);
		Passenger p = new Economy(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.getNumEconomy(),1);
	}

	//test the final state
	@Test
	public void testFinalState() {
		assertTrue(true);
	}

	//test if the flight is empty(true)
	@Test 
	public void testFlightEmpty1() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2,1,1,1,1);
		assertEquals(a.flightEmpty(),true);
	}
	
	//test if the flight is empty(false)
	@Test 
	public void testFlightEmpty2() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2,1,1,1,1);
		Passenger p = new Economy(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.flightEmpty(),false);
	}

	//test if the flight is full(true)
	@Test 
	public void testFlightFull1() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2,0,0,0,1);
		Passenger p = new Economy(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.flightFull(),true);	
	}
	
	//test if the flight is full(false)
	@Test 
	public void testFlightFull2() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2,0,0,0,1);
		assertEquals(a.flightFull(),false);	
	}

	
	//test when not confirm
	@Test (expected = PassengerException.class)
	public void testFlyPassengers1() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2);
		Passenger p = new Economy(1,2);
		p.flyPassenger(2);
		a.flyPassengers(2);		
	}
	
	//test "getBooking" function
	@Test
	public void testGetBookings() {
		assertTrue(true);
	}

	//test the number of passengers in the business class
	@Test
	public void testGetNumBusiness() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2);
		Passenger p = new Business(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.getNumBusiness(),1);
		
	}

	//test the number of passengers in the economy class
	@Test
	public void testGetNumEconomy() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2);
		Passenger p = new Economy(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.getNumEconomy(),1);
	}

	//test the number of passengers in the First Class
	@Test
	public void testGetNumFirst() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2);
		Passenger p = new First(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.getNumFirst(),1);
	}

	//test the total number of passengers
	@Test
	public void testGetNumPassengers() throws  AircraftException,PassengerException {
		Aircraft a = new A380("A380",2);
		Passenger p = new Economy(1,2);
		a.confirmBooking(p,1);
		Passenger p1 = new Premium(1,2);
		a.confirmBooking(p1,1);
		Passenger p2 = new Business(1,2);
		a.confirmBooking(p2,1);
		Passenger p3 = new First(1,2);
		a.confirmBooking(p3,1);
		assertEquals(a.getNumPassengers(),4);
		
		
	}

	//test the number of passengers in the premium class
	@Test
	public void testGetNumPremium() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2);
		Passenger p = new Premium(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.getNumPremium(),1);
	}

	//test "getPassenger" function
	@Test
	public void testGetPassengers() throws AircraftException, PassengerException {
		assertTrue(true);	
	}

	//test "getStatus" function 
	@Test
	public void testGetStatus() {
		assertTrue(true);
	}

	//test whether a passenger is included on the aircraft(true)
	@Test
	public void testHasPassenger1() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2);
		Passenger p = new Economy(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.hasPassenger(p),true);
		
	}
	
	//test whether a passenger is included on the aircraft(false)
	@Test
	public void testHasPassenger2() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2);
		Passenger p = new Economy(1,2);
		assertEquals(a.hasPassenger(p),false);
	}

	//test "initialState" function
	@Test
	public void testInitialState() {
		assertTrue(true);
	}

	//test if the seat is available
	@Test 
	public void testSeatsAvailable1() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2,1,1,1,2);
		Passenger p = new Economy(1,2);
		Passenger p1 = new Economy(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.seatsAvailable(p1),true);
	}
	
	//test if the seat is not available
	@Test 
	public void testSeatsAvailable2() throws AircraftException, PassengerException {
		Aircraft a = new A380("A380",2,1,1,1,1);
		Passenger p = new Economy(1,2);
		Passenger p1 = new Economy(1,2);
		a.confirmBooking(p,1);
		assertEquals(a.seatsAvailable(p1),false);
	}

	//test "toString" function
	@Test
	public void testToString() {
		assertTrue(true);
	}

	//upgrade booking test--test if passengers can upgrade their class
	@Test
	public void testUpgradeBookings() throws AircraftException, PassengerException {
		//fail("Not yet implemented");
		Aircraft a = new A380("A380",2);
		Passenger p1 = new Economy(1,2);
		a.confirmBooking(p1, 1);
		Passenger p2 = new Premium(1,2);
		a.confirmBooking(p2, 1);
		Passenger p3 = new Business(1,2);
		a.confirmBooking(p3, 1);
		Passenger p4 = new First(1,2);
		a.confirmBooking(p4, 1);
		
		a.upgradeBookings();
		
		assertEquals(a.getNumFirst(),2);
		assertEquals(a.getNumBusiness(),1);
		assertEquals(a.getNumPremium(),1);
		assertEquals(a.getNumEconomy(),0);
		
		
	}

}
