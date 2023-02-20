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
					VendorPayment window = new VendorPayment();
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
	public VendorPayment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		vp = new JFrame();
		vp.setTitle("Vendor Payment");
		vp.setBounds(100, 100, 1471, 822);
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
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		vp.getContentPane().add(txtUID);

		// Month
		JLabel lblMonth = new JLabel("Month: ");
		lblMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblMonth.setBounds(434, 73, 315, 42);
		vp.getContentPane().add(lblMonth);

		JTextField txtMonth = new JTextField();
		txtMonth.setBounds(554, 73, 250, 42);
		txtMonth.setBackground(Color.white);
		txtMonth.setEditable(false);
		vp.getContentPane().add(txtMonth);

		// Rental
		JLabel lblRental = new JLabel("Rental: ");
		lblRental.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRental.setBounds(44, 123, 315, 42);
		vp.getContentPane().add(lblRental);

		JTextField txtRental = new JTextField();
		txtRental.setBounds(164, 123, 250, 42);
		txtRental.setBackground(Color.white);
		txtRental.setEditable(false);
		vp.getContentPane().add(txtRental);

		// Year
		JLabel lblYear = new JLabel("Year: ");
		lblYear.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblYear.setBounds(434, 123, 315, 42);
		vp.getContentPane().add(lblYear);

		JTextField txtYear = new JTextField();
		txtYear.setBounds(554, 123, 250, 42);
		txtYear.setBackground(Color.white);
		txtYear.setEditable(false);
		vp.getContentPane().add(txtYear);

		// Utilities
		JLabel lblUtilities = new JLabel("Utilities: ");
		lblUtilities.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUtilities.setBounds(44, 173, 315, 42);
		vp.getContentPane().add(lblUtilities);

		JTextField txtUtilities = new JTextField();
		txtUtilities.setBounds(164, 173, 250, 42);
		txtUtilities.setBackground(Color.white);
		txtUtilities.setEditable(false);
		vp.getContentPane().add(txtUtilities);

		// Outstanding
		JLabel lblOut = new JLabel("Outstanding: ");
		lblOut.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblOut.setBounds(44, 273, 315, 42);
		vp.getContentPane().add(lblOut);

		JTextField txtOut = new JTextField();
		txtOut.setBounds(164, 273, 250, 42);
		txtOut.setBackground(Color.white);
		txtOut.setEditable(false);
		vp.getContentPane().add(txtOut);
		
		// Services
		JLabel lblServices = new JLabel("Services: ");
		lblServices.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblServices.setBounds(44, 223, 315, 42);
		vp.getContentPane().add(lblServices);

		JTextField txtServices = new JTextField();
		txtServices.setBounds(164, 223, 250, 42);
		txtServices.setBackground(Color.white);
		txtServices.setEditable(false);
		vp.getContentPane().add(txtServices);
		
		// Card Number
		JLabel lblCard = new JLabel("Card No: ");
		lblCard.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCard.setBounds(434, 173, 315, 42);
		vp.getContentPane().add(lblCard);

		JTextField txtCard = new JTextField();
		txtCard.setBounds(554, 173, 250, 42);
		vp.getContentPane().add(txtCard);
		
		// Expiration Date
		JLabel lblDate = new JLabel("Expiry Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(434, 223, 315, 42);
		vp.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(554, 223, 100, 42);
		vp.getContentPane().add(txtDate);
		
		// CCV
		JLabel lblCcv = new JLabel("CCV: ");
		lblCcv.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCcv.setBounds(654, 223, 315, 42);
		vp.getContentPane().add(lblCcv);

		JTextField txtCcv = new JTextField();
		txtCcv.setBounds(704, 223, 100, 42);
		vp.getContentPane().add(txtCcv);
		
		// Amount
		JLabel lblAmount = new JLabel("Amount:   RM ");
		lblAmount.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblAmount.setBounds(434, 273, 315, 42);
		vp.getContentPane().add(lblAmount);

		JTextField txtAmount = new JTextField();
		txtAmount.setBounds(554, 273, 250, 42);
		vp.getContentPane().add(txtAmount);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		vp.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("PendingFee.txt");
		String row[] = new String[7];
		String column[] = { "Id", "Rental", "Utilities", "Services", "Outstanding", "Month", "Year" };

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
					txtRental.setText((String) jTable.getValueAt(row[0], 1));
					txtUtilities.setText((String) jTable.getValueAt(row[0], 2));
					txtServices.setText((String) jTable.getValueAt(row[0], 3));
					txtOut.setText((String) jTable.getValueAt(row[0], 4));
					txtMonth.setText((String) jTable.getValueAt(row[0], 5));
					txtYear.setText((String) jTable.getValueAt(row[0], 6));
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
		String rowPayment[] = new String[7];
		String columnPayment[] = { "Id", "Outstanding", "Total Paid", "Month", "Year", "Payment ID", "Date" };

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
			tableModelPayment.addRow(rowPayment);

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
				String month = txtMonth.getText().trim();
				String utilities = txtUtilities.getText().trim();
				String out = txtOut.getText().trim();
				String rental = txtRental.getText().trim();
				String services = txtServices.getText().trim();
				String year = txtYear.getText().trim();
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
				data.add(out);
				data.add(amount);
				data.add(month);
				data.add(year);
				data.add(userID);
				data.add(dtf.format(now));
				
				dataReceipt.add(uid);
				dataReceipt.add(rental);
				dataReceipt.add(utilities);
				dataReceipt.add(services);
				dataReceipt.add(amount);
				dataReceipt.add(month);
				dataReceipt.add(year);
				dataReceipt.add(dtf.format(now));

				crud.create("PaymentHistory.txt", data);
				crud.create("VendorReceipt.txt", dataReceipt);
				// Update the debt value
				int totalDebt = Integer.parseInt(out) - Integer.parseInt(amount);
				int total = Integer.parseInt(amount) - Integer.parseInt(out);
				crud.update("PendingFee.txt", userID, 0, "", 0, String.valueOf(totalDebt), 4, "", 0);
				crud.update("VendorStatement.txt", userID, 0, "", 0, String.valueOf(totalDebt), 5, "", 0);
				crud.update("VendorInvoice.txt", userID, 0, "", 0, String.valueOf(totalDebt), 5, "", 0);
				crud.update("PaymentHistory.txt", uid, 0,"", 0, String.valueOf(total), 1, "", 0);
				crud.update("PaymentHistory.txt", uid, 0,"", 0, String.valueOf(amount), 2, "", 0);

				// Clear text after update or add
				txtUID.setText("");
				txtMonth.setText("");
				txtUtilities.setText("");
				txtRental.setText("");
				txtServices.setText("");
				txtYear.setText("");
				txtOut.setText("");
				txtCard.setText("");
				txtDate.setText("");
				txtCcv.setText("");
				txtAmount.setText("");

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
		vp.getContentPane().add(addUserBtn);
		
		// View Receipt Button
		JButton viewReceiptBtn = new JButton("View Receipt");
		viewReceiptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = jTablePayment.getSelectedRow();
				DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
				String uid = tableModelPayment.getValueAt(i, 0).toString();
				String total = tableModelPayment.getValueAt(i, 1).toString();
				String amount = tableModelPayment.getValueAt(i, 2).toString();
				String month = tableModelPayment.getValueAt(i, 3).toString();
				String year = tableModelPayment.getValueAt(i, 4).toString();
				String userID = tableModelPayment.getValueAt(i, 5).toString();
				String dtf = tableModelPayment.getValueAt(i, 6).toString();
				
				int a = jTable.getSelectedRow();
				DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
				String uuid = tableModel.getValueAt(i, 0).toString();
				String rental = tableModel.getValueAt(i, 1).toString();
				String utilities = tableModel.getValueAt(i, 2).toString();
				String services = tableModel.getValueAt(i, 3).toString();
				String out = tableModel.getValueAt(i, 4).toString();
				String month1 = tableModel.getValueAt(i, 5).toString();
				String year1 = tableModel.getValueAt(i, 6).toString();
				
				// Receipt Display
				JTextArea textArea = new JTextArea();
				textArea.setLineWrap(true);
				textArea.setEditable(false);
				textArea.setBounds(844, 70, 420, 500);
				vp.getContentPane().add(textArea);
				
				String receipt = "\t\t<----- Receipt ----->\n";
				String lblpaymentId = "\tPayment ID:";
				String paymentId = uid + "\n\n\tDescription\t\t\tPrice\n\t---------------\t\t\t-------\n";
				String lblRental = "\tRental" + "\t\t\t" + rental + "\n";
				String lblUtilities = "\tUtilities" + "\t\t\t" + utilities + "\n";
				String lblServices = "\tServices" + "\t\t\t" + services + "\n";
				String lblTotal = "\t---------------------------------------------------------------\n\tTotal Paid" + "\t\t\t" + amount + "\n";
				String lblPaymentDate = "\tPayment for " + month + " " + year + "\n";
				String lblDate = "\tDate Paid " + dtf + "\n\t---------------------------------------------------------------" + "\n";
				String lblThank = "\t                  Thank you for your payment\n";
				textArea.setText(receipt + lblpaymentId + paymentId + lblRental + lblUtilities + lblServices + lblTotal + lblPaymentDate + lblDate + lblThank);
				
			}
		});
		viewReceiptBtn.setBounds(264, 323, 200, 42);
		viewReceiptBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		vp.getContentPane().add(viewReceiptBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorMenu vm = new VendorMenu();
                                setOriginalFrame(vp);
				setTargetedFrame(vm.vm);
				navigatePage();

			}
		});
		vp.getContentPane().add(backBtn);

	}

}
