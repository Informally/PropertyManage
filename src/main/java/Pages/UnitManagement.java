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

import Data.Unit;
import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

public class UnitManagement extends PageUtils{

	public JFrame unitMgtPage;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnitManagement window = new UnitManagement(null);
					window.unitMgtPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnitManagement(String adminName) {
		initialize(adminName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String adminName) {
		unitMgtPage = new JFrame();
		unitMgtPage.setTitle("Unit Management");
		unitMgtPage.setBounds(300, 250, 1000, 650);
		unitMgtPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unitMgtPage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(adminName + "- Unit Management");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		lblNewLabel.setBounds(34, 8, 665, 81);
		unitMgtPage.getContentPane().add(lblNewLabel);
                
                //No
		JLabel lblNo = new JLabel("No.: ");
		lblNo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblNo.setBounds(380, 12, 315, 42);
		unitMgtPage.getContentPane().add(lblNo);

		JTextField txtNo = new JTextField("");
		txtNo.setBounds(420, 12, 250, 42);
		txtNo.setBackground(Color.lightGray);
		txtNo.setEditable(false);
		unitMgtPage.getContentPane().add(txtNo);
                
		// Unit No
		JLabel lblUNO = new JLabel("Unit No: ");
		lblUNO.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUNO.setBounds(44, 73, 315, 42);
		unitMgtPage.getContentPane().add(lblUNO);

		JTextField txtUnitNo = new JTextField();
		txtUnitNo.setBounds(164, 73, 250, 42);
		unitMgtPage.getContentPane().add(txtUnitNo);

		// Floor No
		JLabel lblFNO= new JLabel("Floor No: ");
		lblFNO.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblFNO.setBounds(434, 73, 315, 42);
		unitMgtPage.getContentPane().add(lblFNO);

		JTextField txtFloorNo = new JTextField();
		txtFloorNo.setBounds(554, 73, 250, 42);
		unitMgtPage.getContentPane().add(txtFloorNo);

		// Address
		JLabel lblADD = new JLabel("Address: ");
		lblADD.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblADD.setBounds(44, 123, 315, 42);
		unitMgtPage.getContentPane().add(lblADD);

		JTextField txtAddress = new JTextField();
		txtAddress.setBounds(164, 123, 250, 42);
		unitMgtPage.getContentPane().add(txtAddress);

		// Unit Type
		JLabel lblUNITYP = new JLabel("Unit Type: ");
		lblUNITYP.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUNITYP.setBounds(434, 123, 315, 42);
		unitMgtPage.getContentPane().add(lblUNITYP);

		JTextField txtUnitType = new JTextField();
		txtUnitType.setBounds(554, 123, 250, 42);
		unitMgtPage.getContentPane().add(txtUnitType);

		// Status
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblStatus.setBounds(44, 173, 315, 42);
		unitMgtPage.getContentPane().add(lblStatus);

		JTextField txtStatus= new JTextField();
		txtStatus.setBounds(164, 173, 250, 42);
		unitMgtPage.getContentPane().add(txtStatus);

		// Price
		JLabel lblPrice = new JLabel("Price: ");
		lblPrice.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPrice.setBounds(434, 173, 315, 42);
		unitMgtPage.getContentPane().add(lblPrice);

		JTextField txtPrice = new JTextField();
		txtPrice.setBounds(554, 173, 250, 42);
		unitMgtPage.getContentPane().add(txtPrice);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		unitMgtPage.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("Unit.txt");
		String row[] = new String[7];
		String column[] = {"No.", "Unit No", "Floor No", "Address", "Unit Type", "Status", "Price"};

		JTable jTable = new JTable();
		jTable.setBounds(44, 273, 900, 250);
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
					txtNo.setText((String) jTable.getValueAt(row[0], 0));
					txtUnitNo.setText((String) jTable.getValueAt(row[0], 1));
					txtFloorNo.setText((String) jTable.getValueAt(row[0], 2));
					txtAddress.setText((String) jTable.getValueAt(row[0], 3));
					txtUnitType.setText((String) jTable.getValueAt(row[0], 4));
					txtStatus.setText((String) jTable.getValueAt(row[0], 5));
                                        txtPrice.setText((String) jTable.getValueAt(row[0], 6));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 273, 900, 250);
		unitMgtPage.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		unitMgtPage.getContentPane().add(calErrorText);

		
		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(44, 530, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String no = txtNo.getText().trim();
				
				crud.delete("Unit.txt", no, 0, "", 0);
				
				// Refresh the data in table
				tblData = crud.read("Unit.txt");
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
		unitMgtPage.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 223, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                                txtNo.setText("");	
                                txtUnitNo.setText("");
				txtFloorNo.setText("");
				txtAddress.setText("");
				txtUnitType.setText("");
				txtStatus.setText("");
				txtPrice.setText("");
			}
		});
		unitMgtPage.getContentPane().add(clearBtn);

		// Add unit Btn
		JButton addUnitBtn = new JButton("Add Unit");
		addUnitBtn.setBounds(44, 223, 150, 42);
		addUnitBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUnitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Unit unit = new Unit();
				UUID uuid = UUID.randomUUID();
                                
                                String record = txtNo.getText().trim();
				String unitNo = txtUnitNo.getText().trim();
				String floorNo = txtFloorNo.getText().trim();
				String address = txtAddress.getText().trim();
				String unitType = txtUnitType.getText().trim();
				String status = txtStatus.getText().trim();
				String price = txtPrice.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (record.isEmpty()) { // this means new data is added
                                    String no = uuid.toString();
                                    data.add(no);
                                    data.add(unitNo);
                                    data.add(floorNo);
                                    data.add(address);
                                    data.add(unitType);
                                    data.add(status);
                                    data.add(price);
                                    
                                    crud.create("Unit.txt", data);
                                    
                                } else { // this means update data
                                    data.add(record);
                                    data.add(unitNo);
                                    data.add(floorNo);
                                    data.add(address);
                                    data.add(unitType);
                                    data.add(status);
                                    data.add(price);
                                    crud.updateRow("Unit.txt", record, 0, "", 0, data);
                                }

				// Clear text after update or add
                                txtNo.setText("");
				txtUnitNo.setText("");
				txtFloorNo.setText("");
				txtAddress.setText("");
				txtUnitType.setText("");
				txtStatus.setText("");
				txtPrice.setText("");

				// Refresh the data in table
				tblData = crud.read("Unit.txt");
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
		unitMgtPage.getContentPane().add(addUnitBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminExecMenu Aem = new AdminExecMenu(adminName);
                                setOriginalFrame(unitMgtPage);
				setTargetedFrame(Aem.Aem);
				navigatePage();
				//Aem.Aem.setVisible(true);
				//unitMgtPage.setVisible(false);

			}
		});
		unitMgtPage.getContentPane().add(backBtn);


	}

}
