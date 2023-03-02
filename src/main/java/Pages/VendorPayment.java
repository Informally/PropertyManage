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

public class VendorPayment extends PageUtils{

	public JFrame vp;
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
					VendorPayment window = new VendorPayment(null);
					window.vp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendorPayment(String vendorName) {
		initialize(vendorName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String vendorName) {
		vp = new JFrame();
		vp.setTitle("Vendor Payment");
		vp.setBounds(100, 100, 900, 700);
		vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vp.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Vendor Payment");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		vp.getContentPane().add(lblNewLabel);

		// Payment ID
		JLabel lblUID = new JLabel("Payment ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		vp.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setBackground(Color.lightGray);
		txtUID.setEditable(false);
		vp.getContentPane().add(txtUID);

		// // Month
		// JLabel lblMonth = new JLabel("Month: ");
		// lblMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		// lblMonth.setBounds(434, 73, 315, 42);
		// vp.getContentPane().add(lblMonth);

		// JTextField txtMonth = new JTextField();
		// txtMonth.setBounds(554, 73, 250, 42);
		// txtMonth.setBackground(Color.white);
		// // txtMonth.setEditable(false);
		// vp.getContentPane().add(txtMonth);

		// Detail
		JLabel lblDetail = new JLabel("Detail: ");
		lblDetail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDetail.setBounds(44, 123, 315, 42);
		vp.getContentPane().add(lblDetail);

		JTextField txtDetail = new JTextField();
		txtDetail.setBounds(164, 123, 250, 42);
		txtDetail.setBackground(Color.white);
		txtDetail.setEditable(false);
		vp.getContentPane().add(txtDetail);

		// // Year
		// JLabel lblYear = new JLabel("Year: ");
		// lblYear.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		// lblYear.setBounds(434, 123, 315, 42);
		// vp.getContentPane().add(lblYear);

		// JTextField txtYear = new JTextField();
		// txtYear.setBounds(554, 123, 250, 42);
		// txtYear.setBackground(Color.white);
		// txtYear.setEditable(false);
		// vp.getContentPane().add(txtYear);


		// Amount to Pay
		JLabel lblPay = new JLabel("Amount: RM");
		lblPay.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblPay.setBounds(434, 273, 315, 42);
		vp.getContentPane().add(lblPay);

		JTextField txtPay = new JTextField();
		txtPay.setBounds(554, 273, 250, 42);
		txtPay.setBackground(Color.white);
		//set as non editable
		txtPay.setEditable(false);
		vp.getContentPane().add(txtPay);
		

				// Date
				JLabel lblDate = new JLabel("Date: ");
				lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
				lblDate.setBounds(44, 173, 315, 42);
				vp.getContentPane().add(lblDate);
		
				JTextField txtDate = new JTextField();
				txtDate.setBounds(164, 173, 250, 42);
				//set background as white
				txtDate.setBackground(Color.white);
				txtDate.setEditable(false);
				vp.getContentPane().add(txtDate);
		
		// Card Number
		JLabel lblCard = new JLabel("Card No: ");
		lblCard.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCard.setBounds(434, 173, 315, 42);
		vp.getContentPane().add(lblCard);

		JTextField txtCard = new JTextField();
		txtCard.setBounds(554, 173, 250, 42);
		vp.getContentPane().add(txtCard);
		
		// Expiration Date
		JLabel lblExDate = new JLabel("Expiry Date: ");
		lblExDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblExDate.setBounds(434, 223, 315, 42);
		vp.getContentPane().add(lblExDate);

		JTextField txtExDate = new JTextField();
		txtExDate.setBounds(554, 223, 100, 42);
		vp.getContentPane().add(txtExDate);
		
		// CCV
		JLabel lblCcv = new JLabel("CCV: ");
		lblCcv.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCcv.setBounds(654, 223, 315, 42);
		vp.getContentPane().add(lblCcv);

		JTextField txtCcv = new JTextField();
		txtCcv.setBounds(704, 223, 100, 42);
		vp.getContentPane().add(txtCcv);
		
        // Name
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		vp.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
        txtName.setBackground(Color.white);
		txtName.setEditable(false);
		vp.getContentPane().add(txtName);
                
		// Pending Amount
		JLabel lblPending = new JLabel("Pending:   RM ");
		lblPending.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPending.setBounds(434, 123, 315, 42);
		vp.getContentPane().add(lblPending);

		JTextField txtPending = new JTextField();
		txtPending.setBounds(554, 123, 250, 42);
		//set background as white
		txtPending.setBackground(Color.white);
		//set as non-editable
		txtPending.setEditable(false);
		vp.getContentPane().add(txtPending);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		vp.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("PendingFee.txt");
		String row[] = new String[5];
		String column[] = { "Charge ID", "Name", "Detail", "Amount", "Date"};
		JTable jTable = new JTable();
		jTable.setBounds(44, 323, 770, 100);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		jTable.setDefaultEditor(Object.class, null);
		tableModel.setColumnIdentifiers(column);
		//set table as non-editable

		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData.size(); i++) {
			row[0] = tblData.get(i).get(0);
			row[1] = tblData.get(i).get(1);
			row[2] = tblData.get(i).get(2);
			row[3] = tblData.get(i).get(3);
			row[4] = tblData.get(i).get(4);
			// tableModel.addRow(row);

			// Check if the row contains the search string
			boolean match = false;
			for (int j = 0; j < row.length; j++) {
				if (row[j].toLowerCase().contains(vendorName.toLowerCase())) {
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
                    txtName.setText((String) jTable.getValueAt(row[0], 1));
					txtDetail.setText((String) jTable.getValueAt(row[0], 2));
					txtPending.setText((String) jTable.getValueAt(row[0], 3));
					txtDate.setText((String) jTable.getValueAt(row[0], 4));
					//set txtPay as the same value as txtPending
					txtPay.setText((String) jTable.getValueAt(row[0], 3));

					// txtServices.setText((String) jTable.getValueAt(row[0], 4));
					// txtOut.setText((String) jTable.getValueAt(row[0], 5));
					// txtMonth.setText((String) jTable.getValueAt(row[0], 6));
					// txtYear.setText((String) jTable.getValueAt(row[0], 7));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 373, 770, 100);
		vp.getContentPane().add(scroll);
//		

		// Payment Display
		CRUD newCrud = new CRUD();
		tblDataHistory = newCrud.read("PaymentHistory.txt");
		String rowPayment[] = new String[8];
		String columnPayment[] = { "Payment ID", "Name", "Detail", "Pending", "Amount Paid", "Outstanding" ,"Charge ID", "Date" };

		JTable jTablePayment = new JTable();
		jTablePayment.setBounds(44, 423, 770, 100);
		DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
		tableModelPayment.setColumnIdentifiers(columnPayment);
		//set table as non-editable
		jTablePayment.setDefaultEditor(Object.class, null);
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
			// tableModelPayment.addRow(rowPayment);
			// Check if the row contains the search string
			boolean match1 = false;
			for (int b = 0; b < rowPayment.length; b++) {
				if (rowPayment[b].toLowerCase().contains(vendorName.toLowerCase())) {
				match1 = true;
				break;
				}
			}

			// Add the row if it matches the search string
			if (match1) {
				tableModelPayment.addRow(rowPayment);
			}

		}
		jTablePayment.setModel(tableModelPayment);


		JScrollPane scrollPayment = new JScrollPane(jTablePayment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPayment.setBounds(44, 503, 770, 100);
		vp.getContentPane().add(scrollPayment);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		vp.getContentPane().add(calErrorText);

		// Make Payment Btn
		JButton addUserBtn = new JButton("Make Payment");
		addUserBtn.setBounds(44, 323, 170, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 CRUD crudCard = new CRUD();

                                tblCard = crudCard.readBulk("Card.txt", txtCard.getText().trim(), 0, "",0);

                                if(tblCard.size() == 0){
                                    ArrayList<String> cardDetails = new ArrayList<>();
                                    cardDetails.add(txtCard.getText().trim());
                                    cardDetails.add(txtExDate.getText().trim());
                                    cardDetails.add(txtCcv.getText().trim());

                                    crud.create("Card.txt", cardDetails);
                                }
				
				
				User user = new User();
				UUID uuid = UUID.randomUUID();
				//Strings from PendingFee txt
				String userID = txtUID.getText().trim();
                String name = txtName.getText().trim();
				String details = txtDetail.getText().trim();
				String pending = txtPending.getText().trim();
				String date = txtDate.getText().trim();
				//new strings
				String amttopay = txtPay.getText().trim();

				ArrayList<String> data = new ArrayList<>();
				ArrayList<String> dataReceipt = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//if pending is 0, then do not allow payment
				if(pending.equals("0")){
					JOptionPane.showMessageDialog(null, "No outstanding payment");
					calErrorText.setText("No outstanding payment");
					calErrorText.setVisible(true);

					//do not write to file
					return;
				}

				String uid = uuid.toString();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDateTime now = LocalDateTime.now();
				data.add(uid);
                data.add(name);
				data.add(details);
				data.add(pending);
				data.add(amttopay);
				data.add("");
				data.add(userID);
				data.add(date);


				dataReceipt.add(uid);
                dataReceipt.add(name);
				dataReceipt.add(details);
				dataReceipt.add(pending);
				dataReceipt.add(amttopay);
				dataReceipt.add("");
				dataReceipt.add(userID);
				dataReceipt.add(date);

				crud.create("PaymentHistory.txt", data);
				crud.create("VendorReceipt.txt", dataReceipt);
				// Update the debt value
				int totalDebt = Integer.parseInt(amttopay) - Integer.parseInt(pending);
				crud.update("PendingFee.txt", userID, 0, "", 0, String.valueOf(totalDebt), 3, "", 0);
				crud.update("VendorStatement.txt", userID, 0, "", 0, String.valueOf(totalDebt), 6, "", 0);
				crud.update("VendorInvoice.txt", userID, 0, "", 0, String.valueOf(totalDebt), 6, "", 0);
				crud.update("PaymentHistory.txt", uid, 0,"", 0, String.valueOf(totalDebt), 5, "", 0);
				crud.update("PaymentHistory.txt", uid, 0,"", 0, String.valueOf(totalDebt), 3, "", 0);

				// Clear text after update or add
				txtUID.setText("");
                txtName.setText("");
				txtDetail.setText("");
				txtPending.setText("");
				txtPay.setText("");
				txtExDate.setText("");
				txtCard.setText("");
				txtDate.setText("");
				txtCcv.setText("");

				// Refresh the data in table
				tblData = crud.read("PendingFee.txt");
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
					// tableModel.addRow(row);
					// Check if the row contains the search string
			boolean match2 = false;
			for (int w = 0; w < row.length; w++) {
				if (row[w].toLowerCase().contains(vendorName.toLowerCase())) {
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

				tblDataHistory = crud.read("PaymentHistory.txt");
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
					// tableModelPayment.addRow(rowPayment);
					// Check if the row contains the search string
			boolean match3 = false;
			for (int q = 0; q < rowPayment.length; q++) {
				if (rowPayment[q].toLowerCase().contains(vendorName.toLowerCase())) {
				match3 = true;
				break;
				}
			}

			// Add the row if it matches the search string
			if (match3) {
				tableModelPayment.addRow(rowPayment);
				}

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
		vp.getContentPane().add(addUserBtn);
		
		// View Receipt Button
		JButton viewReceiptBtn = new JButton("View Receipt");
		viewReceiptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = jTablePayment.getSelectedRow();
				DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
				String uid = tableModelPayment.getValueAt(i, 0).toString();
                String name = tableModelPayment.getValueAt(i, 1).toString();
				String details = tableModelPayment.getValueAt(i, 2).toString();
				String pending = tableModelPayment.getValueAt(i, 3).toString();
				String amttopay = tableModelPayment.getValueAt(i, 4).toString();
				String outstanding = tableModelPayment.getValueAt(i, 5).toString();
				String chargeID = tableModelPayment.getValueAt(i, 6).toString();
				String date = tableModelPayment.getValueAt(i, 7).toString();
				
				int a = jTable.getSelectedRow();
				DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
				String rental = tableModel.getValueAt(0, 2).toString();
				String utilities = tableModel.getValueAt(0, 3).toString();
				String services = tableModel.getValueAt(0, 4).toString();
				

				String receipt = "\t\t<------------- Receipt ------------->\n";
				String lblpaymentId = "\tPayment ID: ";
				String paymentId = uid + "\n\n\tDescription                Price\n\t---------------\t\t\t                 ---------------------\n";
				String lblName = "\tName                    " + "\t\t\t       " + name + "\n";
                String lblDetailString = "\tDetails                  " + "\t\t\t      " + details + "\n";
				String lblPending = "\tPending                    " + "\t\t\t    " + pending + "\n";
				// String lblAmt = "\tAmount Paid                   " + "\t\t\t  " + amttopay + "\n";
				String lblTotal = "\t---------------------------------------------------------------\n\tTotal Paid:                    " + "\t\t\t" + amttopay + "\n";
                String lblOut = "\tOutstanding                 " + "\t\t\t  " + outstanding + "\n";
				// String lblPaymentDate = "\tPayment for: " + month + " " + year + "\n";
				String lblDate = "\tDate Paid: " + date + "\n\t---------------------------------------------------------------" + "\n";
				String lblThank = "\t                  Thank you for your payment\n";
				//textArea.setText(receipt + lblpaymentId + paymentId + lblRental + lblUtilities + lblServices + lblTotal + lblPaymentDate + lblDate + lblThank);
				JOptionPane.showMessageDialog(null, receipt + lblpaymentId + paymentId + lblName + lblDetailString + lblPending + lblTotal + lblOut + lblDate + lblThank, "Receipt", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		viewReceiptBtn.setBounds(234, 323, 170, 42);
		viewReceiptBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		vp.getContentPane().add(viewReceiptBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(650, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorMenu vm = new VendorMenu(vendorName);
                                setOriginalFrame(vp);
				setTargetedFrame(vm.vm);
				navigatePage();

			}
		});
		vp.getContentPane().add(backBtn);

	}

}
