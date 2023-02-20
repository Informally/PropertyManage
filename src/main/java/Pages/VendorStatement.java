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

public class VendorStatement extends PageUtils{

	public JFrame vs;
	public CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorStatement window = new VendorStatement();
					window.vs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendorStatement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		vs = new JFrame();
		vs.setTitle("Vendor Statement");
		vs.setBounds(100, 100, 871, 822);
		vs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vs.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Vendor Statement");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		vs.getContentPane().add(lblNewLabel);

		// Month
		JLabel lblMonth = new JLabel("Month: ");
		lblMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblMonth.setBounds(44, 73, 315, 42);
		vs.getContentPane().add(lblMonth);

		JComboBox<String> reportOptions = new JComboBox<>();
		reportOptions.setBounds(120, 73, 250, 42);
		reportOptions.addItem("January");
		reportOptions.addItem("February");
		reportOptions.addItem("March");
		reportOptions.addItem("April");
		reportOptions.addItem("May");
		reportOptions.addItem("June");
		reportOptions.addItem("July");
		reportOptions.addItem("August");
		reportOptions.addItem("September");
		reportOptions.addItem("October");
		reportOptions.addItem("November");
		reportOptions.addItem("December");
		vs.getContentPane().add(reportOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);
		
		// Statement
		JLabel lblStatement = new JLabel("STATEMENT ");
		lblStatement.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		lblStatement.setBounds(564, 3, 315, 42);
		
		// Statement Date
		JLabel lblSDate = new JLabel("Statement Date");
		lblSDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSDate.setBounds(564, 33, 315, 42);
		
		// Customer ID
		//JLabel lblCusId = new JLabel("Customer ID ");
		//lblCusId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		//lblCusId.setBounds(564, 53, 315, 42);
		
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
		
		//Block
		JLabel lblBlock = new JLabel("Block:");
		lblBlock.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBlock.setBounds(434, 123, 315, 42);
		
		//Contract
		JLabel lblContract = new JLabel("Contract From: 2023-01-01");
		lblContract.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblContract.setBounds(384, 143, 315, 42);

		
		//To Date
		JLabel lblToDate = new JLabel("To: 2023-12-31");
		lblToDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblToDate.setBounds(454, 163, 315, 42);
		
		//Label Column
		JLabel lblColumn = new JLabel("Date                          Description                         Month");
		lblColumn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColumn.setBounds(34, 193, 315, 42);
		
		//Label Column2
		JLabel lblColumn2 = new JLabel("Year                        Amount");
		lblColumn2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColumn2.setBounds(375, 193, 315, 42);
		
		//Label Balance
		JLabel lblBalance = new JLabel("Balance Due");
		lblBalance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBalance.setBounds(375, 273, 315, 42);
		
		//Label Remittance
		JLabel lblRemittance = new JLabel("REMITTANCE");
		lblRemittance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblRemittance.setBounds(265, 303, 315, 42);
		
		//Label Payment
		JLabel lblPayment = new JLabel("Please make payment to Parkhill Resident:");
		lblPayment.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPayment.setBounds(34, 343, 315, 42);
		
		// Company
		JLabel lblCompany2 = new JLabel("Parkhill Resident");
		lblCompany2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCompany2.setBounds(34, 363, 315, 42);
				
		//Company Address
		JLabel lblComAdd4 = new JLabel("2, 217, Technology Park Malaysia,");
		lblComAdd4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd4.setBounds(34, 383, 315, 42);
				
		//Company Address
		JLabel lblComAdd5 = new JLabel("57000 Kuala Lumpur,Wilayah Kuala Lumpur");
		lblComAdd5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd5.setBounds(34, 403, 315, 42);
				
		//Company Phone
		JLabel lblComAdd6 = new JLabel("03-8656 9488");
		lblComAdd6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblComAdd6.setBounds(34, 423, 315, 42);
		
		// Statement Date
		JLabel lblDate = new JLabel("STATEMENT DATE");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDate.setBounds(365, 363, 315, 42);
		
		// Due Date
		JLabel lblDue = new JLabel("DUE DATE");
		lblDue.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDue.setBounds(413, 383, 315, 42);
				
