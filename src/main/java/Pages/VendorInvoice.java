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

public class VendorInvoice extends PageUtils{

	public JFrame vi;
	public CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorInvoice window = new VendorInvoice(null);
					window.vi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendorInvoice(String vendorName) {
		initialize(vendorName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String vendorName) {
		vi = new JFrame();
		vi.setTitle("Vendor Invoice");
		vi.setBounds(100, 100, 871, 822);
		vi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vi.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Vendor Invoice");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		vi.getContentPane().add(lblNewLabel);

		// Month
		JLabel lblMonth = new JLabel("Month: ");
		lblMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblMonth.setBounds(44, 73, 315, 42);
		vi.getContentPane().add(lblMonth);

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
		vi.getContentPane().add(reportOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);
		
		// Invoice
		JLabel lblStatement = new JLabel("INVOICE ");
		lblStatement.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		lblStatement.setBounds(564, 3, 315, 42);
		
		// Date Issued
		JLabel lblSDate = new JLabel("Date Issued:");
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
		JLabel lblColumn2 = new JLabel("Year                        Amount");
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
		scroll.setBounds(0, 130, 1000, 530);
		vi.getContentPane().add(scroll);

		reportOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) reportOptions.getSelectedItem()) {
				
                    case "January":
					
					ArrayList<ArrayList<String>> statementData = crud.read("VendorInvoice.txt");

					String receiptReport = "";
					
					for (ArrayList<String> row : statementData) {
						if(row.get(4).equals("January")) {
						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
						lblSDate.setText("Date Issued:     2023-01-01");
						lblContract.setText("Due To:     2023-01-31");
						lblBalance.setText("Balance Due      " + row.get(6));
						lblInvNo.setText("Invoice No:     " + row.get(0));
                                                lblBill.setText("Bill To:    " + row.get(1));
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
						if(row.get(4).equals("February")) {
						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
						lblSDate.setText("Date Issued:     2023-02-01");
						lblContract.setText("Due To:     2023-02-28");
						lblBalance.setText("Balance Due      " + row.get(6));
						lblInvNo.setText("Invoice No:     " + row.get(0));
                                                lblBill.setText("Bill To:    " + row.get(1));
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
						if(row.get(4).equals("March")) {
						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
						lblSDate.setText("Date Issued:     2023-03-01");
						lblContract.setText("Due To:     2023-03-31");
						lblBalance.setText("Balance Due      " + row.get(6));
						lblInvNo.setText("Invoice No:     " + row.get(0));
                                                lblBill.setText("Bill To:    " + row.get(1));
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
    						if(row.get(4).equals("April")) {
    						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
						lblSDate.setText("Date Issued:     2023-04-01");
						lblContract.setText("Due To:     2023-04-30");
						lblBalance.setText("Balance Due      " + row.get(6));
						lblInvNo.setText("Invoice No:     " + row.get(0));
                                                lblBill.setText("Bill To:    " + row.get(1));
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
    						if(row.get(4).equals("May")) {
    						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
						lblSDate.setText("Date Issued:     2023-05-01");
						lblContract.setText("Due To:     2023-05-31");
						lblBalance.setText("Balance Due      " + row.get(6));
						lblInvNo.setText("Invoice No:     " + row.get(0));
                                                lblBill.setText("Bill To:    " + row.get(1));
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
        						if(row.get(4).equals("June")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
                                                        lblSDate.setText("Date Issued:     2023-06-01");
                                                        lblContract.setText("Due To:     2023-06-30");
                                                        lblBalance.setText("Balance Due      " + row.get(6));
                                                        lblInvNo.setText("Invoice No:     " + row.get(0));
                                                        lblBill.setText("Bill To:    " + row.get(1));
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
        						if(row.get(4).equals("July")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
                                                        lblSDate.setText("Date Issued:     2023-07-01");
                                                        lblContract.setText("Due To:     2023-07-31");
                                                        lblBalance.setText("Balance Due      " + row.get(6));
                                                        lblInvNo.setText("Invoice No:     " + row.get(0));
                                                        lblBill.setText("Bill To:    " + row.get(1));
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
        						if(row.get(4).equals("August")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
                                                        lblSDate.setText("Date Issued:     2023-08-01");
                                			lblContract.setText("Due To:     2023-08-31");
                                        		lblBalance.setText("Balance Due      " + row.get(6));
                                                	lblInvNo.setText("Invoice No:     " + row.get(0));
                                                        lblBill.setText("Bill To:    " + row.get(1));
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
        						if(row.get(4).equals("September")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
                                                        lblSDate.setText("Date Issued:     2023-09-01");
                                                        lblContract.setText("Due To:     2023-09-30");
                                                        lblBalance.setText("Balance Due      " + row.get(6));
                                                    	lblInvNo.setText("Invoice No:     " + row.get(0));
                                                        lblBill.setText("Bill To:    " + row.get(1));
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
        						if(row.get(4).equals("October")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
                                                	lblSDate.setText("Date Issued:     2023-10-01");
                                                	lblContract.setText("Due To:     2023-10-31");
                                                	lblBalance.setText("Balance Due      " + row.get(6));
                                                	lblInvNo.setText("Invoice No:     " + row.get(0));
                                                        lblBill.setText("Bill To:    " + row.get(1));
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
        						if(row.get(4).equals("November")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
                                                        lblSDate.setText("Date Issued:     2023-11-01");
                                                        lblContract.setText("Due To:     2023-11-30");
                                                        lblBalance.setText("Balance Due      " + row.get(6));
                                                        lblInvNo.setText("Invoice No:     " + row.get(0));
                                                        lblBill.setText("Bill To:    " + row.get(1));
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
        						if(row.get(4).equals("December")) {
        						receiptReport += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n          " + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t " + row.get(5) + "\t           " + row.get(6);
                                                	lblSDate.setText("Date Issued:     2023-12-01");
                                                    	lblContract.setText("Due To:     2023-12-31");
                                                        lblBalance.setText("Balance Due      " + row.get(6));
                                                	lblInvNo.setText("Invoice No:     " + row.get(0));
                                                        lblBill.setText("Bill To:    " + row.get(1));
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
				VendorPaymentHistoryMenu payHis = new VendorPaymentHistoryMenu(vendorName);
                                setOriginalFrame(vi);
				setTargetedFrame(payHis.phm);
				navigatePage();

			}
		});
		vi.getContentPane().add(backBtn);

	}
	}
