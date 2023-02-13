package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class BExecComplaints {

	public JFrame bec;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();
        ArrayList<ArrayList<String>> tb2Data = new ArrayList<>();
        ArrayList<ArrayList<String>> tblData3 = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BExecComplaints window = new BExecComplaints();
					window.bec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BExecComplaints() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bec = new JFrame();
		bec.setTitle("View & Update Complaint");
		bec.setBounds(100, 100, 1200, 1000);
		bec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bec.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("View & Update Complaint");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		bec.getContentPane().add(lblNewLabel);

		// Ticket Number
		JLabel lblUID = new JLabel("No: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		bec.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(134, 73, 250, 42);
		txtUID.setBackground(Color.lightGray);
		txtUID.setEditable(false);
		bec.getContentPane().add(txtUID);
                
                // User
		JLabel lblUser = new JLabel("User: ");
		lblUser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUser.setBounds(434, 73, 315, 42);
		bec.getContentPane().add(lblUser);

		JTextField txtUser = new JTextField("");
		txtUser.setBounds(554, 73, 250, 42);
                txtUser.setBackground(Color.lightGray);
		txtUser.setEditable(false);
		bec.getContentPane().add(txtUser);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(44, 123, 220, 42);
		bec.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(134, 123, 150, 42);
                txtName.setBackground(Color.lightGray);
		txtName.setEditable(false);
		bec.getContentPane().add(txtName);

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(300, 123, 220, 42);
		bec.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(390, 123, 150, 42);
                txtEmail.setBackground(Color.lightGray);
		txtEmail.setEditable(false);
		bec.getContentPane().add(txtEmail);

		// Contact
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(556, 123, 220, 42);
		bec.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(646, 123, 150, 42);
                txtContact.setBackground(Color.lightGray);
		txtContact.setEditable(false);
		bec.getContentPane().add(txtContact);
                
                // Status
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblStatus.setBounds(824, 73, 315, 42);
		bec.getContentPane().add(lblStatus);

		JTextField txtStatus = new JTextField("");
		txtStatus.setBounds(944, 73, 210, 42);
		bec.getContentPane().add(txtStatus);
		
		// Date
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(824, 123, 315, 42);
		bec.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(944, 123, 210, 42);
                txtDate.setBackground(Color.lightGray);
		txtDate.setEditable(false);
		bec.getContentPane().add(txtDate);
                
                // Subject
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblSubject.setBounds(44, 173, 315, 42);
		bec.getContentPane().add(lblSubject);

		JTextField txtSubject = new JTextField();
		txtSubject.setBounds(134, 173, 400, 80);
                txtSubject.setBackground(Color.lightGray);
		txtSubject.setEditable(false);
		bec.getContentPane().add(txtSubject);
                
                // Detail
		JLabel lblDetail = new JLabel("Detail:");
		lblDetail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDetail.setBounds(556, 173, 315, 42);
		bec.getContentPane().add(lblDetail);

		JTextArea txtDetail = new JTextArea();
		txtDetail.setBounds(646, 174, 500, 80);
                txtDetail.setLineWrap(true);
                txtDetail.setWrapStyleWord(true);
                txtDetail.setBackground(Color.lightGray);
		txtDetail.setEditable(false);
		bec.getContentPane().add(txtDetail);


		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 273, 330, 42);
		errorText.setVisible(false);
		bec.getContentPane().add(errorText);

		// Result Display 1 for resident/tenant
		tblData = crud.read("ResidentComplaint.txt");
		String row[] = new String[9];
		String column[] = { "No.", "User", "Name", "Email", "Contact", "Status", "Date", "Subject", "Detail"};

		JTable jTable = new JTable();
		jTable.setBounds(44, 560, 1100, 110);
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
		scroll.setBounds(44, 560, 1100, 110);
		bec.getContentPane().add(scroll);
                
                // Result Display 2 for vendor
		tb2Data = crud.read("VendorComplaint.txt");
		String row1[] = new String[9];
		String column1[] = { "No.", "User", "Name", "Email", "Contact", "Status", "Date", "Subject", "Detail"};

		JTable jTable1 = new JTable();
		jTable1.setBounds(44, 780, 1100, 110);
		DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
		tableModel1.setColumnIdentifiers(column1);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tb2Data.size(); i++) {
			row1[0] = tb2Data.get(i).get(0);
			row1[1] = tb2Data.get(i).get(1);
			row1[2] = tb2Data.get(i).get(2);
			row1[3] = tb2Data.get(i).get(3);
			row1[4] = tb2Data.get(i).get(4);
			row1[5] = tb2Data.get(i).get(5);
			row1[6] = tb2Data.get(i).get(6);
                        row1[7] = tb2Data.get(i).get(7);
                        row1[8] = tb2Data.get(i).get(8);
			tableModel1.addRow(row1);

		}
		jTable1.setModel(tableModel1);

		ListSelectionModel select1 = jTable1.getSelectionModel();
		select1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row2 = jTable1.getSelectedRows();
				int columnNum2 = jTable1.getColumnCount();

				if (row2.length > 0) {
					txtUID.setText((String) jTable1.getValueAt(row2[0], 0));
					txtUser.setText((String) jTable1.getValueAt(row2[0], 1));
					txtName.setText((String) jTable1.getValueAt(row2[0], 2));
					txtEmail.setText((String) jTable1.getValueAt(row2[0], 3));
					txtContact.setText((String) jTable1.getValueAt(row2[0], 4));
					txtStatus.setText((String) jTable1.getValueAt(row2[0], 5));
					txtDate.setText((String) jTable1.getValueAt(row2[0], 6));
                                        txtSubject.setText((String) jTable1.getValueAt(row2[0], 7));
                                        txtDetail.setText((String) jTable1.getValueAt(row2[0], 8));
				}

			}
		});
		JScrollPane scroll1 = new JScrollPane(jTable1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll1.setBounds(44, 780, 1100, 110);
		bec.getContentPane().add(scroll1);
                
                // Result Display 3 for admin exec
		tblData3 = crud.read("AdminExComplaint.txt");
		String row3[] = new String[9];
		String column3[] = { "No.", "User", "Name", "Email", "Contact", "Status", "Date", "Subject", "Detail"};

		JTable jTable3 = new JTable();
		jTable3.setBounds(44, 320, 1100, 110);
		DefaultTableModel tableModel3 = (DefaultTableModel) jTable3.getModel();
		tableModel3.setColumnIdentifiers(column3);
		jTable3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData3.size(); i++) {
			row3[0] = tblData3.get(i).get(0);
			row3[1] = tblData3.get(i).get(1);
			row3[2] = tblData3.get(i).get(2);
			row3[3] = tblData3.get(i).get(3);
			row3[4] = tblData3.get(i).get(4);
			row3[5] = tblData3.get(i).get(5);
			row3[6] = tblData3.get(i).get(6);
                        row3[7] = tblData3.get(i).get(7);
                        row3[8] = tblData3.get(i).get(8);
			tableModel3.addRow(row3);

		}
		jTable3.setModel(tableModel3);

		ListSelectionModel select3 = jTable3.getSelectionModel();
		select3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select3.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row3 = jTable3.getSelectedRows();
				int columnNum3 = jTable3.getColumnCount();

				if (row3.length > 0) {
					txtUID.setText((String) jTable3.getValueAt(row3[0], 0));
					txtUser.setText((String) jTable3.getValueAt(row3[0], 1));
					txtName.setText((String) jTable3.getValueAt(row3[0], 2));
					txtEmail.setText((String) jTable3.getValueAt(row3[0], 3));
					txtContact.setText((String) jTable3.getValueAt(row3[0], 4));
					txtStatus.setText((String) jTable3.getValueAt(row3[0], 5));
					txtDate.setText((String) jTable3.getValueAt(row3[0], 6));
                                        txtSubject.setText((String) jTable3.getValueAt(row3[0], 7));
                                        txtDetail.setText((String) jTable3.getValueAt(row3[0], 8));
				}

			}
		});
		JScrollPane scroll3 = new JScrollPane(jTable3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll3.setBounds(44, 320, 1100, 110);
		bec.getContentPane().add(scroll3);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		bec.getContentPane().add(calErrorText);
                
                //resident and vendor label
                JLabel lblRes= new JLabel("Resident Complaints:");
		lblRes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRes.setBounds(44,510, 315, 42);
		bec.getContentPane().add(lblRes);
                
                JLabel lblVen= new JLabel("Vendor Complaints:");
		lblVen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblVen.setBounds(44, 730, 315, 42);
		bec.getContentPane().add(lblVen);
                
                JLabel lblAd= new JLabel("Admin Executive Complaints:");
		lblAd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblAd.setBounds(44, 270, 315, 42);
		bec.getContentPane().add(lblAd);
                
                
		// Clear Text field Btn for Resident
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 680, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtUser.setText("");
				txtName.setText("");
				txtEmail.setText("");
				txtContact.setText("");
                                txtStatus.setText("");
                                txtDate.setText("");
				txtSubject.setText("");
                                txtDetail.setText("");
			}
		});
		bec.getContentPane().add(clearBtn);

		// Save complaint Btn for Resident
		JButton addUserBtn = new JButton("Save");
		addUserBtn.setBounds(44, 680, 150, 42);
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
				txtUser.setText("");
				txtName.setText("");
				txtEmail.setText("");
				txtContact.setText("");
                                txtStatus.setText("");
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
		bec.getContentPane().add(addUserBtn);
                
                // Clear Text field Btn for Vendor
		JButton clearBtn1 = new JButton("Clear All");
		clearBtn1.setBounds(204, 900, 150, 42);
		clearBtn1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtUser.setText("");
				txtName.setText("");
				txtEmail.setText("");
				txtContact.setText("");
                                txtStatus.setText("");
                                txtDate.setText("");
				txtSubject.setText("");
                                txtDetail.setText("");
			}
		});
		bec.getContentPane().add(clearBtn1);

		// Save complaint Btn for Vendor
		JButton addUserBtn1 = new JButton("Save");
		addUserBtn1.setBounds(44, 900, 150, 42);
		addUserBtn1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn1.addActionListener(new ActionListener() {

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

					crud.create("VendorComplaint.txt", data);

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
					crud.updateRow("VendorComplaint.txt", userId, 0, "", 0, data);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtUser.setText("");
				txtName.setText("");
				txtEmail.setText("");
				txtContact.setText("");
                                txtStatus.setText("");
                                txtDate.setText("");
				txtSubject.setText("");
                                txtDetail.setText("");

				// Refresh the data in table
				tb2Data = crud.read("VendorComplaint.txt");
				DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
				tableModel1.setColumnIdentifiers(column1);
				tableModel1.getDataVector().removeAllElements();
				tableModel1.fireTableDataChanged();
				jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				for (int i = 0; i < tb2Data.size(); i++) {
					row1[0] = tb2Data.get(i).get(0);
					row1[1] = tb2Data.get(i).get(1);
					row1[2] = tb2Data.get(i).get(2);
					row1[3] = tb2Data.get(i).get(3);
					row1[4] = tb2Data.get(i).get(4);
					row1[5] = tb2Data.get(i).get(5);
					row1[6] = tb2Data.get(i).get(6);
                                        row1[7] = tb2Data.get(i).get(7);
                                        row1[8] = tb2Data.get(i).get(8);
					tableModel1.addRow(row1);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jTable1.updateUI();

			}
		});
		bec.getContentPane().add(addUserBtn1);
                
                // Clear Text field Btn for Admin Exec
		JButton clearBtn3 = new JButton("Clear All");
		clearBtn3.setBounds(204, 440, 150, 42);
		clearBtn3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtUser.setText("");
				txtName.setText("");
				txtEmail.setText("");
				txtContact.setText("");
                                txtStatus.setText("");
                                txtDate.setText("");
				txtSubject.setText("");
                                txtDetail.setText("");
			}
		});
		bec.getContentPane().add(clearBtn3);

		// Save complaint Btn for ADmin Exec
		JButton addUserBtn3 = new JButton("Save");
		addUserBtn3.setBounds(44, 440, 150, 42);
		addUserBtn3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn3.addActionListener(new ActionListener() {

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

					crud.create("AdminExComplaint.txt", data);

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
					crud.updateRow("AdminExComplaint.txt", userId, 0, "", 0, data);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtUser.setText("");
				txtName.setText("");
				txtEmail.setText("");
				txtContact.setText("");
                                txtStatus.setText("");
                                txtDate.setText("");
				txtSubject.setText("");
                                txtDetail.setText("");

				// Refresh the data in table
				tblData3 = crud.read("AdminExComplaint.txt");
				DefaultTableModel tableModel3 = (DefaultTableModel) jTable3.getModel();
				tableModel3.setColumnIdentifiers(column3);
				tableModel3.getDataVector().removeAllElements();
				tableModel3.fireTableDataChanged();
				jTable3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				for (int i = 0; i < tblData3.size(); i++) {
					row3[0] = tblData3.get(i).get(0);
					row3[1] = tblData3.get(i).get(1);
					row3[2] = tblData3.get(i).get(2);
					row3[3] = tblData3.get(i).get(3);
					row3[4] = tblData3.get(i).get(4);
					row3[5] = tblData3.get(i).get(5);
					row3[6] = tblData3.get(i).get(6);
                                        row3[7] = tblData3.get(i).get(7);
                                        row3[8] = tblData3.get(i).get(8);
					tableModel3.addRow(row3);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jTable3.updateUI();

			}
		});
		bec.getContentPane().add(addUserBtn3);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuildingExecMenu Bem = new BuildingExecMenu();
				Bem.buildExec.setVisible(true);
				bec.setVisible(false);

			}
		});
		bec.getContentPane().add(backBtn);


	}

}