		// Statement Date
		JLabel lblBalanceDue = new JLabel("BALANCE DUE");
		lblBalanceDue.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBalanceDue.setBounds(385, 403, 315, 42);
				
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 530);
		vs.getContentPane().add(scroll);

		reportOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) reportOptions.getSelectedItem()) {
				
                    case "January":
					
					ArrayList<ArrayList<String>> statementData = crud.read("VendorStatement.txt");

					String receiptReport = "";
					
					for (ArrayList<String> row : statementData) {
						if(row.get(3).equals("January")) {
						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
						lblSDate.setText("Statement Date     2023-01-01");	
						lblDate.setText("STATEMENT DATE           2023-01-01");
						lblDue.setText("DUE DATE           2023-01-31");
						lblBalance.setText("Balance Due          " + row.get(5));
						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
						}
					}

					textArea.setText(receiptReport);
					textArea.add(lblStatement);
					textArea.add(lblSDate);
					textArea.add(lblCompany);
					textArea.add(lblComAdd);
					textArea.add(lblComAdd2);
					textArea.add(lblComAdd3);
					textArea.add(lblComAdd4);
					textArea.add(lblBill);
					textArea.add(lblContract);
					textArea.add(lblDue);
					textArea.add(lblColumn);
					textArea.add(lblColumn2);
					textArea.add(lblBalance);
					textArea.add(lblRemittance);
					textArea.add(lblBalanceDue);
					textArea.add(lblPayment);
					textArea.add(lblCompany2);
					textArea.add(lblComAdd4);
					textArea.add(lblComAdd5);
					textArea.add(lblComAdd6);
					textArea.add(lblDate);
					textArea.add(lblToDate);
					break;
				
				case "February":
					
					statementData = crud.read("VendorStatement.txt");

					receiptReport = "";
					
					for (ArrayList<String> row : statementData) {
						if(row.get(3).equals("February")) {
						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
						lblSDate.setText("Statement Date     2023-02-01");	
						lblDate.setText("STATEMENT DATE           2023-02-01");
						lblDue.setText("DUE DATE           2023-02-28");
						lblBalance.setText("Balance Due          " + row.get(5));
						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
						}
					}

					textArea.setText(receiptReport);
					textArea.add(lblStatement);
					textArea.add(lblSDate);
					textArea.add(lblCompany);
					textArea.add(lblComAdd);
					textArea.add(lblComAdd2);
					textArea.add(lblComAdd3);
					textArea.add(lblComAdd4);
					textArea.add(lblBill);
					textArea.add(lblContract);
					textArea.add(lblDue);
					textArea.add(lblColumn);
					textArea.add(lblColumn2);
					textArea.add(lblBalance);
					textArea.add(lblRemittance);
					textArea.add(lblBalanceDue);
					textArea.add(lblPayment);
					textArea.add(lblCompany2);
					textArea.add(lblComAdd4);
					textArea.add(lblComAdd5);
					textArea.add(lblComAdd6);
					textArea.add(lblDate);
					textArea.add(lblToDate);
					break;
					
                    case "March":
					
					statementData = crud.read("VendorStatement.txt");

					receiptReport = "";
					
					for (ArrayList<String> row : statementData) {
						if(row.get(3).equals("March")) {
							receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
						lblSDate.setText("Statement Date     2023-03-01");	
						lblDate.setText("STATEMENT DATE           2023-03-01");
						lblDue.setText("DUE DATE           2023-03-31");
						lblBalance.setText("Balance Due          " + row.get(5));
						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
						}
					}

					textArea.setText(receiptReport);
					textArea.add(lblStatement);
					textArea.add(lblSDate);
					textArea.add(lblCompany);
					textArea.add(lblComAdd);
					textArea.add(lblComAdd2);
					textArea.add(lblComAdd3);
					textArea.add(lblComAdd4);
					textArea.add(lblBill);
					textArea.add(lblContract);
					textArea.add(lblDue);
					textArea.add(lblColumn);
					textArea.add(lblColumn2);
					textArea.add(lblBalance);
					textArea.add(lblRemittance);
					textArea.add(lblBalanceDue);
					textArea.add(lblPayment);
					textArea.add(lblCompany2);
					textArea.add(lblComAdd4);
					textArea.add(lblComAdd5);
					textArea.add(lblComAdd6);
					textArea.add(lblDate);
					textArea.add(lblToDate);
					break;
					
                    case "April":
    					
    					statementData = crud.read("VendorStatement.txt");

    					receiptReport = "";
    					
    					for (ArrayList<String> row : statementData) {
    						if(row.get(3).equals("April")) {
    						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
    						lblSDate.setText("Statement Date     2023-04-01");	
    						lblDate.setText("STATEMENT DATE           2023-04-01");
    						lblDue.setText("DUE DATE           2023-04-30");
    						lblBalance.setText("Balance Due          " + row.get(5));
    						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
    						}
    					}

    					textArea.setText(receiptReport);
    					textArea.add(lblStatement);
    					textArea.add(lblSDate);
    					textArea.add(lblCompany);
    					textArea.add(lblComAdd);
    					textArea.add(lblComAdd2);
    					textArea.add(lblComAdd3);
    					textArea.add(lblComAdd4);
    					textArea.add(lblBill);
    					textArea.add(lblContract);
    					textArea.add(lblDue);
    					textArea.add(lblColumn);
    					textArea.add(lblColumn2);
    					textArea.add(lblBalance);
    					textArea.add(lblRemittance);
    					textArea.add(lblBalanceDue);
    					textArea.add(lblPayment);
    					textArea.add(lblCompany2);
    					textArea.add(lblComAdd4);
    					textArea.add(lblComAdd5);
    					textArea.add(lblComAdd6);
    					textArea.add(lblDate);
    					textArea.add(lblToDate);
    					break;
    					
                        case "May":
    					
    					statementData = crud.read("VendorStatement.txt");

    					receiptReport = "";
    					
    					for (ArrayList<String> row : statementData) {
    						if(row.get(3).equals("May")) {
    						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
    						lblSDate.setText("Statement Date     2023-05-01");	
    						lblDate.setText("STATEMENT DATE           2023-05-01");
    						lblDue.setText("DUE DATE           2023-05-31");
    						lblBalance.setText("Balance Due          " + row.get(5));
    						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
    						}
    					}

    					textArea.setText(receiptReport);
    					textArea.add(lblStatement);
    					textArea.add(lblSDate);
    					textArea.add(lblCompany);
    					textArea.add(lblComAdd);
    					textArea.add(lblComAdd2);
    					textArea.add(lblComAdd3);
    					textArea.add(lblComAdd4);
    					textArea.add(lblBill);
    					textArea.add(lblContract);
    					textArea.add(lblDue);
    					textArea.add(lblColumn);
    					textArea.add(lblColumn2);
    					textArea.add(lblBalance);
    					textArea.add(lblRemittance);
    					textArea.add(lblBalanceDue);
    					textArea.add(lblPayment);
    					textArea.add(lblCompany2);
    					textArea.add(lblComAdd4);
    					textArea.add(lblComAdd5);
    					textArea.add(lblComAdd6);
    					textArea.add(lblDate);
    					textArea.add(lblToDate);
    					break;
    					
                        case "June":
        					
        					statementData = crud.read("VendorStatement.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("June")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        						lblSDate.setText("Statement Date     2023-06-01");	
        						lblDate.setText("STATEMENT DATE           2023-06-01");
        						lblDue.setText("DUE DATE           2023-06-30");
        						lblBalance.setText("Balance Due          " + row.get(5));
        						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblComAdd4);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblDue);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblBalanceDue);
        					textArea.add(lblPayment);
        					textArea.add(lblCompany2);
        					textArea.add(lblComAdd4);
        					textArea.add(lblComAdd5);
        					textArea.add(lblComAdd6);
        					textArea.add(lblDate);
        					textArea.add(lblToDate);
        					break;
        					
                        case "July":
        					
        					statementData = crud.read("VendorStatement.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("July")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        						lblSDate.setText("Statement Date     2023-07-01");	
        						lblDate.setText("STATEMENT DATE           2023-07-01");
        						lblDue.setText("DUE DATE           2023-07-31");
        						lblBalance.setText("Balance Due          " + row.get(5));
        						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblComAdd4);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblDue);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblBalanceDue);
        					textArea.add(lblPayment);
        					textArea.add(lblCompany2);
        					textArea.add(lblComAdd4);
        					textArea.add(lblComAdd5);
        					textArea.add(lblComAdd6);
        					textArea.add(lblDate);
        					textArea.add(lblToDate);
        					break;
        					
                        case "August":
        					
        					statementData = crud.read("VendorStatement.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("August")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        						lblSDate.setText("Statement Date     2023-08-01");	
        						lblDate.setText("STATEMENT DATE           2023-08-01");
        						lblDue.setText("DUE DATE           2023-08-31");
        						lblBalance.setText("Balance Due          " + row.get(5));
        						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblComAdd4);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblDue);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblBalanceDue);
        					textArea.add(lblPayment);
        					textArea.add(lblCompany2);
        					textArea.add(lblComAdd4);
        					textArea.add(lblComAdd5);
        					textArea.add(lblComAdd6);
        					textArea.add(lblDate);
        					textArea.add(lblToDate);
        					break;
        					
                        case "September":
        					
        					statementData = crud.read("VendorStatement.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("September")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        						lblSDate.setText("Statement Date     2023-09-01");	
        						lblDate.setText("STATEMENT DATE           2023-09-01");
        						lblDue.setText("DUE DATE           2023-09-30");
        						lblBalance.setText("Balance Due          " + row.get(5));
        						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblComAdd4);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblDue);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblBalanceDue);
        					textArea.add(lblPayment);
        					textArea.add(lblCompany2);
        					textArea.add(lblComAdd4);
        					textArea.add(lblComAdd5);
        					textArea.add(lblComAdd6);
        					textArea.add(lblDate);
        					textArea.add(lblToDate);
        					break;
        					
                        case "October":
        					
        					statementData = crud.read("VendorStatement.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("October")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        						lblSDate.setText("Statement Date     2023-10-01");	
        						lblDate.setText("STATEMENT DATE           2023-10-01");
        						lblDue.setText("DUE DATE           2023-10-31");
        						lblBalance.setText("Balance Due          " + row.get(5));
        						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblComAdd4);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblDue);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblBalanceDue);
        					textArea.add(lblPayment);
        					textArea.add(lblCompany2);
        					textArea.add(lblComAdd4);
        					textArea.add(lblComAdd5);
        					textArea.add(lblComAdd6);
        					textArea.add(lblDate);
        					textArea.add(lblToDate);
        					break;
        					
                        case "November":
        					
        					statementData = crud.read("VendorStatement.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("November")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        						lblSDate.setText("Statement Date     2023-11-01");	
        						lblDate.setText("STATEMENT DATE           2023-11-01");
        						lblDue.setText("DUE DATE           2023-11-30");
        						lblBalance.setText("Balance Due          " + row.get(5));
        						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblComAdd4);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblDue);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblBalanceDue);
        					textArea.add(lblPayment);
        					textArea.add(lblCompany2);
        					textArea.add(lblComAdd4);
        					textArea.add(lblComAdd5);
        					textArea.add(lblComAdd6);
        					textArea.add(lblDate);
        					textArea.add(lblToDate);
        					break;
        					
                        case "December":
        					
        					statementData = crud.read("VendorStatement.txt");

        					receiptReport = "";
        					
        					for (ArrayList<String> row : statementData) {
        						if(row.get(3).equals("December")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t " + row.get(4) + "\t           " + row.get(5);
        						lblSDate.setText("Statement Date     2023-12-01");	
        						lblDate.setText("STATEMENT DATE           2023-12-01");
        						lblDue.setText("DUE DATE           2023-12-31");
        						lblBalance.setText("Balance Due          " + row.get(5));
        						lblBalanceDue.setText("BALANCE DUE           " + row.get(5));
        						}
        					}

        					textArea.setText(receiptReport);
        					textArea.add(lblStatement);
        					textArea.add(lblSDate);
        					textArea.add(lblCompany);
        					textArea.add(lblComAdd);
        					textArea.add(lblComAdd2);
        					textArea.add(lblComAdd3);
        					textArea.add(lblComAdd4);
        					textArea.add(lblBill);
        					textArea.add(lblContract);
        					textArea.add(lblDue);
        					textArea.add(lblColumn);
        					textArea.add(lblColumn2);
        					textArea.add(lblBalance);
        					textArea.add(lblRemittance);
        					textArea.add(lblBalanceDue);
        					textArea.add(lblPayment);
        					textArea.add(lblCompany2);
        					textArea.add(lblComAdd4);
        					textArea.add(lblComAdd5);
        					textArea.add(lblComAdd6);
        					textArea.add(lblDate);
        					textArea.add(lblToDate);
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
				VendorPaymentHistoryMenu payHis = new VendorPaymentHistoryMenu();
                                setOriginalFrame(vs);
				setTargetedFrame(payHis.phm);
				navigatePage();

			}
		});
		vs.getContentPane().add(backBtn);

	}
	}
