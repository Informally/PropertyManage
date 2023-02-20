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

public class ViewPCJReport extends PageUtils {

	public JFrame Report;
	public CRUD crud = new CRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPCJReport window = new ViewPCJReport();
					window.Report.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewPCJReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Report = new JFrame();
		Report.setTitle("View Report");
		Report.setBounds(100, 100, 871, 650);
		Report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Report.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("View Report");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		Report.getContentPane().add(lblNewLabel);

		// Report Type
		JLabel lblReportType = new JLabel("Report Type: ");
		lblReportType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblReportType.setBounds(44, 73, 315, 42);
		Report.getContentPane().add(lblReportType);

		JComboBox<String> reportTypeOptions = new JComboBox<>();
		reportTypeOptions.setBounds(164, 73, 250, 42);
		reportTypeOptions.addItem("Patrolling Report");
		reportTypeOptions.addItem("Complaint Report");
		reportTypeOptions.addItem("Job Report");
		Report.getContentPane().add(reportTypeOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 450);
		Report.getContentPane().add(scroll);

		reportTypeOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) reportTypeOptions.getSelectedItem()) {
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
						jobreport += "\nEmployee Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Email: " + row.get(2) + "\n" + "Contact: " + row.get(3) + "\n" + "Age: " + row.get(4) + "\n" + "Job Role: " + row.get(5) +"\n----------------------\n";

					}

					textArea.setText(jobreport);
					break;
				}

			}
		});

		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuildingExecMenu Bem = new BuildingExecMenu();
				setOriginalFrame(Report);
				setTargetedFrame(Bem.buildExec);
				navigatePage();

			}
		});
		Report.getContentPane().add(backBtn);

	}
}
