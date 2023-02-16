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

public class ResFacilityPayment {

	public JFrame fp;
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
					ResFacilityPayment window = new ResFacilityPayment();
					window.fp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResFacilityPayment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fp = new JFrame();
		fp.setTitle("Facility Payment");
		fp.setBounds(100, 100, 1471, 822);
		fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fp.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Facility Payment");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		fp.getContentPane().add(lblNewLabel);

		// Payment ID
		JLabel lblUID = new JLabel("Payment ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		fp.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		fp.getContentPane().add(txtUID);

		// Date
		JLabel lblDateBook = new JLabel("Date: ");
		lblDateBook.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDateBook.setBounds(434, 73, 315, 42);
		fp.getContentPane().add(lblDateBook);

		JTextField txtDateBook = new JTextField();
		txtDateBook.setBounds(554, 73, 250, 42);
		txtDateBook.setBackground(Color.white);
		txtDateBook.setEditable(false);
		fp.getContentPane().add(txtDateBook);

		// Facility Type
		JLabel lblFacilityType = new JLabel("Facility Type: ");
		lblFacilityType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblFacilityType.setBounds(44, 123, 315, 42);
		fp.getContentPane().add(lblFacilityType);

		JTextField txtFacilityType = new JTextField();
		txtFacilityType.setBounds(164, 123, 250, 42);
		txtFacilityType.setBackground(Color.white);
		txtFacilityType.setEditable(false);
		fp.getContentPane().add(txtFacilityType);

		// Time
		JLabel lblTime = new JLabel("Time: ");
		lblTime.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblTime.setBounds(434, 123, 315, 42);
		fp.getContentPane().add(lblTime);

		JTextField txtTime = new JTextField();
		txtTime.setBounds(554, 123, 250, 42);
		txtTime.setBackground(Color.white);
		txtTime.setEditable(false);
		fp.getContentPane().add(txtTime);

		// Price
		JLabel lblPrice = new JLabel("Price: ");
		lblPrice.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPrice.setBounds(44, 173, 315, 42);
		fp.getContentPane().add(lblPrice);

		JTextField txtPrice = new JTextField();
		txtPrice.setBounds(164, 173, 250, 42);
		txtPrice.setBackground(Color.white);
		txtPrice.setEditable(false);
		fp.getContentPane().add(txtPrice);

		// Outstanding
		JLabel lblOut = new JLabel("Outstanding: ");
		lblOut.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblOut.setBounds(44, 273, 315, 42);
		fp.getContentPane().add(lblOut);

		JTextField txtOut = new JTextField();
		txtOut.setBounds(164, 273, 250, 42);
		txtOut.setBackground(Color.white);
		txtOut.setEditable(false);
		fp.getContentPane().add(txtOut);
		
		// Duration
		JLabel lblDuration = new JLabel("Duration: ");
		lblDuration.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDuration.setBounds(44, 223, 315, 42);
		fp.getContentPane().add(lblDuration);

		JTextField txtDuration = new JTextField();
		txtDuration.setBounds(164, 223, 250, 42);
		txtDuration.setBackground(Color.white);
		txtDuration.setEditable(false);
		fp.getContentPane().add(txtDuration);
		
		// Card Number
		JLabel lblCard = new JLabel("Card No: ");
		lblCard.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCard.setBounds(434, 173, 315, 42);
		fp.getContentPane().add(lblCard);

		JTextField txtCard = new JTextField();
		txtCard.setBounds(554, 173, 250, 42);
		fp.getContentPane().add(txtCard);
		
		// Expiration Date
		JLabel lblDate = new JLabel("Expiry Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(434, 223, 315, 42);
		fp.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(554, 223, 100, 42);
		fp.getContentPane().add(txtDate);
		
		// CCV
		JLabel lblCcv = new JLabel("CCV: ");
		lblCcv.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCcv.setBounds(654, 223, 315, 42);
		fp.getContentPane().add(lblCcv);

		JTextField txtCcv = new JTextField();
		txtCcv.setBounds(704, 223, 100, 42);
		fp.getContentPane().add(txtCcv);
		
		// Amount
		JLabel lblAmount = new JLabel("Amount:   RM ");
		lblAmount.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblAmount.setBounds(434, 273, 315, 42);
		fp.getContentPane().add(lblAmount);

		JTextField txtAmount = new JTextField();
		txtAmount.setBounds(554, 273, 250, 42);
		fp.getContentPane().add(txtAmount);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		fp.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("FacilityBooking.txt");
		String row[] = new String[9];
		String column[] = { "Facility Id", "Facility No", "Facility Type", "Name", "Facility Price", "Duration", "Total","Date", "Time" };

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
                        row[8] = tblData.get(i).get(8);
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
					txtFacilityType.setText((String) jTable.getValueAt(row[0], 2));
					txtPrice.setText((String) jTable.getValueAt(row[0], 4));
					txtDuration.setText((String) jTable.getValueAt(row[0], 5));
					txtOut.setText((String) jTable.getValueAt(row[0], 6));
					txtDateBook.setText((String) jTable.getValueAt(row[0], 7));
					txtTime.setText((String) jTable.getValueAt(row[0], 8));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 373, 770, 100);
		fp.getContentPane().add(scroll);
//		

		// Payment Display
		CRUD newCrud = new CRUD();
		tblDataHistory = newCrud.read("FacilityPaymentHistory.txt");
		String rowPayment[] = new String[6];
		String columnPayment[] = { "Payment Id", "Facility Type","Outstanding", "Total Paid", "Payment ID", "Date" };

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
			tableModelPayment.addRow(rowPayment);

		}
		jTablePayment.setModel(tableModelPayment);

//		ListSelectionModel selectPayment = jTablePayment.getSelectionModel();
//		selectPayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		selectPayment.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent e) {
//				int[] row = jTablePayment.getSelectedRows();
//				int columnNum = jTablePayment.getColumnCount();
//
//				if (row.length > 0) {
//					HashMap<Integer, String> debtDt = crud.read("Payment.txt",
//							(String) jTablePayment.getValueAt(row[0], 5), 5, "", 0);
//					txtUID.setText((String) jTablePayment.getValueAt(row[0], 0));
//					txtDate.setText((String) jTablePayment.getValueAt(row[0], 1));
//					txtPrice.setText((String) jTablePayment.getValueAt(row[0], 2));
//					txtTime.setText((String) jTablePayment.getValueAt(row[0], 3));
//					txtOut.setText((String) jTablePayment.getValueAt(row[0], 4));
//					txtFacilityType.setText(debtDt.get(3));
//				}
//
//			}
//		});
		JScrollPane scrollPayment = new JScrollPane(jTablePayment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPayment.setBounds(44, 503, 770, 100);
		fp.getContentPane().add(scrollPayment);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		fp.getContentPane().add(calErrorText);

		// Make Payment Btn
		JButton addUserBtn = new JButton("Make Payment");
		addUserBtn.setBounds(44, 323, 200, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CRUD crudCard = new CRUD();
				tblCard = crudCard.read("Card.txt");
				String rowCard[] = new String[3];
				for (int a = 0; a < tblCard.size(); a++) {
					rowCard[0] = tblCard.get(a).get(0);
					rowCard[1] = tblCard.get(a).get(1);
					rowCard[2] = tblCard.get(a).get(2);
				
				if(!txtCard.getText().equals(rowCard[0]) || !txtDate.getText().equals(rowCard[1]) || !txtCcv.getText().equals(rowCard[2])) {
					JOptionPane.showMessageDialog(contentPane, "Invalid Card Number Or Expiration Date!");
					return;
				}else {
					
				User user = new User();
				UUID uuid = UUID.randomUUID();

				String userID = txtUID.getText().trim();
				String dateBook = txtDateBook.getText().trim();
				String price = txtPrice.getText().trim();
				String out = txtOut.getText().trim();
				String facilityType = txtFacilityType.getText().trim();
				String duration = txtDuration.getText().trim();
				String time = txtTime.getText().trim();
				String amount = txtAmount.getText().trim();

				ArrayList<String> data = new ArrayList<>();
				ArrayList<String> dataReceipt = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String uid = uuid.toString();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now();
				data.add(uid);
				data.add(facilityType);
				data.add(out);
				data.add(amount);
				data.add(userID);
				data.add(dtf.format(now));
				
				dataReceipt.add(uid);
				dataReceipt.add(facilityType);
				dataReceipt.add(price);
				dataReceipt.add(duration);
				dataReceipt.add(amount);
				dataReceipt.add(dateBook);
				dataReceipt.add(time);
				dataReceipt.add(dtf.format(now));
				


				crud.create("FacilityPaymentHistory.txt", data);
				crud.create("FacilityReceipt.txt", dataReceipt);
				
				// Update the debt value
				int totalDebt = Integer.parseInt(out) - Integer.parseInt(amount);
				int total = Integer.parseInt(amount) - Integer.parseInt(out);
				crud.update("FacilityBooking.txt", userID, 0, "", 0, String.valueOf(totalDebt), 6, "", 0);
				//crud.update("VendorStatement.txt", userID, 0, "", 0, String.valueOf(totalDebt), 5, "", 0);
				//crud.update("VendorInvoice.txt", userID, 0, "", 0, String.valueOf(totalDebt), 5, "", 0);
				crud.update("FacilityPaymentHistory.txt", uid, 0,"", 0, String.valueOf(total), 2, "", 0);
				crud.update("FacilityPaymentHistory.txt", uid, 0,"", 0, String.valueOf(amount), 3, "", 0);
                                crud.update("ResidentInvoiceStatement.txt", userID, 0,"", 0, String.valueOf(total), 3, "", 0);

				// Clear text after update or add
				txtUID.setText("");
				txtDateBook.setText("");
				txtPrice.setText("");
				txtFacilityType.setText("");
				txtDuration.setText("");
				txtTime.setText("");
				txtOut.setText("");
				txtCard.setText("");
				txtDate.setText("");
				txtCcv.setText("");
				txtAmount.setText("");

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
                                        row[8] = tblData.get(i).get(8);
					tableModel.addRow(row);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jTable.updateUI();

				tblDataHistory = crud.read("FacilityPaymentHistory.txt");
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
				}
			}
		});
		fp.getContentPane().add(addUserBtn);
		
