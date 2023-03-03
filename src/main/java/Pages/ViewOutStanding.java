package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ViewOutStanding extends PageUtils {

	public JFrame viewOutStanding;
	public CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOutStanding window = new ViewOutStanding();
					window.viewOutStanding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewOutStanding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		viewOutStanding = new JFrame();
		viewOutStanding.setTitle("View Outstanding Fees Resident/Tenant");
		viewOutStanding.setBounds(100, 100, 871, 622);
		viewOutStanding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewOutStanding.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("View Outstanding Fees Resident/Tenant");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(34, 11, 665, 81);
		viewOutStanding.getContentPane().add(lblNewLabel);
                
                 // Report
		JLabel lblReport = new JLabel("Report: ");
		lblReport.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblReport.setBounds(44, 73, 315, 42);
		viewOutStanding.getContentPane().add(lblReport);

		JComboBox<String> reportOptions = new JComboBox<>();
		reportOptions.setBounds(120, 73, 250, 42);
		reportOptions.addItem("Monthly Payment");
        reportOptions.addItem("Facility Payment");
		viewOutStanding.getContentPane().add(reportOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);
		
                JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 450);
		viewOutStanding.getContentPane().add(scroll);

		reportOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) reportOptions.getSelectedItem()) {
				// case "Room Payment":
				// 	ArrayList<ArrayList<String>> pendingData = crud.read("BookingRoom.txt");

		        //                 String pendingReport = "\t\t<----- Room Pending Fee ----->\n";
		
		        //                 for (ArrayList<String> row : pendingData) {
			    //             if(Integer.parseInt(row.get(5)) > 0) {
			    //             pendingReport += "\tPending ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice(RM)\n\t---------------\t\t\t-----------\n" + "\tName" + "\t\t\t" + row.get(1) + "\n" + "\tRoom" + "\t\t\t" + row.get(3) + "\n" + "\tDeposit" + "\t\t\t" + row.get(4) + "\n" + "\t---------------------------------------------------------------\n\tOutstanding" + "\t\t\t" + row.get(5) + "\n"+ "\tPending fee for " + row.get(6) + "/" + row.get(7) + "\n\t---------------------------------------------------------------" + "\n\n" + "\t\t<----- Room Pending Fee ----->\n";
			    //             }
		        //                 }

		        //                 textArea.setText(pendingReport);
				// 	break;
				case "Monthly Payment":
					ArrayList<ArrayList<String>> monthlyData = crud.read("ResTenPendingFee.txt");

		                        String monthlyReport = "\t\t<--------- Monthly Pending Fee For Resident/Tenant--------->\n";
		
		                        for (ArrayList<String> row : monthlyData) {
									monthlyReport += "\nCharge ID: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Details: " + row.get(2) + "\n" + "Pending Fee: RM" + row.get(3) + "\n" + "Date: " +  row.get(4) + "\n" + "---------------------------------------------------------------"+ "\n---------------------------------------------------------------\n";
								}

		                        textArea.setText(monthlyReport);
					break;
                                 
                                case "Facility Payment":
					ArrayList<ArrayList<String>> facilityData = crud.read("FacilityBooking.txt");

		                        String facilityReport = "\t\t<----- Facility Pending Fee ----->\n";
		
		                        for (ArrayList<String> row : facilityData) {
			                if(Integer.parseInt(row.get(5)) > 0) {
			                facilityReport += "\tPending ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice(RM)\n\t---------------\t\t\t-----------\n" + "\tName" + "\t\t\t" + row.get(1) + "\n" + "\tFacility(" + row.get(2) + ")\t\t" + row.get(3) + "\n" + "\tDuration" + "\t\t\t" + row.get(4) + "\n" + "\t---------------------------------------------------------------\n\tOutstanding" + "\t\t\t" + row.get(5) + "\n"+ "\tPending fee for " + row.get(6) + "/" + row.get(7) + "\n\t---------------------------------------------------------------" + "\n\n" + "\t\t<----- Facility Pending Fee ----->\n";
			                }
		                        }

		                        textArea.setText(facilityReport);
					break;        
				
				}

			}
		});
                
		/*CRUD newCrud = new CRUD();
		tblData.clear();
		tblData = newCrud.read("MonthlyPaymentHistory.txt");
		String rowPayment[] = new String[9];
		String columnPayment[] = { "Id","Name" ,"Room Type" , "Outstanding", "Total Paid", "Month", "Year", "Payment ID", "Date"};

		JTable jTablePayment = new JTable();
		jTablePayment.setBounds(44, 73, 770, 100);
		DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
		tableModelPayment.setColumnIdentifiers(columnPayment);
		jTablePayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		System.out.print(tblData);

		for (int i = 0; i < tblData.size(); i++) {
			rowPayment[0] = tblData.get(i).get(0);
			rowPayment[1] = tblData.get(i).get(1);
			rowPayment[2] = tblData.get(i).get(2);
			rowPayment[3] = tblData.get(i).get(3);
			rowPayment[4] = tblData.get(i).get(4);
			rowPayment[5] = tblData.get(i).get(5);
			rowPayment[6] = tblData.get(i).get(6);
                        rowPayment[7] = tblData.get(i).get(7);
                        rowPayment[8] = tblData.get(i).get(8);
			tableModelPayment.addRow(rowPayment);

		}
		jTablePayment.setModel(tableModelPayment);

		
		JScrollPane scrollPayment = new JScrollPane(jTablePayment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPayment.setBounds(44, 73, 770, 100);
		viewOutStanding.getContentPane().add(scrollPayment);
		
		
		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 200, 770, 300);


		// Scroll
		JScrollPane scroll = new JScrollPane (textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 200, 770, 300);
		viewOutStanding.getContentPane().add(scroll);

		ListSelectionModel selectPayment = jTablePayment.getSelectionModel();
		selectPayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectPayment.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row = jTablePayment.getSelectedRows();
				int columnNum = jTablePayment.getColumnCount();
                                
				if (row.length > 0) {
                                
                                String uid = jTablePayment.getValueAt(row[0], 0).toString();
				String name = jTablePayment.getValueAt(row[0], 1).toString();
				String roomType = jTablePayment.getValueAt(row[0], 2).toString();
				String out = jTablePayment.getValueAt(row[0], 3).toString();
				String paid = jTablePayment.getValueAt(row[0], 4).toString();
				String Month = jTablePayment.getValueAt(row[0], 5).toString();
				String dtf = jTablePayment.getValueAt(row[0], 6).toString();

				String report = "<-------- Invoice for Outstanding payment -------->\n";
					
				report += "\n Payment ID: " + uid + "\n" + "Name: " + name + "\n" + "Room Type: " + roomType + "\n" + "Outstanding: " + out + "\n" + "Total Paid: " + paid + "\n" + "Month: " + Month + "\n" + "Date: " + dtf + "\n----------------------\n";
                                textArea.setText(report);

				}
				

			}
		}); */
		
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AccountExecMenu acctmenu = new AccountExecMenu();
				setOriginalFrame(viewOutStanding);
				setTargetedFrame(acctmenu.aem);
				navigatePage();

			}
		});
		viewOutStanding.getContentPane().add(backBtn);
		

	}
}
