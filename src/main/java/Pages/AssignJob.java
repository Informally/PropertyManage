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

public class AssignJob extends PageUtils {

	public JFrame AsgnJobPage;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignJob window = new AssignJob(null);
					window.AsgnJobPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AssignJob(String buildingName) {
		initialize(buildingName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String buildingName) {
		AsgnJobPage = new JFrame();
		AsgnJobPage.setTitle("Assign Job/Task to Employee");
		AsgnJobPage.setBounds(100, 100, 871, 622);
		AsgnJobPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set as non resizable
		AsgnJobPage.setResizable(false);
		AsgnJobPage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Assign Job/Task to Employee");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(34, 5, 665, 81);
		AsgnJobPage.getContentPane().add(lblNewLabel);

		// Employee ID
		JLabel lblEMID = new JLabel("Employee ID: ");
		lblEMID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEMID.setBounds(44, 73, 315, 42);
		AsgnJobPage.getContentPane().add(lblEMID);

		JTextField txtEMID = new JTextField("");
		txtEMID.setBounds(164, 73, 250, 42);
		txtEMID.setBackground(Color.lightGray);
		txtEMID.setEditable(false);
		AsgnJobPage.getContentPane().add(txtEMID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		AsgnJobPage.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
                txtName.setBackground(Color.lightGray);
		txtName.setEditable(false);
		AsgnJobPage.getContentPane().add(txtName);

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(44, 123, 315, 42);
		AsgnJobPage.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(164, 123, 250, 42);
                txtEmail.setBackground(Color.lightGray);
		txtEmail.setEditable(false);
		AsgnJobPage.getContentPane().add(txtEmail);

		// Contact
		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContact.setBounds(434, 123, 315, 42);
		AsgnJobPage.getContentPane().add(lblContact);

		JTextField txtContact = new JTextField();
		txtContact.setBounds(554, 123, 250, 42);
        txtContact.setBackground(Color.lightGray);
		txtContact.setEditable(false);
		AsgnJobPage.getContentPane().add(txtContact);



		// Age
		JLabel lblAge = new JLabel("Age: ");
		lblAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblAge.setBounds(44, 173, 315, 42);
		AsgnJobPage.getContentPane().add(lblAge);

		JTextField txtAge = new JTextField();
		txtAge.setBounds(164, 173, 250, 42);
                txtAge.setBackground(Color.lightGray);
		txtAge.setEditable(false);
		AsgnJobPage.getContentPane().add(txtAge);

		// Job Role
		JLabel lblJob = new JLabel("Job Role: ");
		lblJob.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblJob.setBounds(434, 173, 315, 42);
		AsgnJobPage.getContentPane().add(lblJob);

		JTextField txtJob = new JTextField();
		txtJob.setBounds(554, 173, 250, 42);
		AsgnJobPage.getContentPane().add(txtJob);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		AsgnJobPage.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("Employee.txt");
		String row[] = new String[6];
		String column[] = { "Employee Id", "Name", "Email", "Contact", "Age", "Job Role" };

		JTable jTable = new JTable();
		jTable.setBounds(44, 273, 770, 250);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setColumnIdentifiers(column);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData.size(); i++) {
			row[0] = tblData.get(i).get(0);
			row[1] = tblData.get(i).get(1);
			row[2] = tblData.get(i).get(2);
			row[3] = tblData.get(i).get(4);
			row[4] = tblData.get(i).get(5);
			row[5] = tblData.get(i).get(6);
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
					txtContact.setText((String) jTable.getValueAt(row[0], 3));
					txtAge.setText((String) jTable.getValueAt(row[0], 4));
					txtJob.setText((String) jTable.getValueAt(row[0],5 ));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 273, 770, 250);
		AsgnJobPage.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		AsgnJobPage.getContentPane().add(calErrorText);

		
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
					row[3] = tblData.get(i).get(4);
					row[4] = tblData.get(i).get(5);
					row[5] = tblData.get(i).get(6);
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
		AsgnJobPage.getContentPane().add(deleteBtn);

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
				txtContact.setText("");
				txtAge.setText("");
				txtJob.setText("");
			}
		});
		AsgnJobPage.getContentPane().add(clearBtn);

		// Assign JOb/Task Btn
		JButton addResTenBtn = new JButton("Assign Job/Task");
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

				if (job.isEmpty()) { // this means to prompt user to select an employee
                                    JOptionPane.showMessageDialog(null,"Please select an employee");

				} 
                    else { // this means update data
					data.add(emid);
					data.add(name);
					data.add(email);
					ArrayList<ArrayList<String>> bulkData = crud.readBulk("Employee.txt", "all", 0, "", 0);
					for (int i = 0; i < bulkData.size(); i++) {
						if (bulkData.get(i).get(0).equals(emid)) {
							data.add(bulkData.get(i).get(3));
						}
					}
					data.add(contact);
					data.add(age);
					data.add(job);
					crud.updateRow("Employee.txt", emid, 0, "", 0, data);
				} 
                                
         
				// Clear text after update or add
				txtEMID.setText("");
				txtName.setText("");
				txtEmail.setText("");
				txtContact.setText("");
				txtAge.setText("");
				txtJob.setText("");

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
					row[3] = tblData.get(i).get(4);
					row[4] = tblData.get(i).get(5);
					row[5] = tblData.get(i).get(6);
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
		AsgnJobPage.getContentPane().add(addResTenBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuildingExecMenu Bem = new BuildingExecMenu(buildingName);
				setOriginalFrame(AsgnJobPage);
				setTargetedFrame(Bem.buildExec);
				navigatePage();

			}
		});
		AsgnJobPage.getContentPane().add(backBtn);


	}

}
