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

public class ViewPCJReport {

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
		Report.setBounds(100, 100, 871, 622);
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

					String patrolreport = "<----- Patrol Report ----->\n";

					for (ArrayList<String> row : patroldata) {
						patrolreport += "\nEmployee Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Job Role: " + row.get(2) + "\n" + "Patrol Day: " + row.get(3) + "\n" + "Patrol Schedule: " + row.get(4) + "\n"+ "Checkpoint: " + row.get(5) + "\n----------------------\n";


					}

					textArea.setText(patrolreport);
					break;
				case "Complaint Report":
					ArrayList<ArrayList<String>> userdata = crud.read("User.txt");

					String userreport = "<----- User Report ----->\n";

					for (ArrayList<String> row : userdata) {
						userreport += "\nUser Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Email: "
								+ row.get(2) + "\n" + "Age: " + row.get(4) + "\n" + "Role: " + row.get(5)
								+ "\n----------------------\n";

					}

					textArea.setText(userreport);
					break;
				case "Job Report":
					ArrayList<ArrayList<String>> jobdata = crud.read("Employee.txt");

					String jobreport = "<----- Employees Job Report ----->\n";

					for (ArrayList<String> row : jobdata) {
						jobreport += "\n Employee Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Email: " + row.get(2) + "\n" + "Contact: " + row.get(3) + "\n" + "Age: " + row.get(4) + "\n" + "Job Role: " + row.get(5) +"\n----------------------\n";

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
				Bem.buildExec.setVisible(true);
				Report.setVisible(false);

			}
		});
		Report.getContentPane().add(backBtn);

	}
}