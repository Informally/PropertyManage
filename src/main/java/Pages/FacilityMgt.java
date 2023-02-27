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

public class FacilityMgt extends PageUtils{

	public JFrame FacMgtPage;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacilityMgt window = new FacilityMgt(null);
					window.FacMgtPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FacilityMgt(String adminName) {
		initialize(adminName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String adminName) {
		FacMgtPage = new JFrame();
		FacMgtPage.setTitle("Facility Management");
		FacMgtPage.setBounds(100, 100, 871, 622);
		FacMgtPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FacMgtPage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(adminName + "- Facility Management");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(34, 5, 665, 81);
		FacMgtPage.getContentPane().add(lblNewLabel);

		// Facility ID
		JLabel lblFACID = new JLabel("Facility ID: ");
		lblFACID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblFACID.setBounds(44, 73, 315, 42);
		FacMgtPage.getContentPane().add(lblFACID);

		JTextField txtFACID = new JTextField("");
		txtFACID.setBounds(164, 73, 250, 42);
		txtFACID.setBackground(Color.lightGray);
		txtFACID.setEditable(false);
		FacMgtPage.getContentPane().add(txtFACID);

		// Facility Name
		JLabel lblName = new JLabel("Facility Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		FacMgtPage.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		FacMgtPage.getContentPane().add(txtName);

		// Location
		JLabel lblLocation = new JLabel("Location: ");
		lblLocation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblLocation.setBounds(44, 123, 315, 42);
		FacMgtPage.getContentPane().add(lblLocation);

		JTextField txtLocation = new JTextField();
		txtLocation.setBounds(164, 123, 250, 42);
		FacMgtPage.getContentPane().add(txtLocation);

		// Status
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblStatus.setBounds(434, 123, 315, 42);
		FacMgtPage.getContentPane().add(lblStatus);
                
                
		JTextField txtStatus = new JTextField();
		txtStatus.setBounds(554, 123, 250, 42);
		FacMgtPage.getContentPane().add(txtStatus);

		// Age
		//JLabel lblAge = new JLabel("Age: ");
		//lblAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		//lblAge.setBounds(44, 173, 315, 42);
		//FacMgtPage.getContentPane().add(lblAge);

		//JTextField txtAge = new JTextField();
		//txtAge.setBounds(164, 173, 250, 42);
		//FacMgtPage.getContentPane().add(txtAge);

		// Job Role
		//JLabel lblJob = new JLabel("Job Role: ");
		//lblJob.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		//lblJob.setBounds(434, 173, 315, 42);
		//FacMgtPage.getContentPane().add(lblJob);

		//JTextField txtJob = new JTextField();
		//txtJob.setBounds(554, 173, 250, 42);
		//FacMgtPage.getContentPane().add(txtJob);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		FacMgtPage.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("Facility.txt");
		String row[] = new String[4];
		String column[] = { "Facility Id", "Facility Name", "Location", "Status"};

		JTable jTable = new JTable();
		jTable.setBounds(44, 173, 770, 250);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setColumnIdentifiers(column);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData.size(); i++) {
			row[0] = tblData.get(i).get(0);
			row[1] = tblData.get(i).get(1);
			row[2] = tblData.get(i).get(2);
			row[3] = tblData.get(i).get(3);
			//row[4] = tblData.get(i).get(4);
			//row[5] = tblData.get(i).get(5);
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
					txtFACID.setText((String) jTable.getValueAt(row[0], 0));
					txtName.setText((String) jTable.getValueAt(row[0], 1));
					txtLocation.setText((String) jTable.getValueAt(row[0], 2));
					txtStatus.setText((String) jTable.getValueAt(row[0], 3));
					//txtAge.setText((String) jTable.getValueAt(row[0], 4));
					//txtJob.setText((String) jTable.getValueAt(row[0], 5));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 273, 770, 250);
		FacMgtPage.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		FacMgtPage.getContentPane().add(calErrorText);

		
		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(44, 530, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String facid = txtFACID.getText().trim();
				
				crud.delete("Facility.txt", facid, 0, "", 0);
				
				// Refresh the data in table
				tblData = crud.read("Facility.txt");
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
					//row[4] = tblData.get(i).get(4);
					//row[5] = tblData.get(i).get(5);
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
		FacMgtPage.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(254, 223, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtFACID.setText("");
				txtName.setText("");
				txtLocation.setText("");
				txtStatus.setText("");
				//txtAge.setText("");
				//txtAge.setText("");
			}
		});
		FacMgtPage.getContentPane().add(clearBtn);

		// Add Facility Btn
		JButton addResTenBtn = new JButton("Save Facility");
		addResTenBtn.setBounds(44, 223, 200, 42);
		addResTenBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addResTenBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String facid = txtFACID.getText().trim();
				String name = txtName.getText().trim();
				String location = txtLocation.getText().trim();
				String status = txtStatus.getText().trim();
				//String age = txtAge.getText().trim();
				//String job = txtJob.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (facid.isEmpty()) { // this means new data is added
					String id = uuid.toString();
					data.add(id);
					data.add(name);
					data.add(location);
					data.add(status);
					//data.add(age);
					//data.add(job);

					crud.create("Facility.txt", data);

				} 
                                else { // this means update data
					data.add(facid);
					data.add(name);
					data.add(location);
					data.add(status);
					//data.add(age);
					//data.add(job);
					crud.updateRow("Facility.txt", facid, 0, "", 0, data);
				} 
                                
         
				// Clear text after update or add
				txtFACID.setText("");
				txtName.setText("");
				txtLocation.setText("");
				txtStatus.setText("");
				//txtAge.setText("");
				//txtJob.setText("");

				// Refresh the data in table
				tblData = crud.read("Facility.txt");
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
					//row[4] = tblData.get(i).get(4);
					//row[5] = tblData.get(i).get(5);
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
		FacMgtPage.getContentPane().add(addResTenBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminExecMenu Aem = new AdminExecMenu(adminName);
				setOriginalFrame(FacMgtPage);
				setTargetedFrame(Aem.Aem);
				navigatePage();

			}
		});
		FacMgtPage.getContentPane().add(backBtn);


	}

}
