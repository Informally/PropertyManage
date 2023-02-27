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
		viewInvoice.setTitle("View Invoice");
		viewInvoice.setBounds(100, 100, 871, 622);
		viewInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewInvoice.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("View Invoice");
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

                reportTypeOptions.addItem("January");
		reportTypeOptions.addItem("February");
		reportTypeOptions.addItem("March");
		reportTypeOptions.addItem("April");
		reportTypeOptions.addItem("May");
		reportTypeOptions.addItem("June");
		reportTypeOptions.addItem("July");
		reportTypeOptions.addItem("August");
		reportTypeOptions.addItem("September");
		reportTypeOptions.addItem("October");
		reportTypeOptions.addItem("November");
		reportTypeOptions.addItem("December");
		viewInvoice.getContentPane().add(reportTypeOptions);
                
                // Invoice
		JLabel lblStatement = new JLabel("INVOICE ");
		lblStatement.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		lblStatement.setBounds(564, 3, 315, 42);
                
                // Date Issued
		JLabel lblSDate = new JLabel("Date Issued:");
		lblSDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSDate.setBounds(564, 33, 315, 42);
                
                // Company
		JLabel lblCompany = new JLabel("Parkhill Resident");
		lblCompany.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		lblCompany.setBounds(34, 3, 315, 42);
		
		//Company Address
		JLabel lblComAdd = new JLabel("2, 217, Technology Park Malaysia,");
		lblComAdd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd.setBounds(34, 43, 315, 42);
		
		//Company Address
		JLabel lblComAdd2 = new JLabel("57000 Kuala Lumpur,Wilayah Kuala Lumpur");
		lblComAdd2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd2.setBounds(34, 63, 315, 42);
		
		//Company Phone
		JLabel lblComAdd3 = new JLabel("03-8656 9488");
		lblComAdd3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd3.setBounds(34, 83, 315, 42);
		
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
		JLabel lblColumn2 = new JLabel("Year                        Amount");
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
		textArea.setBounds(44, 215, 770, 300);
                
                CRUD newCrud = new CRUD();
		tblData.clear();
		tblData = newCrud.read("ResidentInvoiceStatement.txt");
		String rowPayment[] = new String[5];
		String columnPayment[] = { "Id", "Type", "Type", "Outstanding", "Date" };



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
			tableModelPayment.addRow(rowPayment);

		}
		jTablePayment.setModel(tableModelPayment);

		
		JScrollPane scrollPayment = new JScrollPane(jTablePayment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPayment.setBounds(60, 73, 770, 100);
		viewInvoice.getContentPane().add(scrollPayment);
		
		// Scroll
		JScrollPane scroll = new JScrollPane (textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
				String type = (String) jTablePayment.getValueAt(row[0], 1);
				String type1 = (String) jTablePayment.getValueAt(row[0], 2);
				String outstanding = (String) jTablePayment.getValueAt(row[0], 3);
				String date = (String) jTablePayment.getValueAt(row[0], 4);

				String report = "<-------- Invoice/Statement -------->\n\n";
					
				report += "\nPayment Id: " + paymentID + "\n" + "Type: " + type + "\n" + "Type: " + type1 + "\n" + "Outstanding: RM" + outstanding + "\n" + "Date: " + date + "\n----------------------\n";
				JOptionPane.showMessageDialog(scroll, report);

				}
				

			}
		});
   
		viewInvoice.getContentPane().add(scroll);
		reportTypeOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
                            
				switch ((String) reportTypeOptions.getSelectedItem()) {
                                case "January":
					
					ArrayList<ArrayList<String>> statementData = crud.read("VendorInvoice.txt");

					String receiptReport = "";
					
					for (ArrayList<String> row : statementData) {

						if(row.get(3).equals("January")) {
						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
						lblSDate.setText("Date Issued:     2023-01-01");
						lblContract.setText("Due To:     2023-01-31");
						lblBalance.setText("Balance Due      " + row.get(5));
						lblInvNo.setText("Invoice No:     " + row.get(0));
						}
					}

					textArea.setText(receiptReport);
					textArea.add(lblStatement);
					textArea.add(lblSDate);
					textArea.add(lblInvNo);
					textArea.add(lblCompany);
					textArea.add(lblComAdd);
					textArea.add(lblComAdd2);
					textArea.add(lblComAdd3);
					textArea.add(lblBill);
					textArea.add(lblContract);
					textArea.add(lblColumn);
					textArea.add(lblColumn2);
					textArea.add(lblBalance);
					textArea.add(lblRemittance);
					textArea.add(lblToDate);
					break;
                                    
          		
				case "February":
					
					statementData = crud.read("VendorInvoice.txt");

					receiptReport = "";
					
					for (ArrayList<String> row : statementData) {
						if(row.get(3).equals("February")) {
							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
							lblSDate.setText("Date Issued:     2023-02-01");
							lblContract.setText("Due To:     2023-02-28");
							lblBalance.setText("Balance Due      " + row.get(5));
							lblInvNo.setText("Invoice No:     " + row.get(0));
						}
					}

					textArea.setText(receiptReport);
					textArea.add(lblStatement);
					textArea.add(lblSDate);
					textArea.add(lblCompany);
					textArea.add(lblComAdd);
					textArea.add(lblComAdd2);
					textArea.add(lblComAdd3);
					textArea.add(lblBill);
					textArea.add(lblContract);
					textArea.add(lblColumn);
					textArea.add(lblColumn2);
					textArea.add(lblBalance);
					textArea.add(lblRemittance);
					textArea.add(lblToDate);
					textArea.add(lblInvNo);

					break;
					
                                case "March":
					
					statementData = crud.read("VendorInvoice.txt");

					receiptReport = "";
					
					for (ArrayList<String> row : statementData) {
						if(row.get(3).equals("March")) {
							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
							lblSDate.setText("Date Issued:     2023-03-01");
							lblContract.setText("Due To:     2023-03-31");
							lblBalance.setText("Balance Due      " + row.get(5));
							lblInvNo.setText("Invoice No:     " + row.get(0));
						}
					}

					textArea.setText(receiptReport);
					textArea.add(lblStatement);
					textArea.add(lblSDate);
					textArea.add(lblCompany);
					textArea.add(lblComAdd);
					textArea.add(lblComAdd2);
					textArea.add(lblComAdd3);
					textArea.add(lblBill);
					textArea.add(lblContract);
					textArea.add(lblColumn);
					textArea.add(lblColumn2);
					textArea.add(lblBalance);
					textArea.add(lblRemittance);
					textArea.add(lblToDate);
					textArea.add(lblInvNo);
					break;
					
                    case "April":
    					
    					statementData = crud.read("VendorInvoice.txt");

    					receiptReport = "";
    					
    					for (ArrayList<String> row : statementData) {
    						if(row.get(3).equals("April")) {
    							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
    							lblSDate.setText("Date Issued:     2023-04-01");
    							lblContract.setText("Due To:     2023-04-30");
    							lblBalance.setText("Balance Due      " + row.get(5));
    							lblInvNo.setText("Invoice No:     " + row.get(0));
    						}
    					}

    					textArea.setText(receiptReport);
    					textArea.add(lblStatement);
    					textArea.add(lblSDate);
    					textArea.add(lblCompany);
    					textArea.add(lblComAdd);
    					textArea.add(lblComAdd2);
    					textArea.add(lblComAdd3);
    					textArea.add(lblBill);
    					textArea.add(lblContract);
    					textArea.add(lblColumn);
    					textArea.add(lblColumn2);
    					textArea.add(lblBalance);
    					textArea.add(lblRemittance);
    					textArea.add(lblToDate);
    					textArea.add(lblInvNo);
    					break;
    					
                        case "May":
    					
    					statementData = crud.read("VendorInvoice.txt");

    					receiptReport = "";
    					
    					for (ArrayList<String> row : statementData) {
    						if(row.get(3).equals("May")) {
    							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
    							lblSDate.setText("Date Issued:     2023-05-01");
    							lblContract.setText("Due To:     2023-05-31");
    							lblBalance.setText("Balance Due      " + row.get(5));
    							lblInvNo.setText("Invoice No:     " + row.get(0));
    						}
    					}

    					textArea.setText(receiptReport);
    					textArea.add(lblStatement);
    					textArea.add(lblSDate);
    					textArea.add(lblCompany);
    					textArea.add(lblComAdd);
    					textArea.add(lblComAdd2);
    					textArea.add(lblComAdd3);
    					textArea.add(lblBill);
    					textArea.add(lblContract);
    					textArea.add(lblColumn);
    					textArea.add(lblColumn2);
    					textArea.add(lblBalance);
    					textArea.add(lblRemittance);
    					textArea.add(lblToDate);
    					textArea.add(lblInvNo);
    					break;
    					
                        case "June":
        					
        					statementData = crud.read("VendorInvoice.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("June")) {
        							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        							lblSDate.setText("Date Issued:     2023-06-01");
        							lblContract.setText("Due To:     2023-06-30");
        							lblBalance.setText("Balance Due      " + row.get(5));
        							lblInvNo.setText("Invoice No:     " + row.get(0));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblToDate);
        					textArea.add(lblInvNo);
        					break;
        					
                        case "July":
        					
        					statementData = crud.read("VendorInvoice.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("July")) {
        							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        							lblSDate.setText("Date Issued:     2023-07-01");
        							lblContract.setText("Due To:     2023-07-31");
        							lblBalance.setText("Balance Due      " + row.get(5));
        							lblInvNo.setText("Invoice No:     " + row.get(0));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblToDate);
        					textArea.add(lblInvNo);
        					break;
        					
                        case "August":
        					
        					statementData = crud.read("VendorInvoice.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("August")) {
        							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        							lblSDate.setText("Date Issued:     2023-08-01");
        							lblContract.setText("Due To:     2023-08-31");
        							lblBalance.setText("Balance Due      " + row.get(5));
        							lblInvNo.setText("Invoice No:     " + row.get(0));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblToDate);
        					textArea.add(lblInvNo);
        					break;
        					
                        case "September":
        					
        					statementData = crud.read("VendorInvoice.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("September")) {
        							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        							lblSDate.setText("Date Issued:     2023-09-01");
        							lblContract.setText("Due To:     2023-09-30");
        							lblBalance.setText("Balance Due      " + row.get(5));
        							lblInvNo.setText("Invoice No:     " + row.get(0));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblToDate);
        					textArea.add(lblInvNo);
        					break;
        					
                        case "October":
        					
        					statementData = crud.read("VendorInvoice.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("October")) {
        							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        							lblSDate.setText("Date Issued:     2023-10-01");
        							lblContract.setText("Due To:     2023-10-31");
        							lblBalance.setText("Balance Due      " + row.get(5));
        							lblInvNo.setText("Invoice No:     " + row.get(0));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblToDate);
        					textArea.add(lblInvNo);
        					break;
        					
                        case "November":
        					
        					statementData = crud.read("VendorInvoice.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("November")) {
        							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        							lblSDate.setText("Date Issued:     2023-11-01");
        							lblContract.setText("Due To:     2023-11-30");
        							lblBalance.setText("Balance Due      " + row.get(5));
        							lblInvNo.setText("Invoice No:     " + row.get(0));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblToDate);
        					textArea.add(lblInvNo);
        					break;
        					
                        case "December":
        					
        					statementData = crud.read("VendorInvoice.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("December")) {
        							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        							lblSDate.setText("Date Issued:     2023-12-01");
        							lblContract.setText("Due To:     2023-12-31");
        							lblBalance.setText("Balance Due      " + row.get(5));
        							lblInvNo.setText("Invoice No:     " + row.get(0));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblToDate);
        					textArea.add(lblInvNo);
        					break;
                                }
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
