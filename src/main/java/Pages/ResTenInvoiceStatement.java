package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ResTenInvoiceStatement extends PageUtils{

	public JFrame rtis;
	public CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResTenInvoiceStatement window = new ResTenInvoiceStatement(null);
					window.rtis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResTenInvoiceStatement(String restenname) {
		initialize(restenname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String restenname) {
		rtis = new JFrame();
		rtis.setTitle("Resident/Tenant Invoice/Statement");
		rtis.setBounds(100, 100, 600, 600);
		rtis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rtis.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Resident/Tenant Invoice/Statement");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 27));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rtis.getContentPane().add(lblNewLabel);

		// Month
		JLabel lblMonth = new JLabel("Select ID: ");
		lblMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblMonth.setBounds(44, 73, 315, 42);
		rtis.getContentPane().add(lblMonth);

		JComboBox<String> reportOptions = new JComboBox<>();
		reportOptions.setBounds(120, 73, 250, 42);
		ArrayList<ArrayList<String>> paymentHistory = crud.read("ResTenPaymentHistory.txt");
		//add the records with the vendorName to the combobox
		for (int i = 0; i < paymentHistory.size(); i++) {
			//if (paymentHistory.get(i).get(1).equals()) {
				reportOptions.addItem(paymentHistory.get(i).get(0));
				reportOptions.setSelectedIndex(-1);
			}
		//}

		rtis.getContentPane().add(reportOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 550, 350);
		
		// Invoice
		JLabel lblStatement = new JLabel("------------INVOICE------------");
		lblStatement.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		lblStatement.setBounds(0, 3, 315, 42);
		
		// Date Issued
		JLabel lblSDate = new JLabel("Date Issued:");
		lblSDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSDate.setBounds(564, 33, 315, 42);
		

		// Company
		JLabel lblCompany = new JLabel("Parkhill Resident");
		lblCompany.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		lblCompany.setBounds(0, 53, 315, 42);
		
		//Company Address
		JLabel lblComAdd = new JLabel("2, 217, Technology Park Malaysia,");
		lblComAdd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd.setBounds(0, 83, 315, 42);
		
		//Company Address
		JLabel lblComAdd2 = new JLabel("57000 Kuala Lumpur,Wilayah Kuala Lumpur");
		lblComAdd2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd2.setBounds(0, 103, 315, 42);
		
		//Company Phone
		JLabel lblComAdd3 = new JLabel("03-8656 9488");
		lblComAdd3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd3.setBounds(0, 123, 315, 42);
		
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
		JLabel lblColumn = new JLabel("Date                          Description                         Month");
		lblColumn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColumn.setBounds(34, 193, 315, 42);
		
		//Label Column2
		JLabel lblColumn2 = new JLabel("Year                        Amount(RM)");
		lblColumn2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColumn2.setBounds(375, 193, 315, 42);
		
		//Label Balance
		JLabel lblBalance = new JLabel("Balance Due");
		lblBalance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBalance.setBounds(375, 273, 315, 42);
		
		//Label Remittance
		JLabel lblRemittance = new JLabel("Thank You For Your Business!");
		lblRemittance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblRemittance.setBounds(225, 303, 315, 42);
		
				
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 450, 350);
		rtis.getContentPane().add(scroll);

		reportOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
			//read all the records from PaymentHistory.txt and declare as an arraylist
			ArrayList<ArrayList<String>> statementData = crud.read("ResTenPaymentHistory.txt");
			//print the arraylist if the selection in reportTypeOptions is equal to the first item in the arraylist
			//assuming reportTypeOptions contains the selected report type
			String selectedReportType = reportOptions.getSelectedItem().toString();
			String receiptReport = "";


			// set the text
			String text = "Invoice/Statement";
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
				
				// case "February":
					
				// 	statementData = crud.read("VendorInvoice.txt");

				// 	receiptReport = "";
					
				// 	for (ArrayList<String> row : statementData) {
				// 		if(row.get(4).equals("February")) {
				// 		receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
				// 		lblSDate.setText("Date Issued:     2023-02-01");
				// 		lblContract.setText("Due To:     2023-02-28");
				// 		lblBalance.setText("Balance Due      " + row.get(6));
				// 		lblInvNo.setText("Invoice No:     " + row.get(0));
                //                                 lblBill.setText("Bill To:    " + row.get(1));
				// 		}
				// 	}

				// 	textArea.setText(receiptReport);
				// 	textArea.add(lblStatement);
				// 	textArea.add(lblSDate);
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
				// 	textArea.add(lblInvNo);
				// 	break;

				}

		});

		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(44, 500, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResidentMenu payHis = new ResidentMenu(restenname);
                setOriginalFrame(rtis);
				setTargetedFrame(payHis.rm);
				navigatePage();

			}
		});
		rtis.getContentPane().add(backBtn);

	}
	}
