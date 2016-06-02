/**
 * @author Wai Tai Chong n9291695
 * @author Jianing Chang n9293400
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import asgn2Aircraft.AircraftException;
import asgn2Aircraft.Bookings;
import asgn2Passengers.PassengerException;


/**
 * @author hogan
 *
 */
@SuppressWarnings("serial")
public class GUISimulator extends JFrame implements Runnable {

	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public GUISimulator(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public GUISimulator(){
		initComponents();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new GUISimulator().setVisible(true);

	}

	//components of the GUI
	private javax.swing.JTextArea area;
    private javax.swing.JButton chart1;
    private javax.swing.JButton chart2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton run;
    private javax.swing.JTextField textField_1;
    private javax.swing.JTextField textField_2;
    private javax.swing.JTextField textField_3;
    private javax.swing.JTextField textField_4;
    private javax.swing.JTextField textField_5;
    private javax.swing.JTextField textField_6;
    private javax.swing.JTextField textField_7;
    private javax.swing.JTextField textField_8;
	private Simulator sim;
	private Log log; 
	
	//method to create a GUI
	private void initComponents() {
		//create the components of the GUI
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textField_4 = new javax.swing.JTextField();
        textField_2 = new javax.swing.JTextField();
        textField_3 = new javax.swing.JTextField();
        textField_1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textField_5 = new javax.swing.JTextField();
        textField_6 = new javax.swing.JTextField();
        textField_7 = new javax.swing.JTextField();
        textField_8 = new javax.swing.JTextField();
        run = new javax.swing.JButton();
        chart1 = new javax.swing.JButton();
        chart2 = new javax.swing.JButton();
        
        //close the window
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //definitions of the components of the GUI
        panel.setLayout(new java.awt.BorderLayout());

        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Simulation");

        jLabel2.setText("Fare Classes");

        jLabel3.setText("Operation");

        jLabel4.setText("Daily Mean");

        jLabel5.setText("RNG Seed");

        jLabel6.setText("Queue Size");

        jLabel7.setText("Cancellation");

        jLabel8.setText("First");

        jLabel9.setText("Business");

        jLabel10.setText("Premium");

        jLabel11.setText("Economy");

        //"run" button's action listener
        run.setText("Run Simulation");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					runActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        //"chart1" button's action listener
        chart1.setText("Show Chart 1");
        chart1.setEnabled(false);
        chart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chart1ActionPerformed(evt);
            }
        });

        //"chart2" button's action listener
        chart2.setText("Show Chart 2");
        chart2.setEnabled(false);
        chart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chart2ActionPerformed(evt);
            }
        });
        
        //layout and all components of the GUI
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textField_2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(textField_1)
                            .addComponent(textField_3)
                            .addComponent(textField_4))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textField_6)
                                    .addComponent(textField_5)
                                    .addComponent(textField_7)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField_8, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textField_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(textField_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textField_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textField_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textField_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textField_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textField_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textField_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    } 
		
	//"run" button's action
	private void runActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                    
        // TODO add your handling code here:
		
		//create a log
		log = new Log();
		
		//get the contents input by user
		String txt1 = textField_1.getText().trim();
		String txt2 = textField_2.getText().trim();
		String txt3 = textField_3.getText().trim();
		String txt4 = textField_4.getText().trim();
		String txt5 = textField_5.getText().trim();
		String txt6 = textField_6.getText().trim();
		String txt7 = textField_7.getText().trim();
		String txt8 = textField_8.getText().trim();
		//regular expression used to check whether users input the valid values or not
		String regex = "^[0]+(.[0-9]+)?$";
		String regex1 = "^[0-9]*[1-9][0-9]*$";
		String regex2 = "^[0-9]+(.[0-9]+)?$";
		
		//check whether users input a valid value or not
		if(!txt1.matches(regex1)){
			JOptionPane.showMessageDialog(panel, "Invaild seed value, please check the number you input");
			textField_1.setText("");
			textField_1.requestFocus();
			return;
		}
		if(!txt2.matches(regex2)){
			JOptionPane.showMessageDialog(panel, "Invaild mean value, please check the number you input");
			textField_2.setText("");
			textField_2.requestFocus();
			return;
		}
		if(!txt3.matches(regex1)){
			JOptionPane.showMessageDialog(panel,"Invaild Queue size, please check the number you input");
			textField_3.setText("");
			textField_3.requestFocus();
			return;
		}
		if(!txt4.matches(regex)){
			JOptionPane.showMessageDialog(panel, "Invaild cancellation probability, please check the number you input");
			textField_4.setText("");
			textField_4.requestFocus();
			return;
		}
		if(!txt5.matches(regex)){
			JOptionPane.showMessageDialog(panel, "Invaild first class probability, please check the number you input");
			textField_5.setText("");
			textField_5.requestFocus();
			return;
		}
		if(!txt6.matches(regex)){
			JOptionPane.showMessageDialog(panel, "Invaild business class probability, please check the number you input");
			textField_6.setText("");
			textField_6.requestFocus();
			return;
		}
		if(!txt7.matches(regex)){
			JOptionPane.showMessageDialog(panel, "Invaild premium class probability, please check the number you input");
			textField_7.setText("");
			textField_7.requestFocus();
			return;
		}
		if(!txt8.matches(regex)){
			JOptionPane.showMessageDialog(panel, "Invaild economy class probability, please check the number you input");
			textField_8.setText("");
			textField_8.requestFocus();
			return;
		}
		
		//convert the values input by users to integers and decimal numbers
		int seed = Integer.parseInt(txt1);
		int queue_size = Integer.parseInt(txt3);
		double mean = Double.parseDouble(txt2);
		double cancellation = Double.parseDouble(txt4);
		double first = Double.parseDouble(txt5);
		double business = Double.parseDouble(txt6);
		double premium = Double.parseDouble(txt7);
		double economy = Double.parseDouble(txt8);
		
		
		try {
			//get the data and initialize the log
			sim = new Simulator(seed,queue_size,mean,0.33*mean,first,business,premium,economy,cancellation);
			sim.createSchedule();
			log.initialEntry(sim);
			
			String result = "";
			String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss: ").format(Calendar.getInstance().getTime());
			result += timeLog + ": Start of Simulation"+"\n";
			String string = sim.toString();
			result += string + "\n";
			String capacities = sim.getFlights(Constants.FIRST_FLIGHT).initialState();
			result += "\n" + capacities + "\n";
			
			//run the simulation from start to finish and get the info for each day
			for (int time = 0; time <= Constants.DURATION; time++) {
				sim.resetStatus(time); 
				sim.rebookCancelledPassengers(time); 
				sim.generateAndHandleBookings(time);
				sim.processNewCancellations(time);
				if (time >= Constants.FIRST_FLIGHT) {
					sim.processUpgrades(time);
					sim.processQueue(time);
					sim.flyPassengers(time);
					sim.updateTotalCounts(time);
					log.logFlightEntries(time, sim);
				} else {
					sim.processQueue(time);
				}
				//Log progress 
				log.logQREntries(time, sim);
				log.logEntry(time,sim);
				
				//get the result
				result += sim.getSummary(time, time>= Constants.FIRST_FLIGHT);
				
			}

			//get data and show log on text area
			result += "\n"+ timeLog + ": End of Simulation"+"\n";
			String total = sim.finalState(); 
			result += total;
			area.setText(result);
			chart1.setEnabled(true);
			chart2.setEnabled(true);
			
		} catch (SimulationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AircraftException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PassengerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
        

	//"chart1" button's action
    private void chart1ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String date = "";
		
		//get the contents input by users
		String txt1 = textField_1.getText().trim();
		String txt2 = textField_2.getText().trim();
		String txt3 = textField_3.getText().trim();
		String txt4 = textField_4.getText().trim();
		String txt5 = textField_5.getText().trim();
		String txt6 = textField_6.getText().trim();
		String txt7 = textField_7.getText().trim();
		String txt8 = textField_8.getText().trim();
		
		//convert the values to integers and decimal numbers
		int seed = Integer.parseInt(txt1);
		double mean = Double.parseDouble(txt2);
		int queue_size = Integer.parseInt(txt3);
		double cancellation = Double.parseDouble(txt4);
		double first = Double.parseDouble(txt5);
		double business = Double.parseDouble(txt6);
		double premium = Double.parseDouble(txt7);
		double economy = Double.parseDouble(txt8);
		
		try {
			//get data and create simulator schedule
			sim = new Simulator(seed,queue_size,mean,0.33*mean,first,business,premium,economy,cancellation);
			sim.createSchedule();
			
			//initialize the data
			int num_economy = 0;
			int num_business = 0;
			int num_premium = 0;
			int num_first = 0;
			int num_total = 0;
			int num_available = 0;
			
			//run the simulation from start to finish and get the info for each day
			for (int time = 0; time <= Constants.DURATION; time++) {
				sim.resetStatus(time); 
				sim.rebookCancelledPassengers(time); 
				sim.generateAndHandleBookings(time);
				sim.processNewCancellations(time);
				if (time >= Constants.FIRST_FLIGHT) {
					sim.processUpgrades(time);
					sim.processQueue(time);
					sim.flyPassengers(time);
					sim.updateTotalCounts(time);
					Flights flights = sim.getFlights(time);
					Bookings counts = flights.getCurrentCounts();
					num_economy = counts.getNumEconomy();
					num_premium = counts.getNumPremium();
					num_business = counts.getNumBusiness();
					num_first = counts.getNumFirst();
					num_total = counts.getTotal();
					num_available = counts.getAvailable();
				} else {
					sim.processQueue(time);
				}
				//get the day.（show all numbers which are the multiples of 7）
				if(time % 7 == 0){
					date = String.valueOf(time);
				}
				//add the data
				dataset.addValue(num_economy,"Economy",date);
				dataset.addValue(num_premium,"Premium",date);
				dataset.addValue(num_business,"Business",date);
				dataset.addValue(num_first,"First",date);
				dataset.addValue(num_total,"Total",date);
				dataset.addValue(num_available,"Available",date);
			}

			//create a chart
			JFreeChart chart = ChartFactory.createLineChart(
		            "Simulation Results 1",    // chart title
		            "Day",                     // domain axis label
		            "Passengers",              // range axis label
		            dataset,                   // data
		            PlotOrientation.VERTICAL,  // orientation
		            true,                      // include legend
		            true,                      // tooltips
		            false                      // urls
		        );
			ChartPanel chartPanel = new ChartPanel(chart);
			
			//remove the scroll panel and text area so that chart can be showed on GUI
			panel.removeAll();
			//add chart panel
	        panel.add(chartPanel,BorderLayout.CENTER);
	        panel.validate();
					
		} catch (SimulationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AircraftException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PassengerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    }                                      

    private void chart2ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String date = "";
		
		//get the contents input by user
		String txt1 = textField_1.getText().trim();
		String txt2 = textField_2.getText().trim();
		String txt3 = textField_3.getText().trim();
		String txt4 = textField_4.getText().trim();
		String txt5 = textField_5.getText().trim();
		String txt6 = textField_6.getText().trim();
		String txt7 = textField_7.getText().trim();
		String txt8 = textField_8.getText().trim();
		
		//convert the contents input by user to integer and decimal number
		int seed = Integer.parseInt(txt1);
		double mean = Double.parseDouble(txt2);
		int queue_size = Integer.parseInt(txt3);
		double cancellation = Double.parseDouble(txt4);
		double first = Double.parseDouble(txt5);
		double business = Double.parseDouble(txt6);
		double premium = Double.parseDouble(txt7);
		double economy = Double.parseDouble(txt8);
		
		try {
			//get data and create simulator schedule
			sim = new Simulator(seed,queue_size,mean,0.33*mean,first,business,premium,economy,cancellation);
			sim.createSchedule();
			
			//initialize the data
			int num_queue = 0;
			int num_refused = 0;
			//run the simulation from start to finish and get the info for each day
			for (int time = 0; time <= Constants.DURATION; time++) {
				sim.resetStatus(time); 
				sim.rebookCancelledPassengers(time); 
				sim.generateAndHandleBookings(time);
				sim.processNewCancellations(time);
				if (time >= Constants.FIRST_FLIGHT) {
					sim.processUpgrades(time);
					sim.processQueue(time);
					sim.flyPassengers(time);
					sim.updateTotalCounts(time);
					num_queue = sim.numInQueue();
					num_refused = sim.numRefused();
					
				} else {
					sim.processQueue(time);
				}
				
				//get the day.（show all numbers which are the multiples of 7）
				if(time % 7 == 0){
					date = String.valueOf(time);
				}
				//add data
				dataset.addValue(num_queue,"Queue",date);
				dataset.addValue(num_refused,"Refused",date);
			}

			//create a chart
			JFreeChart chart = ChartFactory.createLineChart(
		            "Simulation Results 2",    // chart title
		            "Day",                     // domain axis label
		            "Passengers",              // range axis label
		            dataset,                   // data
		            PlotOrientation.VERTICAL,  // orientation
		            true,                      // include legend
		            true,                      // tooltips
		            false                      // urls
		        );
			
			//create a chart panel
			ChartPanel chartPanel = new ChartPanel(chart);
			//remove the scroll pane and the text so that the chart can be showed
			panel.removeAll();
			//add the chart
	        panel.add(chartPanel,BorderLayout.CENTER);
	        panel.validate();
					
		} catch (SimulationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AircraftException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PassengerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    }
    
				
}
	


