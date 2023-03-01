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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Security extends PageUtils{

	public JFrame SecPage;
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
					Security window = new Security(null);
					window.SecPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Security(String buildingName) {
		initialize(buildingName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String buildingName) {
		SecPage = new JFrame();
		SecPage.setTitle("Setup, View, Modify, Delete Patrolling Schedule");
		SecPage.setBounds(100, 100, 1000, 800);
		SecPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SecPage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Patrolling Schedule & Checkpoint");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblNewLabel.setBounds(34, 5, 665, 81);
		SecPage.getContentPane().add(lblNewLabel);

		// Employee ID
		JLabel lblEMID = new JLabel("Employee ID: ");
		lblEMID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEMID.setBounds(44, 73, 315, 42);
		SecPage.getContentPane().add(lblEMID);

		JTextField txtEMID = new JTextField("");
		txtEMID.setBounds(164, 73, 250, 42);
		txtEMID.setBackground(Color.lightGray);
		txtEMID.setEditable(false);
		SecPage.getContentPane().add(txtEMID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		SecPage.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
                txtName.setBackground(Color.lightGray);
		txtName.setEditable(false);
		SecPage.getContentPane().add(txtName);

		// Role
		JLabel lblRole = new JLabel("Job Role: ");
		lblRole.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRole.setBounds(44, 123, 315, 42);
		SecPage.getContentPane().add(lblRole);

		JTextField txtRole = new JTextField();
		txtRole.setBounds(164, 123, 250, 42);
                txtRole.setBackground(Color.lightGray);
		txtRole.setEditable(false);
		SecPage.getContentPane().add(txtRole);

		// Patrolling Schedule (Add this)
		//JLabel lblPatrol = new JLabel("Contact: ");
		//lblPatrol.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		//lblPatrol.setBounds(434, 123, 315, 42);
		//SecPage.getContentPane().add(lblPatrol);

		//JTextField txtPatrol = new JTextField();
		//txtPatrol.setBounds(554, 123, 250, 42);
                //txtPatrol.setBackground(Color.lightGray);
		//txtPatrol.setEditable(false);
		//SecPage.getContentPane().add(txtPatrol);
                
                // Patrol Day
		JLabel lblPatrolDay = new JLabel("Patrol Day: ");
		lblPatrolDay.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPatrolDay.setBounds(434, 123, 315, 42);
		SecPage.getContentPane().add(lblPatrolDay);

		JComboBox<String> PatrolDay = new JComboBox<>();
		PatrolDay.setBounds(600, 123, 200, 42);
		PatrolDay.addItem("Monday");
		PatrolDay.addItem("Tuesday");
		PatrolDay.addItem("Wednesday");
                PatrolDay.addItem("Thursday");
                PatrolDay.addItem("Friday");
                PatrolDay.addItem("Saturday");
                PatrolDay.addItem("Sunday");
		SecPage.getContentPane().add(PatrolDay);

                // Patrol Schedule
		JLabel lblPatrol = new JLabel("Patrol Schedule: ");
		lblPatrol.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPatrol.setBounds(434, 173, 315, 42);
		SecPage.getContentPane().add(lblPatrol);

		JComboBox<String> PatrolSchedule = new JComboBox<>();
		PatrolSchedule.setBounds(600, 173, 200, 42);
		PatrolSchedule.addItem("8am - 12pm");
		PatrolSchedule.addItem("12pm - 4pm");
		PatrolSchedule.addItem("4pm - 8pm");
                PatrolSchedule.addItem("8pm - 12am");
                PatrolSchedule.addItem("12am - 4am ");
                PatrolSchedule.addItem("4am - 8am");
		SecPage.getContentPane().add(PatrolSchedule);

		// Checkpoint
		JLabel lblCheck = new JLabel("Checkpoint: ");
		lblCheck.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCheck.setBounds(44, 173, 315, 42);
		SecPage.getContentPane().add(lblCheck);

		JTextField txtCheck = new JTextField();
		txtCheck.setBounds(164, 173, 250, 42);
                //txtCheck.setBackground(Color.lightGray);
		//txtCheck.setEditable(false);
		SecPage.getContentPane().add(txtCheck);

		// Job Role
		//JLabel lblJob = new JLabel("Job Role: ");
		//lblJob.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		//lblJob.setBounds(434, 173, 315, 42);
		//SecPage.getContentPane().add(lblJob);

		//JTextField txtJob = new JTextField();
		//txtJob.setBounds(554, 173, 250, 42);
		//SecPage.getContentPane().add(txtJob);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		SecPage.getContentPane().add(errorText);

		// Table 1: show all security guards only
		tblData = crud.read("Employee.txt");
		String row[] = new String[6];
		String column[] = { "Employee Id", "Name", "Email", "Contact", "Age", "Job Role" };

		JTable jTable = new JTable();
		jTable.setBounds(44, 273, 900, 100);
				//set jTabl1 to be uneditable
				jTable.setDefaultEditor(Object.class, null);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setColumnIdentifiers(column);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                for (int i = 0; i < tblData.size(); i++) {
                    if (tblData.get(i).get(6).equals("Security Guard")) {
                        row[0] = tblData.get(i).get(0);
                        row[1] = tblData.get(i).get(1);
                        row[2] = tblData.get(i).get(2);
                        row[3] = tblData.get(i).get(4);
                        row[4] = tblData.get(i).get(5);
                        row[5] = tblData.get(i).get(6);
                        tableModel.addRow(row);
                        }
                }
		
		jTable.setModel(tableModel);

		ListSelectionModel select = jTable.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {
                        @Override
			public void valueChanged(ListSelectionEvent e) {
				int[] row = jTable.getSelectedRows();
				int columnNum = jTable.getColumnCount();

				if (row.length > 0) {
					txtEMID.setText((String) jTable.getValueAt(row[0], 0));
					txtName.setText((String) jTable.getValueAt(row[0], 1));
					txtRole.setText((String) jTable.getValueAt(row[0], 5));
                    PatrolDay.setSelectedIndex(-1);
                    PatrolSchedule.setSelectedIndex(-1);
					txtCheck.setText("");
				}
			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 273, 900, 100);
		SecPage.getContentPane().add(scroll);

                
                // table 2: assign partol schedule and checkpoint table
                tblData2 = crud.read("Patrol.txt");
		String row1[] = new String[6];
		String column1[] = { "Employee Id", "Name", "Job Role", "Patrol Day", "Patrol Schedule", "Checkpoint" };

		JTable jTable1 = new JTable();
		jTable1.setBounds(44, 400, 900, 200);
		//set jTabl1 to be uneditable
		jTable1.setDefaultEditor(Object.class, null);
		DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
		tableModel1.setColumnIdentifiers(column1);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
              
		for (int i = 0; i < tblData2.size(); i++) {
			row1[0] = tblData2.get(i).get(0);
			row1[1] = tblData2.get(i).get(1);
			row1[2] = tblData2.get(i).get(2);
			row1[3] = tblData2.get(i).get(3);
			row1[4] = tblData2.get(i).get(4);
			row1[5] = tblData2.get(i).get(5);
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
					txtEMID.setText((String) jTable1.getValueAt(row1[0], 0));
					txtName.setText((String) jTable1.getValueAt(row1[0], 1));
					txtRole.setText((String) jTable1.getValueAt(row1[0], 2));
					PatrolDay.setSelectedItem((String) jTable1.getValueAt(row1[0], 3));
					PatrolSchedule.setSelectedItem((String) jTable1.getValueAt(row1[0], 4));
					txtCheck.setText((String) jTable1.getValueAt(row1[0], 5));
				}
			}
		});
		JScrollPane scroll1 = new JScrollPane(jTable1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll1.setBounds(44, 400, 900, 200);
		SecPage.getContentPane().add(scroll1);
                
                
		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		SecPage.getContentPane().add(calErrorText);

		// Update Btn
		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(44, 620, 150, 42);
		updateBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		SecPage.getContentPane().add(updateBtn);

		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(204, 620, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
                String emid = txtEMID.getText().trim();
				
				crud.delete("Patrol.txt", emid, 0, "", 0);
                                
				// Refresh the data in table 2
				tblData2 = crud.read("Patrol.txt");
				DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
				tableModel1.setColumnIdentifiers(column1);
				tableModel1.getDataVector().removeAllElements();
				tableModel1.fireTableDataChanged();
				jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				for (int i = 0; i < tblData2.size(); i++) {
					row1[0] = tblData2.get(i).get(0);
					row1[1] = tblData2.get(i).get(1);
					row1[2] = tblData2.get(i).get(2);
					row1[3] = tblData2.get(i).get(3);
					row1[4] = tblData2.get(i).get(4);
					row1[5] = tblData2.get(i).get(5);
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
		SecPage.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(464, 223, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtEMID.setText("");
				txtName.setText("");
				txtRole.setText("");
				PatrolDay.setSelectedIndex(-1);
				PatrolSchedule.setSelectedIndex(-1);
				txtCheck.setText("");
			}
		});
		SecPage.getContentPane().add(clearBtn);

		// Assign Patrol Schedule and CheckpointBtn
		JButton addResTenBtn = new JButton("Save Patrol Schedule & Checkpoint");
		addResTenBtn.setBounds(44, 223, 400, 42);
		addResTenBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addResTenBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String emid = txtEMID.getText().trim();
				String name = txtName.getText().trim();
				String role = txtRole.getText().trim();
				String day = (String) PatrolDay.getSelectedItem();
				String schedule = (String) PatrolSchedule.getSelectedItem();
				String checkpoint = txtCheck.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (emid.isEmpty()) { // this means to prompt user to select an employee
                    JOptionPane.showMessageDialog(null,"Please select a Security Guard");
					//String id = uuid.toString();
					//data.add(id);
					//data.add(name);
					//data.add(email);
					//data.add(contact);
					//data.add(age);
					//data.add(job);

					//crud.create("Employee.txt", data);
					//crud.updateRow("Patrol.txt", emid, 0, "", 0, data);

				} 
                else { // this means update data
					data.add(emid);
					data.add(name);
					data.add(role);
					data.add(day);
					data.add(schedule);
					data.add(checkpoint);
                    crud.create("Patrol.txt", data);
					
				}              
         
				// Clear text after update or add
				txtEMID.setText("");
				txtName.setText("");
				txtRole.setText("");
				PatrolDay.setSelectedIndex(-1);
				PatrolSchedule.setSelectedIndex(-1);
				txtCheck.setText("");

				// Refresh the data in table
				tblData2 = crud.read("Patrol.txt");
				DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
				tableModel1.setColumnIdentifiers(column1);
				tableModel1.getDataVector().removeAllElements();
				tableModel1.fireTableDataChanged();
				jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				for (int i = 0; i < tblData2.size(); i++) {
					row1[0] = tblData2.get(i).get(0);
					row1[1] = tblData2.get(i).get(1);
					row1[2] = tblData2.get(i).get(2);
					row1[3] = tblData2.get(i).get(3);
					row1[4] = tblData2.get(i).get(4);
					row1[5] = tblData2.get(i).get(5);
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
		SecPage.getContentPane().add(addResTenBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuildingExecMenu Bem = new BuildingExecMenu(buildingName);
				setOriginalFrame(SecPage);
				setTargetedFrame(Bem.buildExec);
				navigatePage();

			}
		});
		SecPage.getContentPane().add(backBtn);


	}

}
