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

import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

public class SecCheckpoint extends PageUtils{

	public JFrame c;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();
	ArrayList<ArrayList<String>> tblData2 = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecCheckpoint window = new SecCheckpoint(null);
					window.c.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecCheckpoint(String secname) {
		initialize(secname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String secname) {
		c = new JFrame();
		c.setTitle("Checkpoint Check-in");
		c.setBounds(100, 100, 871, 600);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setResizable(false);
		c.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Checkpoint Check-in");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(34, 3, 665, 81);
		c.getContentPane().add(lblNewLabel);

		// Checkpoint ID
		JLabel lblUID = new JLabel("Checkpoint ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		c.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(174, 73, 250, 42);
		txtUID.setEditable(false);
		c.getContentPane().add(txtUID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(444, 73, 315, 42);
		c.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(564, 73, 250, 42);
		//set as non-editable
		txtName.setEditable(false);
		c.getContentPane().add(txtName);

		// Location
		JLabel lblLocation = new JLabel("Location: ");
		lblLocation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblLocation.setBounds(44, 123, 315, 42);
		c.getContentPane().add(lblLocation);

		JTextField txtLocation = new JTextField();
		txtLocation.setBounds(174, 123, 250, 42);
		//set as non-editable
		txtLocation.setEditable(false);
		c.getContentPane().add(txtLocation);

		// Contact
		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(444, 123, 315, 42);
		c.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(564, 123, 250, 42);
		c.getContentPane().add(txtContact);
		
		// Status
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblStatus.setBounds(44, 173, 250, 42);
		c.getContentPane().add(lblStatus);

		JTextField txtStatus = new JTextField();
		txtStatus.setBounds(174, 173, 250, 42);
		c.getContentPane().add(txtStatus);

		// Date
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(444, 173, 315, 42);
		c.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(564, 173, 250, 42);
		c.getContentPane().add(txtDate);

		// Time in
		JLabel lblTimeIn = new JLabel("Time in: ");
		lblTimeIn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTimeIn.setBounds(44, 223, 250, 42);
		c.getContentPane().add(lblTimeIn);

		JTextField txtTimeIn = new JTextField();
		txtTimeIn.setBounds(174, 223, 250, 42);
		c.getContentPane().add(txtTimeIn);
		
		// Time out
		JLabel lblTimeOut = new JLabel("Time out: ");
		lblTimeOut.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTimeOut.setBounds(444, 223, 315, 42);
		c.getContentPane().add(lblTimeOut);

		JTextField txtTimeOut = new JTextField();
		txtTimeOut.setBounds(564, 223, 250, 42);
		c.getContentPane().add(txtTimeOut);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		c.getContentPane().add(errorText);

		// Table 1 partol schedule and checkpoint table
		tblData2 = crud.read("Patrol.txt");
		String row1[] = new String[6];
		String column1[] = { "Checkpoint Id", "Name", "Job Role", "Patrol Day", "Patrol Schedule", "Checkpoint" };

		JTable jTable1 = new JTable();
		jTable1.setBounds(44, 323, 770, 100);
		//set jTabl1 to be uneditable
		jTable1.setDefaultEditor(Object.class, null);
		DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
		//set tableModel1 to be non-editable
		jTable1.setDefaultEditor(Object.class, null);
		tableModel1.setColumnIdentifiers(column1);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
              
		for (int i = 0; i < tblData2.size(); i++) {
			row1[0] = tblData2.get(i).get(0);
			row1[1] = tblData2.get(i).get(1);
			row1[2] = tblData2.get(i).get(2);
			row1[3] = tblData2.get(i).get(3);
			row1[4] = tblData2.get(i).get(4);
			row1[5] = tblData2.get(i).get(5);
			//tableModel1.addRow(row1);
			// Check if the row contains the search string
			boolean match = false;
			for (int j = 0; j < row1.length; j++) {
				if (row1[j].toLowerCase().contains(secname.toLowerCase())) {
				match = true;
				break;
				}
			}	

			// Add the row if it matches the search string
			if (match) {
				tableModel1.addRow(row1);
				}
		}


		jTable1.setModel(tableModel1);

		ListSelectionModel select1 = jTable1.getSelectionModel();
		select1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row1 = jTable1.getSelectedRows();
				int columnNum1 = jTable1.getColumnCount();

				if (row1.length > 0) {
					txtName.setText((String) jTable1.getValueAt(row1[0], 1));
					txtLocation.setText((String) jTable1.getValueAt(row1[0], 5));

				}
			}
		});
		JScrollPane scroll1 = new JScrollPane(jTable1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll1.setBounds(44, 323, 770, 100);
		c.getContentPane().add(scroll1);

		// Result Display 2
		tblData = crud.read("Checkpoint.txt");
		String row[] = new String[8];
		String column[] = { "Checkpoint ID", "Name", "Location", "Contact", "Status", "Date", "Time in", "Time out"};

		JTable jTable = new JTable();
		jTable.setBounds(44, 433, 770, 100);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setColumnIdentifiers(column);
		//set jTable to be uneditable
		jTable.setDefaultEditor(Object.class, null);
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
			//tableModel.addRow(row);
			boolean match1 = false;
			for (int j = 0; j < row.length; j++) {
				if (row[j].toLowerCase().contains(secname.toLowerCase())) {
				match1 = true;
				break;
				}
			}	

			// Add the row if it matches the search string
			if (match1) {
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
					txtLocation.setText((String) jTable.getValueAt(row[0], 2));
					txtContact.setText((String) jTable.getValueAt(row[0], 3));
					txtStatus.setText((String) jTable.getValueAt(row[0], 4));
					txtDate.setText((String) jTable.getValueAt(row[0], 5));
					txtTimeIn.setText((String) jTable.getValueAt(row[0], 6));
					txtTimeOut.setText((String) jTable.getValueAt(row[0], 7));
				}

			}
			});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 433, 770, 100);
		c.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		c.getContentPane().add(calErrorText);
		
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
				txtStatus.setText("");
				txtDate.setText("");
				txtTimeIn.setText("");
				txtTimeOut.setText("");
			}
		});
		c.getContentPane().add(clearBtn);

		// Save Btn
		JButton addUserBtn = new JButton("Save");
		addUserBtn.setBounds(44, 273, 150, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				UUID uuid = UUID.randomUUID();

				String checkPointId = txtUID.getText().trim();
				String name = txtName.getText().trim();
				String location = txtLocation.getText().trim();
				String contact = txtContact.getText().trim();
				String status = txtStatus.getText().trim();
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
				
				if (checkPointId.isEmpty()) { // this means new data is added
				String uid = uuid.toString();
				data.add(uid);
				data.add(name);
				data.add(location);
				data.add(contact);
				data.add(status);
				data.add(date);
				data.add(timeIn);
				data.add(timeOut);

				crud.create("Checkpoint.txt", data);
				}else {// this means update data
					data.add(checkPointId);
					data.add(name);
					data.add(location);		
					data.add(contact);
					data.add(status);
					data.add(date);
					data.add(timeIn);
					data.add(timeOut);
					crud.updateRow("Checkpoint.txt", checkPointId, 0, "", 0, data);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtName.setText("");
				txtLocation.setText("");
				txtContact.setText("");
				txtStatus.setText("");
				txtDate.setText("");
				txtTimeIn.setText("");
				txtTimeOut.setText("");

				// Refresh the data in table
				tblData = crud.read("Checkpoint.txt");
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
					//tableModel.addRow(row);
					boolean match2 = false;
			for (int j = 0; j < row.length; j++) {
				if (row[j].toLowerCase().contains(secname.toLowerCase())) {
				match2 = true;
				break;
				}
			}	

			// Add the row if it matches the search string
			if (match2) {
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
		c.getContentPane().add(addUserBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(670, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecurityGuardMenu sg = new SecurityGuardMenu(secname);
                                setOriginalFrame(c);
				setTargetedFrame(sg.sg);
				navigatePage();

			}
		});
		c.getContentPane().add(backBtn);

	}

}
