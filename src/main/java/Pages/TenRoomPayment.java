package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TenRoomPayment extends PageUtils{

	public JFrame rp;
	JOptionPane contentPane;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();
	ArrayList<ArrayList<String>> tblDataHistory = new ArrayList<>();
	ArrayList<ArrayList<String>> tblCard = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TenRoomPayment window = new TenRoomPayment();
					window.rp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TenRoomPayment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rp = new JFrame();
		rp.setTitle("Tenant Room Payment");
		rp.setBounds(100, 100, 1000, 700);
		rp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rp.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Tenant Room Payment");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rp.getContentPane().add(lblNewLabel);

		// Payment ID
		JLabel lblUID = new JLabel("Room ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		rp.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setBackground(Color.lightGray);
		txtUID.setEditable(false);
		rp.getContentPane().add(txtUID);

		// Month
		JLabel lblMonth = new JLabel("Month: ");
		lblMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblMonth.setBounds(434, 73, 315, 42);
		rp.getContentPane().add(lblMonth);

		JTextField txtMonth = new JTextField();
		txtMonth.setBounds(554, 73, 250, 42);
		txtMonth.setBackground(Color.lightGray);
		txtMonth.setEditable(false);
		rp.getContentPane().add(txtMonth);

		// Room Type
		JLabel lblRoomType = new JLabel("Room Type: ");
		lblRoomType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRoomType.setBounds(44, 123, 315, 42);
		rp.getContentPane().add(lblRoomType);

		JTextField txtRoomType = new JTextField();
		txtRoomType.setBounds(164, 123, 250, 42);
		txtRoomType.setBackground(Color.lightGray);
		txtRoomType.setEditable(false);
		rp.getContentPane().add(txtRoomType);

		// Year
		JLabel lblYear = new JLabel("Year: ");
		lblYear.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblYear.setBounds(434, 123, 315, 42);
		rp.getContentPane().add(lblYear);

		JTextField txtYear = new JTextField();
		txtYear.setBounds(554, 123, 250, 42);
		txtYear.setBackground(Color.lightGray);
		txtYear.setEditable(false);
		rp.getContentPane().add(txtYear);

		// Price
		JLabel lblPrice = new JLabel("Price:       RM");
		lblPrice.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPrice.setBounds(44, 173, 315, 42);
		rp.getContentPane().add(lblPrice);

		JTextField txtPrice = new JTextField();
		txtPrice.setBounds(164, 173, 250, 42);
		txtPrice.setBackground(Color.lightGray);
		txtPrice.setEditable(false);
		rp.getContentPane().add(txtPrice);

		// Outstanding
		JLabel lblOut = new JLabel("Outstanding:RM");
		lblOut.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblOut.setBounds(44, 273, 315, 42);
		rp.getContentPane().add(lblOut);

		JTextField txtOut = new JTextField();
		txtOut.setBounds(164, 273, 250, 42);
		txtOut.setBackground(Color.lightGray);
		txtOut.setEditable(false);
		rp.getContentPane().add(txtOut);
		
		// Deposit
		JLabel lblDeposit = new JLabel("Deposit:   RM");
		lblDeposit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDeposit.setBounds(44, 223, 315, 42);
		rp.getContentPane().add(lblDeposit);

		JTextField txtDeposit = new JTextField();
		txtDeposit.setBounds(164, 223, 250, 42);
		txtDeposit.setBackground(Color.lightGray);
		txtDeposit.setEditable(false);
		rp.getContentPane().add(txtDeposit);
		
		// Card Number
		JLabel lblCard = new JLabel("Card No: ");
		lblCard.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCard.setBounds(434, 173, 315, 42);
		rp.getContentPane().add(lblCard);

		JTextField txtCard = new JTextField();
		txtCard.setBounds(554, 173, 250, 42);
		rp.getContentPane().add(txtCard);
		
		// Expiration Date
		JLabel lblDate = new JLabel("Expiry Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(434, 223, 315, 42);
		rp.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(554, 223, 100, 42);
		rp.getContentPane().add(txtDate);

		//Name
		JLabel lblname = new JLabel("Name: ");
		lblname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblname.setBounds(434, 273, 315, 42);
		rp.getContentPane().add(lblname);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 273, 250, 42);
		txtName.setBackground(Color.lightGray);
		txtName.setEditable(false);
		rp.getContentPane().add(txtName);
		
		
		// CCV
		JLabel lblCcv = new JLabel("CCV: ");
		lblCcv.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCcv.setBounds(654, 223, 315, 42);
		rp.getContentPane().add(lblCcv);

		JTextField txtCcv = new JTextField();
		txtCcv.setBounds(704, 223, 100, 42);
		rp.getContentPane().add(txtCcv);
		
		// Amount
		JLabel lblAmount = new JLabel("Amount:   RM ");
		lblAmount.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblAmount.setBounds(434, 323, 315, 42);
		rp.getContentPane().add(lblAmount);

		JTextField txtAmount = new JTextField();
		txtAmount.setBounds(554, 323, 250, 42);
		rp.getContentPane().add(txtAmount);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		rp.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("BookingRoom.txt");
		String row[] = new String[8];
		String column[] = { "Room Id", "Name", "Room Type", "Room Price", "Deposit", "Outstanding", "Month", "Year" };

		JTable jTable = new JTable();
		jTable.setBounds(44, 323, 770, 100);
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
					txtName.setText((String) jTable.getValueAt(row[0], 1));
					txtRoomType.setText((String) jTable.getValueAt(row[0], 2));
					txtPrice.setText((String) jTable.getValueAt(row[0], 3));
					txtDeposit.setText((String) jTable.getValueAt(row[0], 4));
					txtOut.setText((String) jTable.getValueAt(row[0], 5));
					txtMonth.setText((String) jTable.getValueAt(row[0], 6));
					txtYear.setText((String) jTable.getValueAt(row[0], 7));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 373, 770, 100);
		rp.getContentPane().add(scroll);
//		

		// Payment Display
		CRUD newCrud = new CRUD();
		tblDataHistory = newCrud.read("ResidentPaymentHistory.txt");
		String rowPayment[] = new String[11];
		String columnPayment[] = { "Room Id", "Name", "Room Type","Room Price", "Deposit" , "Outstanding", "Total Paid", "Month", "Year", "Payment ID", "Date" };

		JTable jTablePayment = new JTable();
		jTablePayment.setBounds(44, 423, 770, 100);
		DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
		tableModelPayment.setColumnIdentifiers(columnPayment);
		jTablePayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable.setRowSelectionAllowed(false);
		System.out.print(tblDataHistory);

		for (int i = 0; i < tblDataHistory.size(); i++) {
			rowPayment[0] = tblDataHistory.get(i).get(0);
			rowPayment[1] = tblDataHistory.get(i).get(1);
			rowPayment[2] = tblDataHistory.get(i).get(2);
			rowPayment[3] = tblDataHistory.get(i).get(3);
			rowPayment[4] = tblDataHistory.get(i).get(4);
			rowPayment[5] = tblDataHistory.get(i).get(5);
			rowPayment[6] = tblDataHistory.get(i).get(6);
			rowPayment[7] = tblDataHistory.get(i).get(7);
			rowPayment[8] = tblDataHistory.get(i).get(8);
                        rowPayment[9] = tblDataHistory.get(i).get(9);
                        rowPayment[10] = tblDataHistory.get(i).get(10);
			tableModelPayment.addRow(rowPayment);

		}
		jTablePayment.setModel(tableModelPayment);

		JScrollPane scrollPayment = new JScrollPane(jTablePayment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPayment.setBounds(44, 503, 770, 100);
		rp.getContentPane().add(scrollPayment);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		rp.getContentPane().add(calErrorText);

		// Make Payment Button
		JButton makepaymentBtn = new JButton("Make Payment");
		makepaymentBtn.setBounds(44, 323, 170, 42);
		makepaymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		makepaymentBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CRUD crudCard = new CRUD();

                                tblCard = crudCard.readBulk("Card.txt", txtCard.getText().trim(), 0, "",0);

                                if(tblCard.size() == 0){
                                    ArrayList<String> cardDetails = new ArrayList<>();
                                    cardDetails.add(txtCard.getText().trim());
                                    cardDetails.add(txtDate.getText().trim());
                                    cardDetails.add(txtCcv.getText().trim());

                                    crud.create("Card.txt", cardDetails);
                                }
					
				User user = new User();
				UUID uuid = UUID.randomUUID();

				String userID = txtUID.getText().trim();
                                String name = txtName.getText().trim();
                                String roomType = txtRoomType.getText().trim();
				String month = txtMonth.getText().trim();
				String price = txtPrice.getText().trim();
				String out = txtOut.getText().trim();
				String deposit = txtDeposit.getText().trim();
				String year = txtYear.getText().trim();
				String amount = txtAmount.getText().trim();

				ArrayList<String> data = new ArrayList<>();
				ArrayList<String> dataReceipt = new ArrayList<>();
				ArrayList<String> dataMonthly = new ArrayList<>();
                ArrayList<String> dataIs = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String uid = uuid.toString();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDateTime now = LocalDateTime.now();
				data.add(uid);
                                data.add(name);
				data.add(roomType);
                                data.add(price);
                                data.add(deposit);
                                data.add(out);
				data.add(amount);
				data.add(month);
				data.add(year);
				data.add(userID);
				data.add(dtf.format(now));
				
				dataReceipt.add(uid);
                                dataReceipt.add(name);
				dataReceipt.add(roomType);
				dataReceipt.add(price);
				dataReceipt.add(deposit);
				dataReceipt.add(amount);
				dataReceipt.add(month);
				dataReceipt.add(year);
				dataReceipt.add(dtf.format(now));
				
				dataMonthly.add(uid);
                                dataMonthly.add(name);
				dataMonthly.add(roomType);
				dataMonthly.add(price);
				dataMonthly.add(price);
				dataMonthly.add(month);
				dataMonthly.add(year);
				dataMonthly.add(dtf.format(now));
                                
                dataIs.add(uid);
                dataIs.add(name);
                dataIs.add("Monthly");
                dataIs.add(roomType);
                dataIs.add(price);
                dataIs.add(dtf.format(now));

				crud.create("ResidentPaymentHistory.txt", data);
				crud.create("RoomReceipt.txt", dataReceipt);
				crud.create("MonthlyPayment.txt", dataMonthly);
                crud.create("ResidentInvoiceStatement.txt", dataIs);
				// Update the debt value
				int totalDebt = Integer.parseInt(out) - Integer.parseInt(amount);
				crud.update("BookingRoom.txt", userID, 0, "", 0, String.valueOf(totalDebt), 5, "", 0);

				crud.update("ResidentPaymentHistory.txt", uid, 0,"", 0, String.valueOf(totalDebt), 5, "", 0);
				crud.update("ResidentPaymentHistory.txt", uid, 0,"", 0, String.valueOf(amount), 6, "", 0);
                crud.update("ResidentInvoiceStatement.txt", userID, 0,"", 0, String.valueOf(totalDebt), 4, "", 0);

				// Clear text after update or add
				txtUID.setText("");
				txtMonth.setText("");
				txtPrice.setText("");
				txtRoomType.setText("");
				txtDeposit.setText("");
				txtYear.setText("");
				txtOut.setText("");
				txtCard.setText("");
				txtDate.setText("");
				txtCcv.setText("");
				txtAmount.setText("");

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

				tblDataHistory = crud.read("ResidentPaymentHistory.txt");
				DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
				tableModelPayment.setColumnIdentifiers(columnPayment);
				tableModelPayment.getDataVector().removeAllElements();
				jTablePayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				System.out.print(tblDataHistory);
				for (int i = 0; i < tblDataHistory.size(); i++) {
					rowPayment[0] = tblDataHistory.get(i).get(0);
					rowPayment[1] = tblDataHistory.get(i).get(1);
					rowPayment[2] = tblDataHistory.get(i).get(2);
					rowPayment[3] = tblDataHistory.get(i).get(3);
					rowPayment[4] = tblDataHistory.get(i).get(4);
					rowPayment[5] = tblDataHistory.get(i).get(5);
					rowPayment[6] = tblDataHistory.get(i).get(6);
					rowPayment[7] = tblDataHistory.get(i).get(7);
                                        rowPayment[8] = tblDataHistory.get(i).get(8);
                                        rowPayment[9] = tblDataHistory.get(i).get(9);
                                        rowPayment[10] = tblDataHistory.get(i).get(10);
					tableModelPayment.addRow(rowPayment);

				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jTablePayment.updateUI();

			}
		});
		rp.getContentPane().add(makepaymentBtn);
		
		// View Receipt Button
		JButton viewReceiptBtn = new JButton("View Receipt");
		viewReceiptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = jTablePayment.getSelectedRow();
				DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
				String uid = tableModelPayment.getValueAt(i, 0).toString();
                                String name = tableModelPayment.getValueAt(i, 1).toString();
				String roomType = tableModelPayment.getValueAt(i, 2).toString();
                                String roomPrice = tableModelPayment.getValueAt(i, 3).toString();
                                String deposit = tableModelPayment.getValueAt(i, 4).toString();
				String out = tableModelPayment.getValueAt(i, 5).toString();
				String amount = tableModelPayment.getValueAt(i, 6).toString();
				String month = tableModelPayment.getValueAt(i, 7).toString();
				String year = tableModelPayment.getValueAt(i, 8).toString();
				String userID = tableModelPayment.getValueAt(i, 9).toString();
				String dtf = tableModelPayment.getValueAt(i, 10).toString();
				
                                // Receipt Display
				String receipt = "\t\t                         <----- Receipt ----->\n";
				String lblpaymentId = "\tPayment ID:";
				String paymentId = uid + "\n\n\tDescription\t\t\t                             Price(RM)\n\t---------------\t\t\t                                -----------\n";
				String lblName = "\tName ("+ name + ")\n";
                                String lblRoomType = "\tRoom Type ("+ roomType + ")\n";
				String lblPrice = "\tRoom Price" + "\t\t\t" + "                                   " + roomPrice + "\n";
                                String lblDeposit = "\tDeposit" + "\t\t\t" + "                                           " + deposit + "\n";
				String lblTotal = "\t---------------------------------------------------------------\n\tTotal Paid" + "\t\t\t" + "                                      " + amount + "\n";
                                String lblOut = "\tOutstanding" + "\t\t\t" + "                                       " + out + "\n";
				String lblPaymentDate = "\tPayment for " + month + " " + year + "\n";
				String lblDate = "\tDate Paid " + dtf + "\n\t---------------------------------------------------------------" + "\n";
				String lblThank = "\t                  Thank you for your payment\n";
				JOptionPane.showMessageDialog(null, receipt + lblpaymentId + paymentId + lblName + lblRoomType + lblPrice + lblDeposit + lblTotal + lblOut + lblPaymentDate + lblDate + lblThank, "Receipt", JOptionPane.INFORMATION_MESSAGE);
                                
			}
		});
		viewReceiptBtn.setBounds(234, 323, 170, 42);
		viewReceiptBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		rp.getContentPane().add(viewReceiptBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(650, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResPaymentMenu pm = new ResPaymentMenu();
                                setOriginalFrame(rp);
				setTargetedFrame(pm.pm);
				navigatePage();

			}
		});
		rp.getContentPane().add(backBtn);

	}
}