		// View Receipt Button
		JButton viewReceiptBtn = new JButton("View Receipt");
		viewReceiptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = jTablePayment.getSelectedRow();
				DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
				String uid = tableModelPayment.getValueAt(i, 0).toString();
				String roomType = tableModelPayment.getValueAt(i, 1).toString();
				String out = tableModelPayment.getValueAt(i, 2).toString();
				String amount = tableModelPayment.getValueAt(i, 3).toString();
				String userID = tableModelPayment.getValueAt(i, 4).toString();
				String dtf = tableModelPayment.getValueAt(i, 5).toString();
				
				int a = jTable.getSelectedRow();
				DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
				String uuid = tableModel.getValueAt(i, 0).toString();
				String roomNo1 = tableModel.getValueAt(i, 1).toString();
				String roomType1 = tableModel.getValueAt(i, 2).toString();
				String roomPrice = tableModel.getValueAt(i, 4).toString();
				String deposit = tableModel.getValueAt(i, 5).toString();
				String total = tableModel.getValueAt(i, 6).toString();
				String month1 = tableModel.getValueAt(i, 7).toString();
				String year1 = tableModel.getValueAt(i, 8).toString();
				
				// Receipt Display
				JTextArea textArea = new JTextArea();
				textArea.setLineWrap(true);
				textArea.setEditable(false);
				textArea.setBounds(844, 70, 420, 500);
				fp.getContentPane().add(textArea);
				
