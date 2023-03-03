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

public class ViewOutStanding2 extends PageUtils {

	public JFrame viewOutStanding2;
	public CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOutStanding2 window = new ViewOutStanding2();
					window.viewOutStanding2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewOutStanding2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		viewOutStanding2 = new JFrame();
		viewOutStanding2.setTitle("View Outstanding Fees Vendor");
		viewOutStanding2.setBounds(100, 100, 871, 622);
		viewOutStanding2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewOutStanding2.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("View Outstanding Fees Vendor");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		viewOutStanding2.getContentPane().add(lblNewLabel);

	
	
		/*CRUD newCrud = new CRUD();
		tblData.clear();
		tblData = newCrud.read("PaymentHistory.txt");
		String rowPayment[] = new String[8];
		String columnPayment[] = { "Id", "Name", "Outstanding", "Total Paid", "Month", "Year", "Payment ID", "Date"};

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
			rowPayment[6] = tblData.get(i).get(6);
                        rowPayment[7] = tblData.get(i).get(7);
			tableModelPayment.addRow(rowPayment);

		}
		jTablePayment.setModel(tableModelPayment);

		
		JScrollPane scrollPayment = new JScrollPane(jTablePayment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPayment.setBounds(44, 73, 770, 100);
		viewOutStanding2.getContentPane().add(scrollPayment);*/
		
		
		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 200, 770, 300);


		/* Scroll
		JScrollPane scroll = new JScrollPane (textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 200, 770, 300);
		viewOutStanding2.getContentPane().add(scroll);

		ListSelectionModel selectPayment = jTablePayment.getSelectionModel();
		selectPayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectPayment.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row = jTablePayment.getSelectedRows();
				int columnNum = jTablePayment.getColumnCount();
                                
				if (row.length > 0) {
                                
                                String uid = jTablePayment.getValueAt(row[0], 0).toString();
				String name = jTablePayment.getValueAt(row[0], 1).toString();
				String out = jTablePayment.getValueAt(row[0], 2).toString();
				String paid = jTablePayment.getValueAt(row[0], 3).toString();
				String Month = jTablePayment.getValueAt(row[0], 4).toString();
                                String Year = jTablePayment.getValueAt(row[0], 5).toString();
				String dtf = jTablePayment.getValueAt(row[0], 7).toString();

				String report = "<-------- Invoice for Outstanding payment -------->\n";
					
				report += "\n Payment ID: " + uid + "\n" + "Name: " + name + "\n" + "Outstanding: " + out + "\n" + "Total Paid: " + paid + "\n" + "Month: " + Month + "\n" + "Year: " + Year + "\n" + "Date: " + dtf + "\n----------------------\n";
                                textArea.setText(report);

				}
				

			}
		});*/
                JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 450);
		viewOutStanding2.getContentPane().add(scroll);
		
		ArrayList<ArrayList<String>> pendingData = crud.read("PendingFee.txt");

		String pendingReport = "<--------------- Pending Fee --------------->\n";

		for (ArrayList<String> row : pendingData) {
			pendingReport += "\nCharge ID: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Details: " + row.get(2) + "\n" + "Pending Fee: RM" + row.get(3) + "\n" + "Date: " +  row.get(4) + "\n" + "---------------------------------------------------------------"+ "\n---------------------------------------------------------------\n";
		}
	
		// for (ArrayList<String> row : pendingData) {
		// 	if (row.get(0).equals(id)) {
		// 	pendingReport += "\tPending ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice(RM)\n\t---------------\t\t\t-----------\n" + "\tName" + "\t\t\t" + row.get(1) + "\n" + "\tRental" + "\t\t\t" + row.get(2) + "\n" + "\tUtilities" + "\t\t\t" + row.get(3) + "\n" + "\tServices" + "\t\t\t" + row.get(4) + "\n" + "\t---------------------------------------------------------------\n\tOutstanding" + "\t\t\t" + row.get(5) + "\n"+ "\tPending fee for " + row.get(6) + " " + row.get(7) + "\n\t---------------------------------------------------------------" + "\n\n" + "\t\t<----- Pending Fee ----->\n";
		// 	}
		// }

		textArea.setText(pendingReport);
		
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AccountExecMenu acctmenu = new AccountExecMenu();
				setOriginalFrame(viewOutStanding2);
				setTargetedFrame(acctmenu.aem);
				navigatePage();

			}
		});
		viewOutStanding2.getContentPane().add(backBtn);
		
	}
}
