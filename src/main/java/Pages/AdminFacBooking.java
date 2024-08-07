package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.UUID;

public class AdminFacBooking extends PageUtils{

	public JFrame afb;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFacBooking window = new AdminFacBooking(null);
					window.afb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminFacBooking(String adminName) {
		initialize(adminName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String adminName) {
		afb = new JFrame();
		afb.setTitle("Facility Booking");
		afb.setBounds(100, 100, 900, 550);
		afb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set as non resizable
		afb.setResizable(false);
		afb.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(adminName + "- Facility Booking");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		afb.getContentPane().add(lblNewLabel);

		// UID
		JLabel lblUID = new JLabel("UID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		afb.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(174, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		afb.getContentPane().add(txtUID);

		// Name
		JLabel lblFacility = new JLabel("Name: ");
		lblFacility.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblFacility.setBounds(444, 73, 315, 42);
		afb.getContentPane().add(lblFacility);

		JTextField txtFacility = new JTextField(adminName);
		txtFacility.setBounds(584, 73, 250, 42);
		txtFacility.setEditable(false);
		afb.getContentPane().add(txtFacility);

		// Facility Type
		JLabel lblFacilityType = new JLabel("Facility Type:");
		lblFacilityType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblFacilityType.setBounds(44, 123, 315, 42);
		afb.getContentPane().add(lblFacilityType);

		JComboBox<String> txtFacilityType = new JComboBox<>();
		txtFacilityType.setBounds(174, 123, 250, 42);
		txtFacilityType.addItem("Swimming Pool");
		txtFacilityType.addItem("Barbeque Pit");
		txtFacilityType.addItem("Gym Room");
		txtFacilityType.addItem("Meeting Room");
		afb.getContentPane().add(txtFacilityType);
		
		// Facility Price
		JLabel lblPrice = new JLabel("Facility Price: ");
		lblPrice.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPrice.setBounds(444, 123, 315, 42);
		afb.getContentPane().add(lblPrice);

		JTextField txtPrice = new JTextField();
		txtPrice.setBounds(584, 123, 250, 42);
		txtPrice.setBackground(Color.white);
		txtPrice.setEditable(false);
		afb.getContentPane().add(txtPrice);

		// Date
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(44, 173, 315, 42);
		afb.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(174, 173, 250, 42);
		afb.getContentPane().add(txtDate);

		// Duration
		JLabel lblDuration = new JLabel("Duration(hours):");
		lblDuration.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDuration.setBounds(444, 173, 315, 42);
		afb.getContentPane().add(lblDuration);

		JComboBox<String> txtDuration = new JComboBox<>();
		txtDuration.setBounds(584, 173, 250, 42);
		txtDuration.addItem("1");
		txtDuration.addItem("2");
		txtDuration.addItem("3");
		txtDuration.addItem("5");
		afb.getContentPane().add(txtDuration);
		
		//Time
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTime.setBounds(44, 223, 315, 42);
		afb.getContentPane().add(lblTime);

		JTextField txtTime = new JTextField();
		txtTime.setBounds(174, 223, 250, 42);
		afb.getContentPane().add(txtTime);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 273, 330, 42);
		errorText.setVisible(false);
		afb.getContentPane().add(errorText);
		
		txtFacilityType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) txtFacilityType.getSelectedItem()) {
				
                    case "Swimming Pool":
					
					ArrayList<ArrayList<String>> statementData = crud.read("FacilityPrice.txt");
					
					for (ArrayList<String> row : statementData) {
						if(row.get(0).equals("Swimming Pool")) {                                                 
                                                txtPrice.setText(row.get(1));
                                                }
                                                
					}
                            
					break;
					
                    case "Barbeque Pit":
    					
    					statementData = crud.read("FacilityPrice.txt");
    					
    					for (ArrayList<String> row : statementData) {
    						if(row.get(0).equals("Barbeque Pit")) {
    						txtPrice.setText(row.get(1));
    						}
    					}
    					break;
                        
                        case "Gym Room":
    					
    					statementData = crud.read("FacilityPrice.txt");
    					
    					for (ArrayList<String> row : statementData) {
    						if(row.get(0).equals("Gym Room")) {
    						txtPrice.setText(row.get(1));
    						}
    					}
    					break;	
    					
                        case "Meeting Room":
        					
        					statementData = crud.read("FacilityPrice.txt");
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(0).equals("Meeting Room")) {
        						txtPrice.setText(row.get(1));
        						}
        					}
        					break;
				
				
				}

			}
		});

		// Result Display
		tblData = crud.read("FacilityBooking.txt");
		String row[] = new String[8];
		String column[] = {"Facility ID", "Facility Type", "Name", "Facility Price", "Duration", "Total Price", "Date", "Time" };

		JTable jTable = new JTable();
		jTable.setBounds(44, 323, 770, 150);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setColumnIdentifiers(column);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData.size(); i++) {
			row[0] = tblData.get(i).get(0);
			row[1] = tblData.get(i).get(2);
			row[2] = tblData.get(i).get(1);
			row[3] = tblData.get(i).get(3);
			row[4] = tblData.get(i).get(4);
			row[5] = tblData.get(i).get(5);
			row[6] = tblData.get(i).get(6);
            row[7] = tblData.get(i).get(7);
			//tableModel.addRow(row);
			// Check if the row contains the search string
			boolean match = false;
			for (int j = 0; j < row.length; j++) {
				if (row[j].toLowerCase().contains(adminName.toLowerCase())) {
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
					txtFacility.setText((String) jTable.getValueAt(row[0], 2));
					txtFacilityType.setToolTipText((String) jTable.getValueAt(row[0], 1));
					txtPrice.setText((String) jTable.getValueAt(row[0], 3));					
					txtDuration.setToolTipText((String) jTable.getValueAt(row[0], 4));
					txtDate.setText((String) jTable.getValueAt(row[0], 6));
					txtTime.setText((String) jTable.getValueAt(row[0], 7));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 323, 770, 150);
		afb.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		afb.getContentPane().add(calErrorText);

		
		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(364, 273, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uid = txtUID.getText().trim();
				
				crud.delete("FacilityBooking.txt", uid, 0, "", 0);
				
				// Refresh the data in table
				tblData = crud.read("FacilityBooking.txt");
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
					// Check if the row contains the search string
					boolean match = false;
					for (int j = 0; j < row.length; j++) {
						if (row[j].toLowerCase().contains(adminName.toLowerCase())) {
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
		afb.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 273, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtFacility.setText(adminName);
				txtDate.setText("");
				txtPrice.setText("");
				txtFacilityType.setSelectedIndex(-1);
				txtDuration.setSelectedIndex(-1);
				txtTime.setText("");
			}
		});
		afb.getContentPane().add(clearBtn);

		// Add user Btn
		JButton addUserBtn = new JButton("Save");
		addUserBtn.setBounds(44, 273, 150, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();
				//DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
				//DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");
				
				String userId = txtUID.getText().trim();
				String facility = txtFacility.getText().trim();
				String date = txtDate.getText().trim();
				String duration = txtDuration.getSelectedItem().toString().trim();
				String price = txtPrice.getText().trim();
				String facilityType = txtFacilityType.getSelectedItem().toString().trim();
				String time = txtTime.getText().trim();
                                int totalPrice = Integer.parseInt(price) * Integer.parseInt(duration);
				
				ArrayList<String> data = new ArrayList<>();
                                ArrayList<String> dataIs = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (userId.isEmpty()) { // this means new data is added
					String uid = uuid.toString();
					data.add(uid);
					data.add(facility);
					data.add(facilityType);
					data.add(price);
					data.add(duration);
                    data.add(String.valueOf(totalPrice));
                    data.add(date);
                    data.add(time);
                                        
                    // dataIs.add(uid);
					// dataIs.add(facility);
                    // dataIs.add("Facility");
                    // dataIs.add(facilityType);
                    // dataIs.add(String.valueOf(totalPrice));
                    // dataIs.add(date);

					crud.create("FacilityBooking.txt", data);
                    //crud.create("ResidentInvoiceStatement.txt", dataIs);

				} else { // this means update data
					data.add(userId);
					data.add(facility);
					data.add(facilityType);
					data.add(price);
					data.add(duration);
                                        data.add(String.valueOf(totalPrice));
                                        data.add(date);
                                        data.add(time);
                                        
                                        // dataIs.add(userId);
                                        // dataIs.add("Facility");
                                        // dataIs.add(facilityType);
                                        // dataIs.add(String.valueOf(totalPrice));
                                        // dataIs.add(date);
                                        
					crud.updateRow("FacilityBooking.txt", userId, 0, "", 0, data);
                                        // crud.updateRow("ResidentInvoiceStatement.txt", userId, 0, "", 0, dataIs);
				}

				// close the current window and open the new one
				AdminExecMenu aem = new AdminExecMenu(adminName);
				setOriginalFrame(afb);
				setTargetedFrame(aem.Aem);
				navigatePage();

				

				// Clear text after update or add
				txtUID.setText("");
				txtFacility.setText(adminName);
				txtDate.setText("");
				txtPrice.setText("");
				txtFacilityType.setSelectedIndex(-1);
				txtDuration.setSelectedIndex(-1);
				txtTime.setText("");

				// Refresh the data in table
				tblData = crud.read("FacilityBooking.txt");
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
					// Check if the row contains the search string
					boolean match = false;
					for (int j = 0; j < row.length; j++) {
						if (row[j].toLowerCase().contains(adminName.toLowerCase())) {
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
		afb.getContentPane().add(addUserBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminExecMenu Aem = new AdminExecMenu(adminName);
				setOriginalFrame(afb);
				setTargetedFrame(Aem.Aem);
				navigatePage();

			}
		});
		afb.getContentPane().add(backBtn);


	}

	protected void setVisible(boolean b) {
	}
}
