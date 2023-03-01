/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class SecVisitorEntry extends PageUtils {

	public JFrame ve;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();
	ArrayList<ArrayList<String>> tblData1 = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecVisitorEntry window = new SecVisitorEntry();
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
	public SecVisitorEntry() {
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

		// Pass ID
		JLabel lblUID = new JLabel("Pass ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		ve.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setEditable(false);
		ve.getContentPane().add(txtUID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		ve.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		txtName.setEditable(false);
		ve.getContentPane().add(txtName);

		// Destination
		JLabel lblDestination = new JLabel("Destination: ");
		lblDestination.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDestination.setBounds(44, 123, 315, 42);
		ve.getContentPane().add(lblDestination);

		JTextField txtDestination = new JTextField();
		txtDestination.setBounds(164, 123, 250, 42);
		txtDestination.setEditable(false);
		ve.getContentPane().add(txtDestination);

		// Contact
		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(434, 123, 315, 42);
		ve.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(554, 123, 250, 42);
		txtContact.setEditable(false);
		ve.getContentPane().add(txtContact);
		
		// Owner Name
		JLabel lblIc = new JLabel("Owner Name: ");
		lblIc.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblIc.setBounds(44, 173, 250, 42);
		ve.getContentPane().add(lblIc);

		JTextField txtIc = new JTextField();
		txtIc.setBounds(164, 173, 250, 42);
		txtIc.setEditable(false);
		ve.getContentPane().add(txtIc);

				// Owner Contact
				JLabel lblOwnerContact = new JLabel("Owner Contact: ");
				lblOwnerContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
				lblOwnerContact.setBounds(434, 173, 315, 42);
				ve.getContentPane().add(lblOwnerContact);
		
				JTextField txtOwnerContact = new JTextField();
				txtOwnerContact.setBounds(554, 173, 250, 42);
				txtOwnerContact.setEditable(false);
				ve.getContentPane().add(txtOwnerContact);

		// Date
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(44, 223, 315, 42);
		ve.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(164, 223, 250, 42);
		txtDate.setEditable(false);
		ve.getContentPane().add(txtDate);

		// Time in
		JLabel lblTimeIn = new JLabel("Time in: ");
		lblTimeIn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTimeIn.setBounds(434, 223, 250, 42);
		ve.getContentPane().add(lblTimeIn);

		JTextField txtTimeIn = new JTextField();
		txtTimeIn.setBounds(554, 223, 250, 42);
		ve.getContentPane().add(txtTimeIn);
		
		// Time out
		JLabel lblTimeOut = new JLabel("Time out: ");
		lblTimeOut.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTimeOut.setBounds(434, 273, 315, 42);
		ve.getContentPane().add(lblTimeOut);

		JTextField txtTimeOut = new JTextField();
		txtTimeOut.setBounds(554, 273, 250, 42);
		ve.getContentPane().add(txtTimeOut);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		ve.getContentPane().add(errorText);

		// Result Display 1
		tblData1 = crud.read("VisitorPass.txt");
		String row1[] = new String[8];
		String column1[] = { "Pass ID", "Visitor Name", "Destination", "Contact","Owner Name","Owner Contact", "Date", "Time in"};

		JTable jTable1 = new JTable();
		jTable1.setBounds(44, 323, 770, 150);
		DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
		tableModel1.setColumnIdentifiers(column1);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData1.size(); i++) {
			row1[0] = tblData1.get(i).get(0);
			row1[1] = tblData1.get(i).get(1);
			row1[2] = tblData1.get(i).get(2);
			row1[3] = tblData1.get(i).get(3);
			row1[4] = tblData1.get(i).get(6);
			row1[5] = tblData1.get(i).get(5);
            row1[6] = tblData1.get(i).get(4);
			row1[7] = tblData1.get(i).get(7);
			tableModel1.addRow(row1);

		}
		jTable1.setModel(tableModel1);

		ListSelectionModel select1 = jTable1.getSelectionModel();
		select1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row1 = jTable1.getSelectedRows();
				int columnNum1 = jTable1.getColumnCount();

				if (row1.length > 0) {
					txtUID.setText((String) jTable1.getValueAt(row1[0], 0));
					txtName.setText((String) jTable1.getValueAt(row1[0], 1));
					txtDestination.setText((String) jTable1.getValueAt(row1[0], 2));
					txtContact.setText((String) jTable1.getValueAt(row1[0], 3));
                    txtIc.setText((String) jTable1.getValueAt(row1[0], 4));
					txtOwnerContact.setText((String) jTable1.getValueAt(row1[0], 5));
					txtDate.setText((String) jTable1.getValueAt(row1[0], 6));
					txtTimeIn.setText((String) jTable1.getValueAt(row1[0], 7));
					txtTimeIn.setEditable(true);
					txtTimeOut.setText("");
					txtTimeOut.setEditable(true);
				}

			}
			});
		JScrollPane scroll1 = new JScrollPane(jTable1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll1.setBounds(44, 323, 770, 150);
		ve.getContentPane().add(scroll1);

		// Result Display 2
		tblData = crud.read("VisitorEntry.txt");
		String row[] = new String[8];
		String column[] = { "Pass ID", "Visitor Name", "Destination", "Contact", "Owner Name", "Date", "Time in", "Time out"};

		JTable jTable = new JTable();
		jTable.setBounds(44, 483, 770, 150);
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
					txtTimeIn.setEditable(false);
					txtTimeOut.setText((String) jTable.getValueAt(row[0], 7));
					txtTimeOut.setEditable(false);
				}

			}
			});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 483, 770, 150);
		ve.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		ve.getContentPane().add(calErrorText);
		
		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 273, 150, 42);
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

		// Save Btn
		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(44, 273, 150, 42);
		saveBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		saveBtn.addActionListener(new ActionListener() {

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
				//if all fields are empty
				if (entryId.isEmpty() && name.isEmpty() && destination.isEmpty() && contact.isEmpty() && ic.isEmpty() && date.isEmpty() && timeIn.isEmpty() && timeOut.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please select a Visitor Pass");

				}
				//if all fields are not empty except timeOut
				else if (!entryId.isEmpty() && !name.isEmpty() && !destination.isEmpty() && !contact.isEmpty() && !ic.isEmpty() && !date.isEmpty() && !timeIn.isEmpty() && timeOut.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter Time Out");

				}
				else {
					// read data from file
					ArrayList<ArrayList<String>> compareData = crud.read("VisitorEntry.txt");
					// check if entryId is the same as the value in compareData in position 0
					//System.out.println(compareData);
					for (int i = 0; i < compareData.size(); i++) {
						if (compareData.get(i).get(0).equals(entryId)) {
							System.out.println("Visitor already exist");
							JOptionPane.showMessageDialog(null,"Visitor already exited");
						}else{
							data.add(entryId);
							data.add(name);
							data.add(destination);		
							data.add(contact);
							data.add(ic);
							data.add(date);
							data.add(timeIn);
							data.add(timeOut);
							crud.create("VisitorEntry.txt", data);
						}
					}
				}

				// Clear text after update or add
				txtUID.setText("");
				txtName.setText("");
				txtDestination.setText("");
				txtContact.setText("");
				txtOwnerContact.setText("");
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
		ve.getContentPane().add(saveBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecurityGuardMenu sg = new SecurityGuardMenu();
                                setOriginalFrame(ve);
				setTargetedFrame(sg.sg);
				navigatePage();
				sg.sg.setVisible(true);
				ve.setVisible(false);

			}
		});
		ve.getContentPane().add(backBtn);

	}

}
