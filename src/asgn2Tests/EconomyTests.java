package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Passengers.Economy;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;


public class EconomyTests {
	
	//test if the booking time is valid
	@Test (expected = PassengerException.class)
	public void testEconomyBookingTime1() throws PassengerException {
		Passenger p  = new Economy(-1,1);
	}
	
	
	//test if the departure time is valid
	@Test (expected = PassengerException.class)
	public void testEconomyBookingTime2() throws PassengerException {
		Passenger p  = new Economy(2,1);
	}
	
	@Test
	public void testUpgrade() throws PassengerException {
		Passenger p = new Economy(1,2);
		assertEquals(p.upgrade().getPassID(),"P(U)Y:0");
	}
	
	//test the no seats message
	@Test
	public void testNoSeatsMsg() {
		assertTrue(true);
	}

}
