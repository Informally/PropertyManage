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

public class GenReport extends PageUtils {

	public JFrame genReport;
	public CRUD crud = new CRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenReport window = new GenReport();
					window.genReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GenReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		genReport = new JFrame();
		genReport.setTitle("Generate Report");
		genReport.setBounds(100, 100, 700, 622);
		//set as non-resizable
		genReport.setResizable(false);
		genReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		genReport.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Generate Report");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 3, 665, 81);
		genReport.getContentPane().add(lblNewLabel);

		// Report Type
		JLabel lblReportType = new JLabel("Report Type: ");
		lblReportType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblReportType.setBounds(44, 73, 315, 42);
		genReport.getContentPane().add(lblReportType);

		JComboBox<String> reportTypeOptions = new JComboBox<>();
		reportTypeOptions.setBounds(164, 73, 250, 42);
		reportTypeOptions.addItem("Payment Report Resident/Tenant");
                reportTypeOptions.addItem("Payment Report Vendor");
		reportTypeOptions.addItem("User Report");
		reportTypeOptions.addItem("Patrolling Report");
                reportTypeOptions.addItem("Complaint Report");
                reportTypeOptions.addItem("Job Report");
		genReport.getContentPane().add(reportTypeOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 600, 450);

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 600, 450);
		genReport.getContentPane().add(scroll);

		reportTypeOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) reportTypeOptions.getSelectedItem()) {
				case "Payment Report Resident/Tenant":
					ArrayList<ArrayList<String>> paymentdata = crud.read("ResTenPaymentHistory.txt");

					String paymentreport = "<----- Payment Report Resident/Tenant ----->\n";
				
					for (ArrayList<String> row : paymentdata) {
						paymentreport += "\nPayment Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Details: " + row.get(2) + "\n" + "Pending: RM" + row.get(3) + "\n" + "Total Paid: RM" + row.get(4) + "\n" + "Outstanding: RM" + row.get(5) + "\n"+ "Charge ID: " + row.get(6) + "\n"+ "Date: " + row.get(7)+"\n------------------------------------------------"+"\n------------------------------------------------\n";


					}

					textArea.setText(paymentreport);
					break;
                
				case "Payment Report Vendor":
					ArrayList<ArrayList<String>> paymentdata2 = crud.read("PaymentHistory.txt");

					String paymentreport2 = "<----- Payment Report Vendor ----->\n";

					for (ArrayList<String> row : paymentdata2) {
						paymentreport2 += "\nPayment Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Details: " + row.get(2) + "\n" + "Pending: RM" + row.get(3) + "\n" + "Total Paid: RM" + row.get(4) + "\n" + "Outstanding: RM" + row.get(5) + "\n"+ "Charge ID: " + row.get(6) + "\n"+ "Date: " + row.get(7)+"\n------------------------------------------------"+"\n------------------------------------------------\n";
					}

					textArea.setText(paymentreport2);
					break;
				case "User Report":
					ArrayList<ArrayList<String>> userdata = crud.read("User.txt");

					String userreport = "<----- User Report ----->\n";

					for (ArrayList<String> row : userdata) {
						userreport += "\nUser Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Email: "
								+ row.get(2) + "\n" + "Age: " + row.get(4) + "\n" + "Role: " + row.get(5)
								+ "\n----------------------\n";

					}

					textArea.setText(userreport);
					break;
				case "Patrolling Report":
					ArrayList<ArrayList<String>> patroldata = crud.read("Patrol.txt");

					String patrolreport = "<---------- Patrolling Report ---------->\n";

					for (ArrayList<String> row : patroldata) {
						patrolreport += "\nEmployee Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Job Role: " + row.get(2) + "\n" + "Patrol Day: " + row.get(3) + "\n" + "Patrol Schedule: " + row.get(4) + "\n"+ "Checkpoint: " + row.get(5) + "\n----------------------\n";


					}

					textArea.setText(patrolreport);
					break;
                                case "Complaint Report":
					ArrayList<ArrayList<String>> residentdata = crud.read("ResidentComplaint.txt");
                                       
					String complaintreport = "<---------- Resident Complaint Report ---------->\n";
                                        

					for (ArrayList<String> row : residentdata) {
						complaintreport += "\nNo.: " + row.get(0) + "\n" + "User: " + row.get(1) + "\n" + "Name: "
								+ row.get(2) + "\n" + "Email: " + row.get(3) + "\n" + "Contact: " + row.get(4) 
                                                                + "\n" + "Status: " + row.get(5) + "\n"+ "Date: " + row.get(6) + "\n" + "Subject: " 
                                                                + row.get(7) + "\n"+ "Detail: " + row.get(8) +"\n----------------------\n";
                                                

					}

					//textArea.setText(complaintreport);
					//break;
                                        
                                        ArrayList<ArrayList<String>> vendordata = crud.read("VendorComplaint.txt");
                                                String complaintreport2 = "\n<---------- Vendor Complaint Report ---------->\n";
                                        

                                                for (ArrayList<String> row2 : vendordata) {
						complaintreport2 += "\nNo.: " + row2.get(0) + "\n" + "User: " + row2.get(1) + "\n" + "Name: "
								+ row2.get(2) + "\n" + "Email: " + row2.get(3) + "\n" + "Contact: " + row2.get(4) 
                                                                + "\n" + "Status: " + row2.get(5) + "\n"+ "Date: " + row2.get(6) + "\n" + "Subject: " 
                                                                + row2.get(7) + "\n"+ "Detail: " + row2.get(8) +"\n----------------------\n";

					}
                                                
                                        ArrayList<ArrayList<String>> adminExdata = crud.read("AdminExComplaint.txt");
                                                String complaintreport3 = "\n<---------- Admin Executive Complaint Report ---------->\n";
                                        

                                                for (ArrayList<String> row3 : adminExdata) {
						complaintreport3 += "\nNo.: " + row3.get(0) + "\n" + "User: " + row3.get(1) + "\n" + "Name: "
								+ row3.get(2) + "\n" + "Email: " + row3.get(3) + "\n" + "Contact: " + row3.get(4) 
                                                                + "\n" + "Status: " + row3.get(5) + "\n"+ "Date: " + row3.get(6) + "\n" + "Subject: " 
                                                                + row3.get(7) + "\n"+ "Detail: " + row3.get(8) +"\n----------------------\n";

					}

					textArea.setText(complaintreport + complaintreport2 + complaintreport3);
					break;
                                case "Job Report":
					ArrayList<ArrayList<String>> jobdata = crud.read("Employee.txt");

					String jobreport = "<---------- Employees Job Report ----------->\n";

					for (ArrayList<String> row : jobdata) {
						jobreport += "\nEmployee Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Email: " + row.get(2) + "\n" + "Contact: " + row.get(4) + "\n" + "Age: " + row.get(5) + "\n" + "Job Role: " + row.get(6) +"\n----------------------\n";

					}

					textArea.setText(jobreport);
					break;
				}

			}
		});

		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(400, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuildingManagerMenu bmm = new BuildingManagerMenu();
				setOriginalFrame(genReport);
				setTargetedFrame(bmm.bmm);
				navigatePage();

			}
		});
		genReport.getContentPane().add(backBtn);

	}
}
