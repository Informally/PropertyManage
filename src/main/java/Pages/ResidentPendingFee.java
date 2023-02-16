package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ResidentPendingFee {

	public JFrame rpf;
	public CRUD crud = new CRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResidentPendingFee window = new ResidentPendingFee();
					window.rpf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResidentPendingFee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rpf = new JFrame();
		rpf.setTitle("Resident Pending Fee");
		rpf.setBounds(100, 100, 871, 622);
		rpf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rpf.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Resident Pending Fee");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rpf.getContentPane().add(lblNewLabel);
                
                // Report
		JLabel lblReport = new JLabel("Report: ");
		lblReport.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblReport.setBounds(44, 73, 315, 42);
		rpf.getContentPane().add(lblReport);

		JComboBox<String> reportOptions = new JComboBox<>();
		reportOptions.setBounds(120, 73, 250, 42);
		reportOptions.addItem("Room Payment");
		reportOptions.addItem("Monthly Payment");
                reportOptions.addItem("Facility Payment");
		rpf.getContentPane().add(reportOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 450);
		rpf.getContentPane().add(scroll);

		reportOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) reportOptions.getSelectedItem()) {
				case "Room Payment":
					ArrayList<ArrayList<String>> pendingData = crud.read("BookingRoom.txt");

		                        String pendingReport = "\t\t<----- Room Pending Fee ----->\n";
		
		                        for (ArrayList<String> row : pendingData) {
			                if(Integer.parseInt(row.get(5)) > 0) {
			                pendingReport += "\tPending ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice\n\t---------------\t\t\t-------\n" + "\tRoom" + "\t\t\t" + row.get(3) + "\n" + "\tDeposit" + "\t\t\t" + row.get(4) + "\n" + "\t---------------------------------------------------------------\n\tOutstanding" + "\t\t\t" + row.get(5) + "\n"+ "\tPending fee for " + row.get(6) + " " + row.get(7) + "\n\t---------------------------------------------------------------" + "\n\n" + "\t\t<----- Room Pending Fee ----->\n";
			                }
		                        }

		                        textArea.setText(pendingReport);
					break;
				case "Monthly Payment":
					ArrayList<ArrayList<String>> monthlyData = crud.read("MonthlyPayment.txt");

		                        String monthlyReport = "\t\t<----- Monthly Pending Fee ----->\n";
		
		                        for (ArrayList<String> row : monthlyData) {
			                if(Integer.parseInt(row.get(3)) > 0) {
			                monthlyReport += "\tPending ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice\n\t---------------\t\t\t-------\n" + "\tRoom Type(" + row.get(1) + ")\n" + "\tRoom Price" + "\t\t\t" + row.get(2) + "\n" + "\t---------------------------------------------------------------\n\tOutstanding" + "\t\t\t" + row.get(3) + "\n"+ "\tPending fee for " + row.get(4) + " " + row.get(5) + "\n\t---------------------------------------------------------------" + "\n\n" + "\t\t<----- Monthly Pending Fee ----->\n";
			                }
		                        }

		                        textArea.setText(monthlyReport);
					break;
                                 
                                case "Facility Payment":
					ArrayList<ArrayList<String>> facilityData = crud.read("FacilityBooking.txt");

		                        String facilityReport = "\t\t<----- Facility Pending Fee ----->\n";
		
		                        for (ArrayList<String> row : facilityData) {
			                if(Integer.parseInt(row.get(5)) > 0) {
			                facilityReport += "\tPending ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice\n\t---------------\t\t\t-------\n" + "\tFacility" + "\t\t\t" + row.get(4) + "\n" + "\tDuration" + "\t\t\t" + row.get(5) + "\n" + "\t---------------------------------------------------------------\n\tOutstanding" + "\t\t\t" + row.get(6) + "\n"+ "\tPending fee for " + row.get(7) + " " + row.get(7) + "\n\t---------------------------------------------------------------" + "\n\n" + "\t\t<----- Facility Pending Fee ----->\n";
			                }
		                        }

		                        textArea.setText(facilityReport);
					break;        
				
				}

			}
		});

		// Back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResidentPaymentHistoryMenu resPayHis = new ResidentPaymentHistoryMenu();
				resPayHis.rphm.setVisible(true);
				rpf.setVisible(false);

			}
		});
		rpf.getContentPane().add(backBtn);

	}
}
