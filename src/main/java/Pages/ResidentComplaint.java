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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ResidentComplaint {

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
					ResidentComplaint window = new ResidentComplaint();
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
	public ResidentComplaint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rc = new JFrame();
		rc.setTitle("Resident Complaint");
		rc.setBounds(100, 100, 871, 722);
		rc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rc.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Resident Complaint");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rc.getContentPane().add(lblNewLabel);

		// Complaint ID
		JLabel lblUID = new JLabel("Complaint ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		rc.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		rc.getContentPane().add(txtUID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		rc.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		rc.getContentPane().add(txtName);

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(44, 123, 315, 42);
		rc.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(164, 123, 250, 42);
		rc.getContentPane().add(txtEmail);

		// Contact
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(434, 123, 315, 42);
		rc.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(554, 123, 250, 42);
		rc.getContentPane().add(txtContact);

		// Title
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTitle.setBounds(44, 173, 315, 42);
		rc.getContentPane().add(lblTitle);

		JTextField txtTitle = new JTextField();
		txtTitle.setBounds(164, 173, 250, 42);
		rc.getContentPane().add(txtTitle);

		// Detail
		JLabel lblDetail = new JLabel("Detail:");
		lblDetail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDetail.setBounds(434, 173, 315, 42);
		rc.getContentPane().add(lblDetail);

		JTextField txtDetail = new JTextField();
		txtDetail.setBounds(554, 173, 250, 42);
		rc.getContentPane().add(txtDetail);
		
		// Date
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(44, 223, 315, 42);
		rc.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(164, 223, 250, 42);
		rc.getContentPane().add(txtDate);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 273, 330, 42);
		errorText.setVisible(false);
		rc.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("ResidentComplaint.txt");
		String row[] = new String[7];
		String column[] = { "User Id", "Name", "Email", "Contact", "Title", "Detail", "Date" };

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
					txtEmail.setText((String) jTable.getValueAt(row[0], 2));
					txtContact.setText((String) jTable.getValueAt(row[0], 3));
					txtTitle.setText((String) jTable.getValueAt(row[0], 4));
					txtDetail.setText((String) jTable.getValueAt(row[0], 5));
					txtDate.setText((String) jTable.getValueAt(row[0], 6));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 323, 770, 250);
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
		deleteBtn.setBounds(364, 273, 150, 42);
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
		rc.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 273, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtName.setText("");
				txtTitle.setText("");
				txtEmail.setText("");
				txtContact.setText("");
				txtDetail.setText("");
				txtDate.setText("");
			}
		});
		rc.getContentPane().add(clearBtn);

		// Save Btn
		JButton addUserBtn = new JButton("Save");
		addUserBtn.setBounds(44, 273, 150, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String userId = txtUID.getText().trim();
				String name = txtName.getText().trim();
				String title = txtTitle.getText().trim();
				String detail = txtDetail.getText().trim();
				String email = txtEmail.getText().trim();
				String contact = txtContact.getText().trim();
				String date = txtDate.getText().trim();

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
					data.add(name);
					data.add(email);
					data.add(contact);
					data.add(title);
					data.add(detail);
					data.add(date);

					crud.create("ResidentComplaint.txt", data);

				} else { // this means update data
					data.add(userId);
					data.add(name);
					data.add(email);
					data.add(contact);
					data.add(title);
					data.add(detail);
					data.add(date);
					crud.updateRow("ResidentComplaint.txt", userId, 0, "", 0, data);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtName.setText("");
				txtTitle.setText("");
				txtEmail.setText("");
				txtContact.setText("");
				txtDetail.setText("");
				txtDate.setText("");

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
		rc.getContentPane().add(addUserBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResidentMenu rm = new ResidentMenu();
				rm.rm.setVisible(true);
				rc.setVisible(false);

			}
		});
		rc.getContentPane().add(backBtn);


	}

}
