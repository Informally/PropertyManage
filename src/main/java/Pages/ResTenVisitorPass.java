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
import javax.swing.JOptionPane;

public class ResTenVisitorPass extends PageUtils{

	public JFrame rtvp;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResTenVisitorPass window = new ResTenVisitorPass(null);
					window.rtvp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResTenVisitorPass(String restenname) {
		initialize(restenname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String restenname) {
                //String search = JOptionPane.showInputDialog(null, "Enter your name:");
		rtvp = new JFrame();
		rtvp.setTitle("Resident/Tenant Visitor Pass");
		rtvp.setBounds(100, 100, 871, 722);
		rtvp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rtvp.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Resident/Tenant Visitor Pass");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rtvp.getContentPane().add(lblNewLabel);

		// Pass ID
		JLabel lblUID = new JLabel("Pass ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		rtvp.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		rtvp.getContentPane().add(txtUID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		rtvp.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		rtvp.getContentPane().add(txtName);

		// Destination
		JLabel lblDestination = new JLabel("Destination: ");
		lblDestination.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDestination.setBounds(44, 123, 315, 42);
		rtvp.getContentPane().add(lblDestination);

		JTextField txtDestination = new JTextField();
		txtDestination.setBounds(164, 123, 250, 42);
		rtvp.getContentPane().add(txtDestination);

		// Contact
		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(434, 123, 315, 42);
		rtvp.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(554, 123, 250, 42);
		rtvp.getContentPane().add(txtContact);
                
                // Date
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(44, 223, 315, 42);
		rtvp.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField(restenname);
		txtDate.setBounds(164, 173, 250, 42);
		//set as non editable
		txtDate.setEditable(false);
		rtvp.getContentPane().add(txtDate);
                
                // Owner Name
		JLabel lblOwnerName = new JLabel("Owner Name: ");
		lblOwnerName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblOwnerName.setBounds(44, 173, 315, 42);
		rtvp.getContentPane().add(lblOwnerName);

		JTextField txtOwnerName = new JTextField();
		txtOwnerName.setBounds(164, 223, 250, 42);
		rtvp.getContentPane().add(txtOwnerName);

		// Owner Contact
		JLabel lblOwnerContact = new JLabel("Owner Contact: ");
		lblOwnerContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblOwnerContact.setBounds(434, 173, 315, 42);
		rtvp.getContentPane().add(lblOwnerContact);

		JTextField txtOwnerContact = new JTextField();
		txtOwnerContact.setBounds(554, 173, 250, 42);
		rtvp.getContentPane().add(txtOwnerContact);

		// Time in
		JLabel lblTime = new JLabel("Time in: ");
		lblTime.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTime.setBounds(434, 223, 315, 42);
		rtvp.getContentPane().add(lblTime);

		JTextField txtTime = new JTextField();
		txtTime.setBounds(554, 223, 250, 42);
		rtvp.getContentPane().add(txtTime);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		rtvp.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("VisitorPass.txt");
		String row[] = new String[8];
		String column[] = { "Pass ID", "Name", "Destination", "Contact","Owner Name","Owner Contact", "Date", "Time in"};

		JTable jTable = new JTable();
		jTable.setBounds(44, 323, 770, 250);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setColumnIdentifiers(column);
		//set table as non editable
		jTable.setDefaultEditor(Object.class, null);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData.size(); i++) {
			row[0] = tblData.get(i).get(0);
                        row[1] = tblData.get(i).get(1);
                        row[2] = tblData.get(i).get(2);
                        row[3] = tblData.get(i).get(3);
                        row[4] = tblData.get(i).get(6);
                        row[5] = tblData.get(i).get(5);
                        row[6] = tblData.get(i).get(4);
                        row[7] = tblData.get(i).get(7);
    
                        // Check if the row contains the search string
                        boolean match = false;
                        for (int j = 0; j < row.length; j++) {
                            if (row[j].toLowerCase().contains(restenname.toLowerCase())) {
                            match = true;
                            break;
                    		}
                		}
    
                        // Add the row if it matches the search string
                        if (match) {
                            tableModel.addRow(row);
                            }
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
                    txtOwnerName.setText((String) jTable.getValueAt(row[0], 6));
					txtOwnerContact.setText((String) jTable.getValueAt(row[0], 5));
					txtDate.setText((String) jTable.getValueAt(row[0], 4));
					txtTime.setText((String) jTable.getValueAt(row[0], 7));
				}

			}
			});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 323, 770, 250);
		rtvp.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		rtvp.getContentPane().add(calErrorText);
		
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
                txtOwnerName.setText("");
				txtOwnerContact.setText("");
				txtDate.setText(restenname);
				txtTime.setText("");
			}
		});
		rtvp.getContentPane().add(clearBtn);

		// Save Btn
		JButton addUserBtn = new JButton("Save");
		addUserBtn.setBounds(44, 273, 150, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String passId = txtUID.getText().trim();
				String name = txtName.getText().trim();
				String destination = txtDestination.getText().trim();
				String contact = txtContact.getText().trim();
                                String ownerName = txtOwnerName.getText().trim();
				String ownerContact = txtOwnerContact.getText().trim();
				String date = txtDate.getText().trim();
				String time = txtTime.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (passId.isEmpty()) { // this means new data is added
				String uid = uuid.toString();
				data.add(uid);
				data.add(name);
				data.add(destination);
				data.add(contact);
                                data.add(ownerName);
				data.add(ownerContact);
				data.add(date);
				data.add(time);

				crud.create("VisitorPass.txt", data);
				}else {// this means update data
					data.add(passId);
					data.add(name);
					data.add(destination);
					data.add(contact);
                                        data.add(ownerName);
				        data.add(ownerContact);
					data.add(date);
					data.add(time);
					crud.updateRow("VisitorPass.txt", passId, 0, "", 0, data);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtName.setText("");
				txtDestination.setText("");
				txtContact.setText("");
                txtOwnerName.setText("");
				txtOwnerContact.setText("");
				txtDate.setText(restenname);
				txtTime.setText("");

				// Refresh the data in table
				tblData = crud.read("VisitorPass.txt");
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
                                    row[4] = tblData.get(i).get(6);
                                    row[5] = tblData.get(i).get(5);
                                    row[6] = tblData.get(i).get(4);
                                    row[7] = tblData.get(i).get(7);
    
                                    // Check if the row contains the search string
                                    boolean match = false;
                                    for (int j = 0; j < row.length; j++) {
                                        if (row[j].toLowerCase().contains(restenname.toLowerCase())) {
                                        match = true;
                                        break;
                                        }
                                   }
    
                                     // Add the row if it matches the search string
                                    if (match) {
                                        tableModel.addRow(row);
                                        }
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
		rtvp.getContentPane().add(addUserBtn);

		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(364, 273, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uid = txtUID.getText().trim();
				
				crud.delete("VisitorPass.txt", uid, 0, "", 0);
				
				// Refresh the data in table
				tblData = crud.read("VisitorPass.txt");
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
					row[4] = tblData.get(i).get(6);
					row[5] = tblData.get(i).get(5);
					row[6] = tblData.get(i).get(4);
                    row[7] = tblData.get(i).get(7);
					tableModel.addRow(row);
					 // Check if the row contains the search string
					 boolean match = false;
					 for (int j = 0; j < row.length; j++) {
						 if (row[j].toLowerCase().contains(restenname.toLowerCase())) {
						 match = true;
						 break;
						 }
					 }
 
					 // Add the row if it matches the search string
					 if (match) {
						 tableModel.addRow(row);
						 }
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
		rtvp.getContentPane().add(deleteBtn);

		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResidentMenu rm = new ResidentMenu(restenname);
				setOriginalFrame(rtvp);
				setTargetedFrame(rm.rm);
				navigatePage();

			}
		});
		rtvp.getContentPane().add(backBtn);

	}

}
