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
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;

public class EmployeeMgt extends PageUtils {

	public JFrame EmMgtPage;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMgt window = new EmployeeMgt(null);
					window.EmMgtPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeMgt(String adminName) {
		initialize(adminName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String adminName) {
		EmMgtPage = new JFrame();
		EmMgtPage.setTitle("Employee Management");
		EmMgtPage.setBounds(100, 100, 871, 622);
		EmMgtPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EmMgtPage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(adminName + "- Employee Management");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(34, 5, 665, 81);
		EmMgtPage.getContentPane().add(lblNewLabel);

		// Employee ID
		JLabel lblEMID = new JLabel("Employee ID: ");
		lblEMID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEMID.setBounds(44, 73, 315, 42);
		EmMgtPage.getContentPane().add(lblEMID);

		JTextField txtEMID = new JTextField("");
		txtEMID.setBounds(164, 73, 250, 42);
		txtEMID.setBackground(Color.lightGray);
		txtEMID.setEditable(false);
		EmMgtPage.getContentPane().add(txtEMID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		EmMgtPage.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		EmMgtPage.getContentPane().add(txtName);

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(44, 123, 315, 42);
		EmMgtPage.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(164, 123, 250, 42);
		EmMgtPage.getContentPane().add(txtEmail);

		// Password
                JLabel lblPwd = new JLabel("Password: ");
		lblPwd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPwd.setBounds(434, 123, 315, 42);
		EmMgtPage.getContentPane().add(lblPwd);

		JTextField txtPwd = new JTextField("123abc");
		txtPwd.setBounds(554, 123, 250, 42);
		EmMgtPage.getContentPane().add(txtPwd);

                
                //Contact
		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(434, 173, 315, 42);
		EmMgtPage.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(554, 173, 250, 42);
		EmMgtPage.getContentPane().add(txtContact);

		// Age
		JLabel lblAge = new JLabel("Age: ");
		lblAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblAge.setBounds(44, 173, 315, 42);
		EmMgtPage.getContentPane().add(lblAge);

		JTextField txtAge = new JTextField();
		txtAge.setBounds(164, 173, 250, 42);
		EmMgtPage.getContentPane().add(txtAge);

		// Job Role
		JLabel lblJob = new JLabel("Job Role: ");
		lblJob.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblJob.setBounds(434, 223, 315, 42);
		EmMgtPage.getContentPane().add(lblJob);

		JTextField txtJob = new JTextField("none");
		txtJob.setBounds(554, 223, 250, 42);
		EmMgtPage.getContentPane().add(txtJob);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		EmMgtPage.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("Employee.txt");
		String row[] = new String[7];
		String column[] = { "Employee Id", "Name", "Email", "Password", "Contact", "Age", "Job Role" };

		JTable jTable = new JTable();
		jTable.setBounds(44, 273, 770, 250);
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
					txtEMID.setText((String) jTable.getValueAt(row[0], 0));
					txtName.setText((String) jTable.getValueAt(row[0], 1));
					txtEmail.setText((String) jTable.getValueAt(row[0], 2));
                                        txtPwd.setText((String) jTable.getValueAt(row[0], 3));
					txtContact.setText((String) jTable.getValueAt(row[0], 4));
					txtAge.setText((String) jTable.getValueAt(row[0], 5));
					txtJob.setText((String) jTable.getValueAt(row[0], 6));
                                        
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 273, 770, 250);
		EmMgtPage.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		EmMgtPage.getContentPane().add(calErrorText);

		
		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(44, 530, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String emid = txtEMID.getText().trim();
				
				crud.delete("Employee.txt", emid, 0, "", 0);
				
				// Refresh the data in table
				tblData = crud.read("Employee.txt");
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
		EmMgtPage.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(254, 223, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtEMID.setText("");
				txtName.setText("");
				txtEmail.setText("");
                                txtPwd.setText("123abc");
				txtContact.setText("");
				txtAge.setText("");
				txtJob.setText("none");
                                
			}
		});
		EmMgtPage.getContentPane().add(clearBtn);

		// Add Employee Btn
		JButton addResTenBtn = new JButton("Save Employee");
		addResTenBtn.setBounds(44, 223, 200, 42);
		addResTenBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addResTenBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String emid = txtEMID.getText().trim();
				String name = txtName.getText().trim();
				String email = txtEmail.getText().trim();
                                String pwd = txtPwd.getText().trim();
				String contact = txtContact.getText().trim();
				String age = txtAge.getText().trim();
				String job = txtJob.getText().trim();
                                

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (emid.isEmpty()) { // this means new data is added
					String id = uuid.toString();
					data.add(id);
					data.add(name);
					data.add(email);
                                        data.add(pwd);
					data.add(contact);
					data.add(age);
					data.add(job);

					crud.create("Employee.txt", data);

				} 
                                else { // this means update data
					data.add(emid);
					data.add(name);
					data.add(email);
                                        data.add(pwd);
					data.add(contact);
					data.add(age);
					data.add(job);
					crud.updateRow("Employee.txt", emid, 0, "", 0, data);
				} 
                                
         
				// Clear text after update or add
				txtEMID.setText("");
				txtName.setText("");
				txtEmail.setText("");
                                txtPwd.setText("123abc");
				txtContact.setText("");
				txtAge.setText("");
				txtJob.setText("none");

				// Refresh the data in table
				tblData = crud.read("Employee.txt");
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
		EmMgtPage.getContentPane().add(addResTenBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminExecMenu Aem = new AdminExecMenu(adminName);
                                setOriginalFrame(EmMgtPage);
				setTargetedFrame(Aem.Aem);
				navigatePage();
				

			}
		});
		EmMgtPage.getContentPane().add(backBtn);


	}

}