				String receipt = "\t\t<----- Receipt ----->\n";
				String lblpaymentId = "\tPayment ID:";
				String paymentId = uid + "\n\n\tDescription\t\t\tPrice\n\t---------------\t\t\t-------\n";
				String lblFacilityType = "\tFacility Type ("+ roomType + ")\n";
				String lblPrice = "\tFacility Price" + "\t\t\t" + roomPrice + "\n";
				String lblDuration = "\tDuration(hours)" + "\t\t" + deposit + "\n";
				String lblTotal = "\t---------------------------------------------------------------\n\tTotal Paid" + "\t\t\t" + amount + "\n";
				String lblDate = "\tDate Paid " + dtf + "\n\t---------------------------------------------------------------" + "\n";
				String lblThank = "\t                  Thank you for your payment\n";
				textArea.setText(receipt + lblpaymentId + paymentId + lblFacilityType + lblPrice + lblDuration + lblTotal + lblDate + lblThank);
				
			}
		});
		viewReceiptBtn.setBounds(264, 323, 200, 42);
		viewReceiptBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		fp.getContentPane().add(viewReceiptBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResPaymentMenu pm = new ResPaymentMenu();
				pm.pm.setVisible(true);
				fp.setVisible(false);

			}
		});
		fp.getContentPane().add(backBtn);

	}

}
