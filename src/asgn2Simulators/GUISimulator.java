/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


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

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUISimulator();

	}

	
	JFrame mFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	public GUISimulator(){
		mFrame = new JFrame();
		mFrame.setBounds(400, 200, 600, 500);
		
		JButton run = new JButton("Run Simulation");
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int txt1 = Integer.parseInt(textField.getText());
				String txt = textField.getText().trim();
				String txt1 = textField_1.getText().trim();
				String txt2 = textField_2.getText().trim();
				String txt3 = textField_3.getText().trim();
				String txt4 = textField_4.getText().trim();
				String txt5 = textField_5.getText().trim();
				String txt6 = textField_6.getText().trim();
				String txt7 = textField_7.getText().trim();
				//String regex = "\\d+";
				String regex = "^[0-9]+(.[0-9]+)?$";
				if(!txt.matches(regex)){
					JOptionPane.showMessageDialog(mFrame, "Invaild seed value, please check the number you input");
					textField.setText("");
					textField.requestFocus();
					return;
				}
				if(!txt1.matches(regex)){
					JOptionPane.showMessageDialog(mFrame, "Invaild mean value, please check the number you input");
					textField_1.setText("");
					textField_1.requestFocus();
					return;
				}
				if(!txt2.matches(regex)){
					JOptionPane.showMessageDialog(mFrame, "Invaild Queue size, please check the number you input");
					textField_2.setText("");
					textField_2.requestFocus();
					return;
				}
				if(!txt3.matches(regex)){
					JOptionPane.showMessageDialog(mFrame, "Invaild cancellation probability, please check the number you input");
					textField_3.setText("");
					textField_3.requestFocus();
					return;
				}
				if(!txt4.matches(regex)){
					JOptionPane.showMessageDialog(mFrame, "Invaild first class probability, please check the number you input");
					textField_4.setText("");
					textField_4.requestFocus();
					return;
				}
				if(!txt5.matches(regex)){
					JOptionPane.showMessageDialog(mFrame, "Invaild business class probability, please check the number you input");
					textField_5.setText("");
					textField_5.requestFocus();
					return;
				}
				if(!txt6.matches(regex)){
					JOptionPane.showMessageDialog(mFrame, "Invaild premium class probability, please check the number you input");
					textField_6.setText("");
					textField_6.requestFocus();
					return;
				}
				if(!txt7.matches(regex)){
					JOptionPane.showMessageDialog(mFrame, "Invaild economy class probability, please check the number you input");
					textField_7.setText("");
					textField_7.requestFocus();
					return;
				}
				
				int txt_0 = Integer.parseInt(txt);
				int txt_1 = Integer.parseInt(txt1);
				int txt_2 = Integer.parseInt(txt2);
				int txt_3 = Integer.parseInt(txt3);
				int txt_4 = Integer.parseInt(txt4);
				int txt_5 = Integer.parseInt(txt5);
				int txt_6 = Integer.parseInt(txt6);
				int txt_8 = Integer.parseInt(txt7);
				
				
			}
		});
		
		JLabel lblOperation = new JLabel("Operation");
		
		JButton show = new JButton("Show Chart");
		show.setEnabled(false);
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblSimulation = new JLabel("Simulation");
		
		JLabel lblFareClasses = new JLabel("Fare Classes");
		
		JLabel lblRngSeed = new JLabel("RNG Seed");
		
		JLabel lblDailyMean = new JLabel("Daily Mean");
		
		JLabel lblQueueSize = new JLabel("Queue Size");
		
		JLabel lblCancellation = new JLabel("Cancellation");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		
		JLabel lblFirst = new JLabel("First");
		
		JLabel lblBusiness = new JLabel("Business");
		
		JLabel lblPremium = new JLabel("Premium");
		
		JLabel lblEconomy = new JLabel("Economy");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(mFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCancellation)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblQueueSize)
								.addGap(18)
								.addComponent(textField_2, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblDailyMean)
								.addGap(18)
								.addComponent(textField_1, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblRngSeed, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSimulation)
							.addGap(57)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFirst)
									.addGap(18))
								.addComponent(lblBusiness)
								.addComponent(lblEconomy)
								.addComponent(lblPremium))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_6, 0, 0, Short.MAX_VALUE)
								.addComponent(textField_5, 0, 0, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
								.addComponent(textField_7, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(show, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(run, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(lblFareClasses)
							.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
							.addComponent(lblOperation)
							.addGap(84))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSimulation)
								.addComponent(lblFareClasses)
								.addComponent(lblOperation))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblFirst)
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblRngSeed))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDailyMean))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblQueueSize)
														.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblPremium)
													.addGap(40)))
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCancellation)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblEconomy)
												.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(80)
									.addComponent(lblBusiness)))
							.addGap(31))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(run, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(show, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(26))))
		);
		mFrame.getContentPane().setLayout(groupLayout);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setVisible(true);
	}
	

}
