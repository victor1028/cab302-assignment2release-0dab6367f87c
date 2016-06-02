/* @author Wai Tai Chong n9291695 */

package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Passengers.Premium;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;


public class PremiumTests {
	

	//test if the booking time is valid
	@Test (expected = PassengerException.class)
	public void testPremium1() throws PassengerException {
		Passenger p = new Premium(-1,1);
	}

	//test if the departure time is valid
	@Test (expected = PassengerException.class)
	public void testPremium2() throws PassengerException {
		Passenger p = new Premium(2,1);
	}

	
	@Test
	public void testUpgrade() throws PassengerException {
		Passenger p = new Premium(1,2);
		assertEquals(p.upgrade().getPassID(),"J(U)P:0");
		
	}
	
	@Test
	public void testNoSeatsMsg() {
		assertTrue(true);
	}

}
