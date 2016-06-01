/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Aircraft;


/**
 * Specialisation of the {@link asgn2Aircraft.Aircraft} class for the Boeing B747-400. 
 * Default passenger capacities are based on the QANTAS four class configuration 
 * 
 * @author hogan
 *
 */
public class B747 extends Aircraft {
	
	static final int FIRST = 14;
	static final int BUSINESS = 52;
	static final int PREMIUM = 32;
	static final int ECONOMY = 255;

	/**
	 * Constructor for B747 uses default fare class capacities 
	 * 
	 * 
	 * @param flightCode <code>String</code> containing flight ID 
	 * @param departureTime <code>int</code> scheduled departure time
	 * @throws AircraftException if invalid parameters. 
	 * See {@link asgn2Aircraft.Aircraft#Aircraft(String, int, int, int, int, int)}
	 */
	public B747(String flightCode,int departureTime) throws AircraftException {
		//Call here 
		this.type = "B747";
	}

	/**
	 * Constructor for B747 sets all fare class capacities 
	 * 
	 * @see asgn2Aircraft.Aircraft#Aircraft(String, int, int, int, int, int) 
	 */
	public B747(String flightCode,int departureTime,int first, int business, int premium, int economy) throws AircraftException {
		//Call here 
		this.type = "B747";
	}

}
