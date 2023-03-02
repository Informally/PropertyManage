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

public class ResidentReceipt extends PageUtils{

	public JFrame rr;
	public CRUD crud = new CRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResidentReceipt window = new ResidentReceipt();
					window.rr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResidentReceipt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rr = new JFrame();
		rr.setTitle("Resident Receipt");
		rr.setBounds(100, 100, 871, 622);
		rr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rr.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Resident Receipt");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rr.getContentPane().add(lblNewLabel);
                
                // Receipt
		JLabel lblReport = new JLabel("Report: ");
		lblReport.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblReport.setBounds(44, 73, 315, 42);
		rr.getContentPane().add(lblReport);

		JComboBox<String> reportOptions = new JComboBox<>();
		reportOptions.setBounds(120, 73, 250, 42);
		reportOptions.addItem("Room Payment");
		reportOptions.addItem("Monthly Payment");
                reportOptions.addItem("Facility Payment");
		rr.getContentPane().add(reportOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 450);
		rr.getContentPane().add(scroll);

		reportOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) reportOptions.getSelectedItem()) {
				case "Room Payment":
					ArrayList<ArrayList<String>> pendingData = crud.read("RoomReceipt.txt");

		                        String pendingReport = "\t\t<----- Room Receipt ----->\n";
		
		                        for (ArrayList<String> row : pendingData) {
			                pendingReport += "\tPayment ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice(RM)\n\t---------------\t\t\t-----------\n" + "\tName\t\t\t(" + row.get(1) + ")\n" + "\tRoom Type\t\t\t(" + row.get(2) + ")\n" + "\tRoom Price" + "\t\t\t" + row.get(3) + "\n" + "\tDeposit" + "\t\t\t" + row.get(4) + "\n" + "\t---------------------------------------------------------------\n\tTotal Paid" + "\t\t\t" + row.get(5) + "\n"+ "\tPayment for " + row.get(6) + " " + row.get(7) + "\n" + "\tDate Paid " + row.get(8) + "\n\t---------------------------------------------------------------" + "\n" + "\t                  Thank you for your payment\n\n" + "\t\t<----- Room Receipt ----->\n";
			                
		                        }

		                        textArea.setText(pendingReport);
					break;
				case "Monthly Payment":
					ArrayList<ArrayList<String>> monthlyData = crud.read("MonthlyReceipt.txt");

		                        String monthlyReport = "\t\t<----- Monthly Receipt ----->\n";
		
		                        for (ArrayList<String> row : monthlyData) {
			                monthlyReport += "\tPayment ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice(RM)\n\t---------------\t\t\t-----------\n" + "\tName\t\t\t(" + row.get(1) + ")\n" + "\tRoom Type\t\t\t(" + row.get(2) + ")\n" + "\tRoom Price" + "\t\t\t" + row.get(3) + "\n" + "\t---------------------------------------------------------------\n\tTotal Paid" + "\t\t\t" + row.get(4) + "\n"+ "\tPayment for " + row.get(5) + " " + row.get(6) + "\n" + "\tDate Paid " + row.get(7) + "\n\t---------------------------------------------------------------" + "\n" + "\t                  Thank you for your payment\n\n" + "\t\t<----- Monthly Receipt ----->\n";
			                
		                        }

		                        textArea.setText(monthlyReport);
					break;
                                 
                                case "Facility Payment":
					ArrayList<ArrayList<String>> facilityData = crud.read("FacilityReceipt.txt");

		                        String facilityReport = "\t\t<----- Facility Receipt ----->\n";
		
		                        for (ArrayList<String> row : facilityData) {
			                facilityReport += "\tPayment ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice(RM)\n\t---------------\t\t\t-----------\n" + "\tName\t\t\t(" + row.get(1) + ")\n" + "\tFacility Type\t\t\t(" + row.get(2) + ")\n" + "\tFacility Price" + "\t\t\t" + row.get(3) + "\n" + "\tDuration" + "\t\t\t" + row.get(4) + "\n" + "\t---------------------------------------------------------------\n\tTotal Paid" + "\t\t\t" + row.get(5) + "\n"+ "\tPayment for " + row.get(6) + " " + row.get(7) + "\n" + "\tDate Paid " + row.get(8) + "\n\t---------------------------------------------------------------" + "\n" + "\t                  Thank you for your payment\n\n" + "\t\t<----- Facility Receipt ----->\n";
			                
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
				setOriginalFrame(rr);
				setTargetedFrame(resPayHis.rphm);
				navigatePage();

			}
		});
		rr.getContentPane().add(backBtn);

	}
}
