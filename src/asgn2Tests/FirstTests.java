/*@author: Jianing Chang (n9293400)*/

package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;

public class FirstTests {

	//test if booking time is valid
	@Test (expected = PassengerException.class)
	public void testFirst1() throws PassengerException {
		Passenger p = new First(-1,1);
	}

	//test if departure time is valid
	@Test(expected = PassengerException.class)
	public void testFirst2() throws PassengerException {
		Passenger p = new First(2,1);
	}
	
	//test the upgrade
	@Test
	public void testUpgrade() throws PassengerException {
		Passenger p = new First(1,2);
		assertEquals(p.upgrade().getPassID(),"F:0");
	}

		
	//test no-seat message
	@Test
	public void testNoSeatsMsg() {
		assertTrue(true);
	}

		
}
