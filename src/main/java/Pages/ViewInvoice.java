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
		lblNewLabel.setBounds(34, 11, 665, 81);
		viewInvoice.getContentPane().add(lblNewLabel);

		
		

		CRUD newCrud = new CRUD();
		tblData.clear();
		tblData = newCrud.read("Payment.txt");
		String rowPayment[] = new String[7];
		String columnPayment[] = { "Id", "Name", "Detail", "Payment", "Role", "Debt ID", "Date" };

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
			tableModelPayment.addRow(rowPayment);

		}
		jTablePayment.setModel(tableModelPayment);

		
		JScrollPane scrollPayment = new JScrollPane(jTablePayment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPayment.setBounds(44, 73, 770, 100);
		viewInvoice.getContentPane().add(scrollPayment);
		
		
		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 200, 770, 300);


		// Scroll
		JScrollPane scroll = new JScrollPane (textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 200, 770, 300);
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
				String detail = (String) jTablePayment.getValueAt(row[0], 2);
				String payment = (String) jTablePayment.getValueAt(row[0], 3);
				String role = (String) jTablePayment.getValueAt(row[0], 4);
				String debtID = (String) jTablePayment.getValueAt(row[0], 5);
				String date = (String) jTablePayment.getValueAt(row[0], 6);


				String report = "<-------- Invoice/Receipt -------->\n\n";
					
				report += "\nPayment Id: " + paymentID + "\n" + "Name: " + name + "\n" + "Detail: " + detail + "\n" + "Payment: RM" + payment + "\n" + "Role: " + role + "\n"+ "Date: " + date + "\n----------------------\n";
				textArea.setText(report);

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
