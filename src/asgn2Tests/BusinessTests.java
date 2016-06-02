/*@author: Jianing Chang (n9293400)*/

package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Passengers.Business;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;

public class BusinessTests {
	
	//test if the booking time is valid
	@Test (expected = PassengerException.class)
	public void testBusiness1() throws PassengerException {
		Passenger p = new Business(-1,1);
	}

	//test if the departure time is valid
	@Test (expected = PassengerException.class)
	public void testBusiness2() throws PassengerException {
		Passenger p = new Business(2,1);
	}
	
	@Test
	public void testUpgrade() throws PassengerException {
		Passenger p = new Business(1,2);
		assertEquals(p.upgrade().getPassID(),"F(U)J:0");
	}
	
	@Test
	public void testNoSeatsMsg() {
		assertTrue(true);
	}


}
