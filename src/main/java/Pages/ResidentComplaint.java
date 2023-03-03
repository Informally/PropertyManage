package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ResidentComplaint extends PageUtils {

	public JFrame rc;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResidentComplaint window = new ResidentComplaint(null);
					window.rc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResidentComplaint(String restenname) {
		initialize(restenname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String restenname) {
		rc = new JFrame();
		rc.setTitle("Resident Complaint");
		rc.setBounds(100, 100, 1200, 722);
		rc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rc.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Resident Complaint");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rc.getContentPane().add(lblNewLabel);


		// Complaint ID

		// Ticket Number
		JLabel lblUID = new JLabel("No: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		rc.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(134, 73, 250, 42);
		txtUID.setBackground(Color.lightGray);
		txtUID.setEditable(false);
		rc.getContentPane().add(txtUID);
                
                // Role
		JLabel lblUser = new JLabel("User: ");
		lblUser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUser.setBounds(434, 73, 315, 42);
		rc.getContentPane().add(lblUser);

		JTextField txtUser = new JTextField("Resident/Tenant");
		txtUser.setBounds(554, 73, 250, 42);
                txtUser.setBackground(Color.lightGray);
		txtUser.setEditable(false);
		rc.getContentPane().add(txtUser);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(44, 123, 220, 42);
		rc.getContentPane().add(lblName);

		JTextField txtName = new JTextField(restenname);
		txtName.setBounds(134, 123, 150, 42);
		//set as non-editable
		txtName.setEditable(false);
		rc.getContentPane().add(txtName);

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(300, 123, 220, 42);
		rc.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(390, 123, 150, 42);
		rc.getContentPane().add(txtEmail);

		// Contact
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(556, 123, 220, 42);
		rc.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(646, 123, 150, 42);
		rc.getContentPane().add(txtContact);
                
                // Status
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblStatus.setBounds(44, 173, 315, 42);
		rc.getContentPane().add(lblStatus);

		JTextField txtStatus = new JTextField("Processing");
		txtStatus.setBounds(134, 173, 250, 42);
                txtStatus.setBackground(Color.lightGray);
		txtStatus.setEditable(false);
		rc.getContentPane().add(txtStatus);
		
		// Date
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(434, 173, 315, 42);
		rc.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(554, 173, 250, 42);
		rc.getContentPane().add(txtDate);
                
                // Subject
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblSubject.setBounds(44, 223, 315, 42);
		rc.getContentPane().add(lblSubject);

		JTextField txtSubject = new JTextField();
		txtSubject.setBounds(134, 223, 660, 42);
		rc.getContentPane().add(txtSubject);
                
                // Detail
		JLabel lblDetail = new JLabel("Detail:");
		lblDetail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDetail.setBounds(44, 273, 315, 42);
		rc.getContentPane().add(lblDetail);

		JTextArea txtDetail = new JTextArea();
		txtDetail.setBounds(134, 273, 660, 150);
                txtDetail.setLineWrap(true);
                txtDetail.setWrapStyleWord(true);
		rc.getContentPane().add(txtDetail);


		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 273, 330, 42);
		errorText.setVisible(false);
		rc.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("ResidentComplaint.txt");
		String row[] = new String[9];
		String column[] = { "No.", "User", "Name", "Email", "Contact", "Status", "Date", "Subject", "Detail"};

		JTable jTable = new JTable();
		jTable.setBounds(44, 500, 1100, 150);
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
            row[8] = tblData.get(i).get(8);
			//tableModel.addRow(row);
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
					txtUser.setText((String) jTable.getValueAt(row[0], 1));
					txtName.setText((String) jTable.getValueAt(row[0], 2));
					txtEmail.setText((String) jTable.getValueAt(row[0], 3));
					txtContact.setText((String) jTable.getValueAt(row[0], 4));
					txtStatus.setText((String) jTable.getValueAt(row[0], 5));
					txtDate.setText((String) jTable.getValueAt(row[0], 6));
                    txtSubject.setText((String) jTable.getValueAt(row[0], 7));
                    txtDetail.setText((String) jTable.getValueAt(row[0], 8));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 500, 1100, 150);
		rc.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		rc.getContentPane().add(calErrorText);

		
		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(364, 450, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uid = txtUID.getText().trim();
				
				crud.delete("ResidentComplaint.txt", uid, 0, "", 0);
				
				// Refresh the data in table
				tblData = crud.read("ResidentComplaint.txt");
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
                    row[8] = tblData.get(i).get(8);
					//tableModel.addRow(row);
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
		rc.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 450, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtUser.setText("Resident/Tenant");
				txtName.setText(restenname);
				txtEmail.setText("");
				txtContact.setText("");
                txtStatus.setText("Processing");
                txtDate.setText("");
				txtSubject.setText("");
                txtDetail.setText("");
			}
		});
		rc.getContentPane().add(clearBtn);



		// Add complaint Btn

		JButton addUserBtn = new JButton("Save");
		addUserBtn.setBounds(44, 450, 150, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String userId = txtUID.getText().trim();
                                String user1 = txtUser.getText().trim();
				String name = txtName.getText().trim();
				String email = txtEmail.getText().trim();
				String contact = txtContact.getText().trim();
                                String status = txtStatus.getText().trim();
				String date = txtDate.getText().trim();
                                String subject = txtSubject.getText().trim();
                                String detail = txtDetail.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (userId.isEmpty()) { // this means new data is added
					String uid = uuid.toString();
					data.add(uid);
                                        data.add(user1);
					data.add(name);
					data.add(email);
                                        data.add(contact);
                                        data.add(status);
					data.add(date);
					data.add(subject);
					data.add(detail);

					crud.create("ResidentComplaint.txt", data);

				} else { // this means update data
					data.add(userId);
					data.add(user1);
					data.add(name);
					data.add(email);
                                        data.add(contact);
                                        data.add(status);
					data.add(date);
					data.add(subject);
					data.add(detail);
					crud.updateRow("ResidentComplaint.txt", userId, 0, "", 0, data);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtUser.setText("Resident/Tenant");
				txtName.setText("");
				txtEmail.setText("");
				txtContact.setText("");
                                txtStatus.setText("Processing");
                                txtDate.setText("");
				txtSubject.setText("");
                                txtDetail.setText("");

				// Refresh the data in table
				tblData = crud.read("ResidentComplaint.txt");
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
                    row[8] = tblData.get(i).get(8);
					//tableModel.addRow(row);
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
		rc.getContentPane().add(addUserBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResidentMenu rm = new ResidentMenu(restenname);
				setOriginalFrame(rc);
				setTargetedFrame(rm.rm);
				navigatePage();

			}
		});
		rc.getContentPane().add(backBtn);


	}

}
