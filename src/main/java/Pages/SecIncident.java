/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Data.User;
import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class SecIncident extends PageUtils {

	public JFrame inc;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecIncident window = new SecIncident(null);
					window.inc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecIncident(String secname) {
		initialize(secname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String secname) {
		inc = new JFrame();
		inc.setTitle("Incident");
		inc.setBounds(100, 100, 871, 822);
		inc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inc.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Incident");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		inc.getContentPane().add(lblNewLabel);
		
		// Incident ID
		JLabel lblUID = new JLabel("Incident ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		inc.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(174, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		inc.getContentPane().add(txtUID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(444, 73, 315, 42);
		inc.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(564, 73, 250, 42);
		inc.getContentPane().add(txtName);

		// Destination
		JLabel lblLocation = new JLabel("Location: ");
		lblLocation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblLocation.setBounds(44, 123, 315, 42);
		inc.getContentPane().add(lblLocation);

		JTextField txtLocation = new JTextField();
		txtLocation.setBounds(174, 123, 250, 42);
		inc.getContentPane().add(txtLocation);

		// Contact
		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(444, 123, 315, 42);
		inc.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(564, 123, 250, 42);
		inc.getContentPane().add(txtContact);
		
		// Incident
		JLabel lblIncident = new JLabel("Incident: ");
		lblIncident.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblIncident.setBounds(44, 173, 250, 42);
		inc.getContentPane().add(lblIncident);

		JTextField txtIncident = new JTextField();
		txtIncident.setBounds(174, 173, 250, 42);
		inc.getContentPane().add(txtIncident);

		// Date
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(444, 173, 315, 42);
		inc.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(564, 173, 250, 42);
		inc.getContentPane().add(txtDate);

		// Time
		JLabel lblTimeIn = new JLabel("Time: ");
		lblTimeIn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTimeIn.setBounds(44, 223, 250, 42);
		inc.getContentPane().add(lblTimeIn);

		JTextField txtTimeIn = new JTextField();
		txtTimeIn.setBounds(174, 223, 250, 42);
		inc.getContentPane().add(txtTimeIn);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		inc.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("Incident.txt");
		String row[] = new String[7];
		String column[] = { "Incident ID", "Name", "Location", "Contact", "Incident", "Date", "Time" };

		JTable jTable = new JTable();
		jTable.setBounds(44, 323, 770, 100);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setColumnIdentifiers(column);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData.size(); i++) {
			row[0] = tblData.get(i).get(0);
			row[1] = tblData.get(i).get(1);
			row[2] = tblData.get(i).get(2);
			row[3] = tblData.get(i).get(3);
			row[4] = tblData.get(i).get(4);
			row[5] = tblData.get(i).get(5);
			row[6] = tblData.get(i).get(6);
			tableModel.addRow(row);

		}
		jTable.setModel(tableModel);

		ListSelectionModel select = jTable.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row = jTable.getSelectedRows();
				int columnNum = jTable.getColumnCount();

				if (row.length > 0) {
					txtUID.setText((String) jTable.getValueAt(row[0], 0));
					txtName.setText((String) jTable.getValueAt(row[0], 1));
					txtLocation.setText((String) jTable.getValueAt(row[0], 2));
					txtContact.setText((String) jTable.getValueAt(row[0], 3));
					txtIncident.setText((String) jTable.getValueAt(row[0], 4));
					txtDate.setText((String) jTable.getValueAt(row[0], 5));
					txtTimeIn.setText((String) jTable.getValueAt(row[0], 6));
				}

			}
		});
		
		JLabel lblTableIncident = new JLabel("Incident Table");
		lblTableIncident.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblTableIncident.setBounds(44, 303, 770, 100);
		inc.getContentPane().add(lblTableIncident);
		
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 373, 770, 250);
		inc.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		inc.getContentPane().add(calErrorText);
		
		// View Btn
		JButton viewBtn = new JButton("View Report");
		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecurityGuardReport incidentReport = new SecurityGuardReport(secname);
				incidentReport.incReport.setVisible(true);
				inc.setVisible(false);
			}
		});
		viewBtn.setBounds(364, 273, 150, 42);
		viewBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		inc.getContentPane().add(viewBtn);
		
		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 273, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtName.setText("");
				txtLocation.setText("");
				txtContact.setText("");
				txtIncident.setText("");
				txtDate.setText("");
				txtTimeIn.setText("");
			}
		});
		inc.getContentPane().add(clearBtn);

		// Save Incident Btn
		JButton addUserBtn = new JButton("Save Incident");
		addUserBtn.setBounds(44, 273, 150, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String incidentId = txtUID.getText().trim();
				String name = txtName.getText().trim();
				String destination = txtLocation.getText().trim();
				String contact = txtContact.getText().trim();
				String incident = txtIncident.getText().trim();
				String date = txtDate.getText().trim();
				String timeIn = txtTimeIn.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (incidentId.isEmpty()) { // this means new data is added
					String uid = uuid.toString();
					data.add(uid);
					data.add(name);
					data.add(destination);
					data.add(contact);
					data.add(incident);
					data.add(date);
					data.add(timeIn);

					crud.create("Incident.txt", data);
					}else {// this means update data
						data.add(incidentId);
						data.add(name);
						data.add(destination);		
						data.add(contact);
						data.add(incident);
						data.add(date);
						data.add(timeIn);
						crud.updateRow("Incident.txt", incidentId, 0, "", 0, data);
					}

					// Clear text after update or add
					txtUID.setText("");
					txtName.setText("");
					txtLocation.setText("");
					txtContact.setText("");
					txtIncident.setText("");
					txtDate.setText("");
					txtTimeIn.setText("");

					// Refresh the data in table
					tblData = crud.read("Incident.txt");
					DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
					tableModel.setColumnIdentifiers(column);
					tableModel.getDataVector().removeAllElements();
					tableModel.fireTableDataChanged();
					jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					for (int i = 0; i < tblData.size(); i++) {
						row[0] = tblData.get(i).get(0);
						row[1] = tblData.get(i).get(1);
						row[2] = tblData.get(i).get(2);
						row[3] = tblData.get(i).get(3);
						row[4] = tblData.get(i).get(4);
						row[5] = tblData.get(i).get(5);
						row[6] = tblData.get(i).get(6);
						tableModel.addRow(row);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jTable.updateUI();
				}
			});
			inc.getContentPane().add(addUserBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecurityGuardMenu sg = new SecurityGuardMenu(secname);
                                setOriginalFrame(inc);
				setTargetedFrame(sg.sg);
				navigatePage();

			}
		});
		inc.getContentPane().add(backBtn);

	}

}
