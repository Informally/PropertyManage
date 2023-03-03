/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SecurityGuardReport extends PageUtils{

	public JFrame incReport;
	public CRUD crud = new CRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecurityGuardReport window = new SecurityGuardReport(null);
					window.incReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecurityGuardReport(String secname) {
		initialize(secname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String secname) {
		incReport = new JFrame();
		incReport.setTitle("View Report");
		incReport.setBounds(100, 100, 871, 622);
		incReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		incReport.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("View Report");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		incReport.getContentPane().add(lblNewLabel);

		// Report
		JLabel lblMonth = new JLabel("Report: ");
		lblMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblMonth.setBounds(44, 73, 315, 42);
		incReport.getContentPane().add(lblMonth);

		JComboBox<String> reportOptions = new JComboBox<>();
		reportOptions.setBounds(120, 73, 250, 42);
		reportOptions.addItem("Checkpoint Report");
		reportOptions.addItem("Incident Report");
		incReport.getContentPane().add(reportOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 450);
		incReport.getContentPane().add(scroll);

		reportOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) reportOptions.getSelectedItem()) {
				case "Checkpoint Report":
					ArrayList<ArrayList<String>> checkpointData = crud.read("Checkpoint.txt");

					String checkpointReport = "<----- Checkpoint Report ----->\n";

					for (ArrayList<String> row : checkpointData) {
						checkpointReport += "\nCheckpoint Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Location: " + row.get(2) + "\n" + "Contact: " + row.get(3) + "\n" + "Status: " + row.get(4) + "\n"+ "Date: " + row.get(5) + "\n"+ "Time in: " + row.get(6) + "\n"+ "Time outs: " + row.get(7) + "\n----------------------\n";

					}

					textArea.setText(checkpointReport);
					break;
				case "Incident Report":
					ArrayList<ArrayList<String>> incidentData = crud.read("Incident.txt");


					String incidentReport = "<----- Incident Report ----->\n";

					for (ArrayList<String> row : incidentData) {
						incidentReport += "\nIncident Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Location: " + row.get(2) + "\n" + "Contact: " + row.get(3) + "\n" + "Incident: " + row.get(4) + "\n"+ "Date: " + row.get(5) + "\n"+ "Time: " + row.get(6)
								+ "\n----------------------\n";

					}

					textArea.setText(incidentReport);
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
				SecIncident incident = new SecIncident(secname);
                                setOriginalFrame(incReport);
				setTargetedFrame(incident.inc);
				navigatePage();
			}
		});
		incReport.getContentPane().add(backBtn);

	}
}
