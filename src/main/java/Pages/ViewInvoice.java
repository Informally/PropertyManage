package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ViewInvoice extends PageUtils {

	public JFrame viewInvoice;
	public CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInvoice window = new ViewInvoice();
					window.viewInvoice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewInvoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		viewInvoice = new JFrame();
		viewInvoice.setTitle("Issue Invoice");
		viewInvoice.setBounds(100, 100, 871, 622);
		viewInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewInvoice.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Issue Invoice");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 5, 665, 40);
		viewInvoice.getContentPane().add(lblNewLabel);
                
        // Month
		JLabel lblMonth = new JLabel("Vendor Invoice: ");
		lblMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblMonth.setBounds(44, 180, 315, 42);
		viewInvoice.getContentPane().add(lblMonth);
                
		JComboBox<String> reportTypeOptions = new JComboBox<>();
		reportTypeOptions.setBounds(190, 180, 250, 42);
		//get all the records from PaymentHistory.txt
		ArrayList<ArrayList<String>> paymentHistory = crud.read("PaymentHistory.txt");
		//add all the records in paymentHistory to the combobox
		for (int i = 0; i < paymentHistory.size(); i++) {
			reportTypeOptions.addItem(paymentHistory.get(i).get(0));
		}


    	// reportTypeOptions.addItem("January");
		// reportTypeOptions.addItem("February");
		// reportTypeOptions.addItem("March");
		// reportTypeOptions.addItem("April");
		// reportTypeOptions.addItem("May");
		// reportTypeOptions.addItem("June");
		// reportTypeOptions.addItem("July");
		// reportTypeOptions.addItem("August");
		// reportTypeOptions.addItem("September");
		// reportTypeOptions.addItem("October");
		// reportTypeOptions.addItem("November");
		// reportTypeOptions.addItem("December");
		viewInvoice.getContentPane().add(reportTypeOptions);
                
                // Invoice
		JLabel lblStatement = new JLabel("------------INVOICE / STATEMENT------------");
		lblStatement.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		lblStatement.setBounds(0, 3, 500, 42);
                
                // Date Issued
		JLabel lblSDate = new JLabel("Date Issued:");
		lblSDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSDate.setBounds(564, 33, 315, 42);
                
                // Company
		JLabel lblCompany = new JLabel("Parkhill Resident");
		lblCompany.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		lblCompany.setBounds(0, 33, 315, 42);
		
		//Company Address
		JLabel lblComAdd = new JLabel("2, 217, Technology Park Malaysia,");
		lblComAdd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd.setBounds(0, 63, 315, 42);
		
		//Company Address
		JLabel lblComAdd2 = new JLabel("57000 Kuala Lumpur,Wilayah Kuala Lumpur");
		lblComAdd2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd2.setBounds(0, 83, 315, 42);
		
		//Company Phone
		JLabel lblComAdd3 = new JLabel("03-8656 9488");
		lblComAdd3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd3.setBounds(0, 103, 315, 42);
		
		//Bill To
		JLabel lblBill = new JLabel("Bill To:");
		lblBill.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBill.setBounds(34, 123, 315, 42);
		
		//Contract
		JLabel lblContract = new JLabel("Due Date:");
		lblContract.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblContract.setBounds(591, 53, 315, 42);

		
		//To Date
		JLabel lblToDate = new JLabel("Lease Expiration Date:     2023-12-31");
		lblToDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblToDate.setBounds(504, 73, 315, 42);
		
		//To Date
		JLabel lblInvNo = new JLabel("Invoice No:");
		lblInvNo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblInvNo.setBounds(570, 93, 315, 42);
		
		//Label Column
		JLabel lblColumn = new JLabel("Date                                Description                         Month");
		lblColumn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColumn.setBounds(50, 193, 315, 42);
		
		//Label Column2
		JLabel lblColumn2 = new JLabel("Year                        Amount(RM)");
		lblColumn2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColumn2.setBounds(420, 193, 315, 42);
		
		//Label Balance
		JLabel lblBalance = new JLabel("Balance Due");
		lblBalance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBalance.setBounds(375, 273, 315, 42);
		
		//Label Remittance
		JLabel lblRemittance = new JLabel("Thank You For Your Business!");
		lblRemittance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblRemittance.setBounds(225, 303, 315, 42);
                
                //Report Type
		JLabel lblReportType = new JLabel("Resident/Tenant Invoice: ");
		lblReportType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblReportType.setBounds(44, 40, 315, 42);
		viewInvoice.getContentPane().add(lblReportType);
                
                // Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 215, 780, 300);
                
                CRUD newCrud = new CRUD();
		tblData.clear();
		tblData = newCrud.read("ResidentInvoiceStatement.txt");
		String rowPayment[] = new String[6];
		String columnPayment[] = { "Id","Name", "Payment Type", "Detail", "Outstanding", "Date" };



		JTable jTablePayment = new JTable();
		jTablePayment.setBounds(44, 73, 770, 100);
		DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
		tableModelPayment.setColumnIdentifiers(columnPayment);
		jTablePayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		System.out.print(tblData);

		for (int i = 0; i < tblData.size(); i++) {
			rowPayment[0] = tblData.get(i).get(0);
			rowPayment[1] = tblData.get(i).get(1);
			rowPayment[2] = tblData.get(i).get(2);
			rowPayment[3] = tblData.get(i).get(3);
			rowPayment[4] = tblData.get(i).get(4);
            rowPayment[5] = tblData.get(i).get(5);
			tableModelPayment.addRow(rowPayment);

		}
		jTablePayment.setModel(tableModelPayment);

		
		JScrollPane scrollPayment = new JScrollPane(jTablePayment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPayment.setBounds(60, 73, 770, 100);
		viewInvoice.getContentPane().add(scrollPayment);
		
		// Scroll
		JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 250, 770, 300);
		viewInvoice.getContentPane().add(scroll);

		ListSelectionModel selectPayment = jTablePayment.getSelectionModel();
		selectPayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectPayment.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row = jTablePayment.getSelectedRows();
				int columnNum = jTablePayment.getColumnCount();

				if (row.length > 0) {

				String paymentID = (String) jTablePayment.getValueAt(row[0], 0);
                String name = (String) jTablePayment.getValueAt(row[0], 1);
				String type = (String) jTablePayment.getValueAt(row[0], 2);
				String type1 = (String) jTablePayment.getValueAt(row[0], 3);
				String outstanding = (String) jTablePayment.getValueAt(row[0], 4);
				String date = (String) jTablePayment.getValueAt(row[0], 5);

				String report = "<-------- Invoice/Statement -------->\n\n";
					
				report += "\nPayment Id: " + paymentID + "\n" + "Name: " + name + "\n" + "Payment Type: " + type + "\n" + "Detail: " + type1 + "\n" + "Outstanding: RM" + outstanding + "\n" + "Date: " + date + "\n----------------------\n";
				//textArea.setText(report);
				
				//JOPtionPane showing report with the title "Invoice/Statement"
				JOptionPane.showMessageDialog(null, report, "Invoice/Statement", JOptionPane.INFORMATION_MESSAGE);

				}
				

			}
		});
   
		viewInvoice.getContentPane().add(scroll);
		reportTypeOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//read all the records from PaymentHistory.txt and declare as an arraylist
				ArrayList<ArrayList<String>> statementData = newCrud.read("PaymentHistory.txt");
				//print the arraylist if the selection in reportTypeOptions is equal to the first item in the arraylist
				//assuming reportTypeOptions contains the selected report type
				String selectedReportType = reportTypeOptions.getSelectedItem().toString();
				String receiptReport = "";
				//iterate through each record in statementData
				for (ArrayList<String> record : statementData) {
  				//check if the selected report type matches the first item of this record
  					if (record.get(0).equals(selectedReportType)) {
    				//print the entire record
    					System.out.println(record);
						receiptReport +="\n\n\n\n\n\n\n\n\n\n"+"Payment ID: " + record.get(0) + "\n" + "Name: "+record.get(1) + "\n" + "Details: "+record.get(2) + "\n" + "Pending: RM"+record.get(3) + "\n" + "Amount Paid: RM"+record.get(4)+ "\n" + "Outstanding: RM"+record.get(5)+ "\n" + "Charge ID: "+record.get(6)+ "\n" + "Date: "+record.get(7);
						textArea.setText(receiptReport);
						textArea.add(lblStatement);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
  					}
				}



                            
				// switch ((String) reportTypeOptions.getSelectedItem()) {
                //                  case "January":
					
				// 	ArrayList<ArrayList<String>> statementData = crud.read("VendorInvoice.txt");

				// 	String receiptReport = "";
					
				// 	for (ArrayList<String> row : statementData) {
				// 		if(row.get(4).equals("January")) {
				// 		receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
				// 		lblSDate.setText("Date Issued:     2023-01-01");
				// 		lblContract.setText("Due To:     2023-01-31");
				// 		lblBalance.setText("Balance Due      " + row.get(6));
				// 		lblInvNo.setText("Invoice No:     " + row.get(0));
                //                                 lblBill.setText("Bill To:    " + row.get(1));
				// 		}
				// 	}

				// 	textArea.setText(receiptReport);
				// 	textArea.add(lblStatement);
				// 	textArea.add(lblSDate);
				// 	textArea.add(lblInvNo);
				// 	textArea.add(lblCompany);
				// 	textArea.add(lblComAdd);
				// 	textArea.add(lblComAdd2);
				// 	textArea.add(lblComAdd3);
				// 	textArea.add(lblBill);
				// 	textArea.add(lblContract);
				// 	textArea.add(lblColumn);
				// 	textArea.add(lblColumn2);
				// 	textArea.add(lblBalance);
				// 	textArea.add(lblRemittance);
				// 	textArea.add(lblToDate);
				// 	break;

			}
		});


		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AccountExecMenu acctmenu = new AccountExecMenu();
				setOriginalFrame(viewInvoice);
				setTargetedFrame(acctmenu.aem);
				navigatePage();

			}
		});
		viewInvoice.getContentPane().add(backBtn);
		

	}
}
