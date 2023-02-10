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

public class VisitorEntry {

	public JFrame ve;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisitorEntry window = new VisitorEntry();
					window.ve.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisitorEntry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ve = new JFrame();
		ve.setTitle("Visitor Entry");
		ve.setBounds(100, 100, 871, 722);
		ve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ve.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Visitor Entry");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		ve.getContentPane().add(lblNewLabel);

		// UID
		JLabel lblUID = new JLabel("Entry ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		ve.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		ve.getContentPane().add(txtUID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		ve.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		ve.getContentPane().add(txtName);

		// Destination
		JLabel lblDestination = new JLabel("Destination: ");
		lblDestination.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDestination.setBounds(44, 123, 315, 42);
		ve.getContentPane().add(lblDestination);

		JTextField txtDestination = new JTextField();
		txtDestination.setBounds(164, 123, 250, 42);
		ve.getContentPane().add(txtDestination);

		// Contact
		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(434, 123, 315, 42);
		ve.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(554, 123, 250, 42);
		ve.getContentPane().add(txtContact);
		
		// Identity Card
		JLabel lblIc = new JLabel("Identity Card: ");
		lblIc.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblIc.setBounds(44, 173, 250, 42);
		ve.getContentPane().add(lblIc);

		JTextField txtIc = new JTextField();
		txtIc.setBounds(164, 173, 250, 42);
		ve.getContentPane().add(txtIc);

		// Date
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(434, 173, 315, 42);
		ve.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(554, 173, 250, 42);
		ve.getContentPane().add(txtDate);

		// Time in
		JLabel lblTimeIn = new JLabel("Time in: ");
		lblTimeIn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTimeIn.setBounds(44, 223, 250, 42);
		ve.getContentPane().add(lblTimeIn);

		JTextField txtTimeIn = new JTextField();
		txtTimeIn.setBounds(164, 223, 250, 42);
		ve.getContentPane().add(txtTimeIn);
		
		// Time out
		JLabel lblTimeOut = new JLabel("Time out: ");
		lblTimeOut.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTimeOut.setBounds(434, 223, 315, 42);
		ve.getContentPane().add(lblTimeOut);

		JTextField txtTimeOut = new JTextField();
		txtTimeOut.setBounds(554, 223, 250, 42);
		ve.getContentPane().add(txtTimeOut);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		ve.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("VisitorEntry.txt");
		String row[] = new String[8];
		String column[] = { "Entry ID", "Name", "Destination", "Contact", "Identity Card", "Date", "Time in", "Time out"};

		JTable jTable = new JTable();
		jTable.setBounds(44, 323, 770, 250);
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
			row[7] = tblData.get(i).get(7);
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
					txtDestination.setText((String) jTable.getValueAt(row[0], 2));
					txtContact.setText((String) jTable.getValueAt(row[0], 3));
					txtIc.setText((String) jTable.getValueAt(row[0], 4));
					txtDate.setText((String) jTable.getValueAt(row[0], 5));
					txtTimeIn.setText((String) jTable.getValueAt(row[0], 6));
					txtTimeOut.setText((String) jTable.getValueAt(row[0], 7));
				}

			}
			});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 373, 770, 250);
		ve.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		ve.getContentPane().add(calErrorText);

//		ListSelectionModel selectPayment = jTablePayment.getSelectionModel();
//		selectPayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		selectPayment.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent e) {
//				int[] row = jTablePayment.getSelectedRows();
//				int columnNum = jTablePayment.getColumnCount();
//
//				if (row.length > 0) {
//					HashMap<Integer, String> debtDt = crud.read("Payment.txt",
//							(String) jTablePayment.getValueAt(row[0], 5), 5, "", 0);
//					txtUID.setText((String) jTablePayment.getValueAt(row[0], 0));
//					txtName.setText((String) jTablePayment.getValueAt(row[0], 1));
//					txtDetail.setText((String) jTablePayment.getValueAt(row[0], 2));
//					txtContact.setText((String) jTablePayment.getValueAt(row[0], 3));
//					txtTimeIn.setText((String) jTablePayment.getValueAt(row[0], 4));
//					txtDestination.setText(debtDt.get(3));
//				}
//
//			}
//		});
		
		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(364, 323, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						
				String uid = txtUID.getText().trim();
						
				crud.delete("VisitorEntry.txt", uid, 0, "", 0);
						
				// Refresh the data in table
				tblData = crud.read("VisitorEntry.txt");
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
					row[7] = tblData.get(i).get(7);
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
				ve.getContentPane().add(deleteBtn);
		
		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 323, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtName.setText("");
				txtDestination.setText("");
				txtContact.setText("");
				txtIc.setText("");
				txtDate.setText("");
				txtTimeIn.setText("");
				txtTimeOut.setText("");
			}
		});
		ve.getContentPane().add(clearBtn);

		// Add user Btn
		JButton addUserBtn = new JButton("Save");
		addUserBtn.setBounds(44, 323, 150, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String entryId = txtUID.getText().trim();
				String name = txtName.getText().trim();
				String destination = txtDestination.getText().trim();
				String contact = txtContact.getText().trim();
				String ic = txtIc.getText().trim();
				String date = txtDate.getText().trim();
				String timeIn = txtTimeIn.getText().trim();
				String timeOut = txtTimeOut.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (entryId.isEmpty()) { // this means new data is added
				String uid = uuid.toString();
				data.add(uid);
				data.add(name);
				data.add(destination);
				data.add(contact);
				data.add(ic);
				data.add(date);
				data.add(timeIn);
				data.add(timeOut);

				crud.create("VisitorEntry.txt", data);
				}else {// this means update data
					data.add(entryId);
					data.add(name);
					data.add(destination);		
					data.add(contact);
					data.add(ic);
					data.add(date);
					data.add(timeIn);
					data.add(timeOut);
					crud.updateRow("VisitorEntry.txt", entryId, 0, "", 0, data);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtName.setText("");
				txtDestination.setText("");
				txtContact.setText("");
				txtIc.setText("");
				txtDate.setText("");
				txtTimeIn.setText("");
				txtTimeOut.setText("");

				// Refresh the data in table
				tblData = crud.read("VisitorEntry.txt");
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
					row[7] = tblData.get(i).get(7);
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
		ve.getContentPane().add(addUserBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecurityGuardMenu sg = new SecurityGuardMenu();
				sg.sg.setVisible(true);
				ve.setVisible(false);

			}
		});
		ve.getContentPane().add(backBtn);

	}

}
