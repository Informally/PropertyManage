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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class TenBookingRoom extends PageUtils{

	public JFrame br;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TenBookingRoom window = new TenBookingRoom();
					window.br.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TenBookingRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		br = new JFrame();
		br.setTitle("Tenant Booking Room");
		br.setBounds(100, 100, 900, 822);
		br.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		br.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Tenant Booking Room");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		br.getContentPane().add(lblNewLabel);

		// Room ID
		JLabel lblUID = new JLabel("Room ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		br.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(174, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		br.getContentPane().add(txtUID);

		// Room No
		JLabel lblRoom = new JLabel("Room No: ");
		lblRoom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRoom.setBounds(444, 73, 315, 42);
		br.getContentPane().add(lblRoom);

		JTextField txtRoom = new JTextField();
		txtRoom.setBounds(584, 73, 250, 42);
		br.getContentPane().add(txtRoom);

		// Room Type
		JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRoomType.setBounds(44, 123, 315, 42);
		br.getContentPane().add(lblRoomType);

		JComboBox<String> txtRoomType = new JComboBox<>();
		txtRoomType.setBounds(174, 123, 250, 42);
		txtRoomType.addItem("Single");
		txtRoomType.addItem("Double");
		txtRoomType.addItem("Suite");
		txtRoomType.addItem("Deluxe");
		br.getContentPane().add(txtRoomType);
		
		// Room Price
		JLabel lblPrice = new JLabel("Room Price: ");
		lblPrice.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPrice.setBounds(444, 123, 315, 42);
		br.getContentPane().add(lblPrice);

		JTextField txtPrice = new JTextField();
		txtPrice.setBounds(584, 123, 250, 42);
		txtPrice.setBackground(Color.white);
		txtPrice.setEditable(false);
		br.getContentPane().add(txtPrice);

		// Month
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblMonth.setBounds(44, 173, 315, 42);
		br.getContentPane().add(lblMonth);

		JTextField txtMonth = new JTextField();
		txtMonth.setBounds(174, 173, 250, 42);
		br.getContentPane().add(txtMonth);

		// Deposit
		JLabel lblDeposit = new JLabel("Deposit:");
		lblDeposit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDeposit.setBounds(444, 173, 315, 42);
		br.getContentPane().add(lblDeposit);

		JTextField txtDeposit = new JTextField();
		txtDeposit.setBounds(584, 173, 250, 42);
		txtDeposit.setBackground(Color.white);
		txtDeposit.setEditable(false);
		br.getContentPane().add(txtDeposit);
		
		// Year
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblYear.setBounds(44, 223, 315, 42);
		br.getContentPane().add(lblYear);

		JTextField txtYear = new JTextField();
		txtYear.setBounds(174, 223, 250, 42);
		br.getContentPane().add(txtYear);
		
		// Total
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTotal.setBounds(444, 223, 315, 42);
		br.getContentPane().add(lblTotal);

		JTextField txtTotal = new JTextField();
		txtTotal.setBounds(584, 223, 250, 42);
		txtTotal.setBackground(Color.white);
		txtTotal.setEditable(false);
		br.getContentPane().add(txtTotal);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 273, 330, 42);
		errorText.setVisible(false);
		br.getContentPane().add(errorText);
		
		txtRoomType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) txtRoomType.getSelectedItem()) {
				
                    case "Single":
					
					ArrayList<ArrayList<String>> statementData = crud.read("RoomPrice.txt");
					
					for (ArrayList<String> row : statementData) {
						if(row.get(0).equals("Single")) {
						txtPrice.setText(row.get(1));
						txtDeposit.setText(row.get(2));
						txtTotal.setText(row.get(3));
						}
					}
					break;
					
                    case "Double":
    					
    					statementData = crud.read("RoomPrice.txt");
    					
    					for (ArrayList<String> row : statementData) {
    						if(row.get(0).equals("Double")) {
    						txtPrice.setText(row.get(1));
    						txtDeposit.setText(row.get(2));
    						txtTotal.setText(row.get(3));
    						}
    					}
    					break;
                        
                        case "Suite":
    					
    					statementData = crud.read("RoomPrice.txt");
    					
    					for (ArrayList<String> row : statementData) {
    						if(row.get(0).equals("Suite")) {
    						txtPrice.setText(row.get(1));
    						txtDeposit.setText(row.get(2));
    						txtTotal.setText(row.get(3));
    						}
    					}
    					break;	
    					
                        case "Deluxe":
        					
        					statementData = crud.read("RoomPrice.txt");
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(0).equals("Deluxe")) {
        						txtPrice.setText(row.get(1));
        						txtDeposit.setText(row.get(2));
        						txtTotal.setText(row.get(3));
        						}
        					}
        					break;
				
				
				}

			}
		});

		// Result Display
		tblData = crud.read("BookingRoom.txt");
		String row[] = new String[8];
		String column[] = { "Room Id", "Room No", "Room Type", "Room Price", "Deposit", "Total", "Month", "Year" };

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
			row[7] = tblData.get(i).get(7);
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
					txtRoom.setText((String) jTable.getValueAt(row[0], 1));
					txtRoomType.setToolTipText((String) jTable.getValueAt(row[0], 2));
					txtPrice.setText((String) jTable.getValueAt(row[0], 3));					
					txtDeposit.setText((String) jTable.getValueAt(row[0], 4));
					txtTotal.setText((String) jTable.getValueAt(row[0], 5));
					txtMonth.setText((String) jTable.getValueAt(row[0], 6));
					txtYear.setText((String) jTable.getValueAt(row[0], 7));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 323, 770, 250);
		br.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		br.getContentPane().add(calErrorText);

		
		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(364, 273, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uid = txtUID.getText().trim();
				
				crud.delete("BookingRoom.txt", uid, 0, "", 0);
				
				// Refresh the data in table
				tblData = crud.read("BookingRoom.txt");
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
		br.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 273, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtRoom.setText("");
				txtMonth.setText("");
				txtPrice.setText("");
				txtRoomType.setToolTipText(null);
				txtDeposit.setText("");
				txtYear.setText("");
				txtTotal.setText("");
			}
		});
		br.getContentPane().add(clearBtn);

		// Save Btn
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
				String room = txtRoom.getText().trim();
				String month = txtMonth.getText().trim();
				String deposit = txtDeposit.getText().trim();
				String price = txtPrice.getText().trim();
				String roomType = txtRoomType.getSelectedItem().toString().trim();
				String year = txtYear.getText().trim();
				String total = txtTotal.getText().trim();
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                LocalDateTime now = LocalDateTime.now();
				
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
					data.add(room);
					data.add(roomType);
					data.add(price);
					data.add(deposit);
					data.add(total);
					data.add(month);
					data.add(year);
                                        
                                        dataIs.add(uid);
                                        dataIs.add("Room");
                                        dataIs.add(roomType);
                                        dataIs.add(total);
                                        dataIs.add(dtf.format(now));

					crud.create("BookingRoom.txt", data);
                                        crud.create("ResidentInvoiceStatement.txt", dataIs);

				} else { // this means update data
					data.add(userId);
					data.add(room);
					data.add(roomType);
					data.add(price);
					data.add(deposit);
					data.add(total);
					data.add(month);
					data.add(year);
                                       
                                        dataIs.add(userId);
                                        dataIs.add("Room");
                                        dataIs.add(roomType);
                                        dataIs.add(total);
                                        dataIs.add(dtf.format(now));
                                        
					crud.updateRow("BookingRoom.txt", userId, 0, "", 0, data);
                                        crud.updateRow("ResidentInvoiceStatement.txt", userId, 0, "", 0, dataIs);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtRoom.setText("");
				txtMonth.setText("");
				txtPrice.setText("");
				txtRoomType.setToolTipText(null);
				txtDeposit.setText("");
				txtYear.setText("");
				txtTotal.setText("");

				// Refresh the data in table
				tblData = crud.read("BookingRoom.txt");
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
		br.getContentPane().add(addUserBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResidentMenu rm = new ResidentMenu();
                                setOriginalFrame(br);
				setTargetedFrame(rm.rm);
				navigatePage();

			}
		});
		br.getContentPane().add(backBtn);


	}
}
