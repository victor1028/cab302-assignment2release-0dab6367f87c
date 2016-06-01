/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import asgn2Passengers.Business;
import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.Premium;

/**
 * Class to support logging for the Aircraft Simulator
 * 
 * [Initially supplied incomplete to allow compilation of the Aircraft class]
 *  
 * @author hogan
 *
 */
public class Log {
	BufferedWriter writer = null;
	
	/**
	 * Constructor establishes a log file based on the current time in the canonical directory 
	 * @throws IOException if log file  or BufferedWriter cannot be created
	 */
	public Log () throws IOException {
		//File management based on http://stackoverflow.com/questions/15754523/how-to-write-text-file-java 
        File logFile = new File(getLogTime());

        // This will output the full path where the file will be written to...
        System.out.println(logFile.getCanonicalPath());
        this.writer = new BufferedWriter(new FileWriter(logFile));
	}
	
	/**
	 * Helper to set Passenger transition messages
	 * 
	 * @param p <code>Passenger</code> making a transition (uses F,J,P,Y)
	 * @param source <code>String</code> holding starting state (uses N,Q,C) - {New,Queued,Confirmed}
	 * @param target <code>String</code> holding finishing state (uses Q,C,R,F) - (Queued,Confirmed,Refused,Flown)
	 * @return <code>String</code> containing transition in the form: |(F|J|P|Y):(N|Q|C)>(Q|C|R|F)| 
	 */
	public static String setPassengerMsg(Passenger p,String source, String target) {
		String str="";
		if (p instanceof First) {
			str += "F";
		} else if (p instanceof Business) {
			str += "J";
		} else if (p instanceof Premium) {
			str += "P";
		} else {
			str += "Y";
		}
		return "|"+str+":"+source+">"+target+"|";
	}
	
	/**
	 * Helper to set Passenger upgrade messages. 
	 * 
	 * @param p <code>Passenger</code> to be upgraded 
	 * @return <code>String</code> containing transition in the form: |(J|P|Y)>(F|J|P)| 
	 */
	public static String setUpgradeMsg(Passenger p) {
		String str="";
		if (p instanceof Business) {
			str += "J>F";
		} else if (p instanceof Premium) {
			str += "P>J";
		} else {
			str += "Y>P";
		}
		return "|U:"+str+"|";
	}
	
	/**
	 * Helper returning Log Time format for filename
	 * @return filename String yyyyMMdd_HHmmss
	 */
	private String getLogTime() {
		String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timeLog;
	}

}
