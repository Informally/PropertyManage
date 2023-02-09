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

public class ViewOutStanding {

	public JFrame viewOutStanding;
	public CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOutStanding window = new ViewOutStanding();
					window.viewOutStanding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewOutStanding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		viewOutStanding = new JFrame();
		viewOutStanding.setTitle("View Outstanding Fees");
		viewOutStanding.setBounds(100, 100, 871, 622);
		viewOutStanding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewOutStanding.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("View Outstanding Fees");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		viewOutStanding.getContentPane().add(lblNewLabel);

		
		

		CRUD newCrud = new CRUD();
		tblData.clear();
		tblData = newCrud.read("Debt.txt");
		String rowPayment[] = new String[5];
		String columnPayment[] = { "Id", "Name", "Detail", "Debt", "Role"};

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
		scrollPayment.setBounds(44, 73, 770, 100);
		viewOutStanding.getContentPane().add(scrollPayment);
		
		
		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 200, 770, 300);


		// Scroll
		JScrollPane scroll = new JScrollPane (textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 200, 770, 300);
		viewOutStanding.getContentPane().add(scroll);

		ListSelectionModel selectPayment = jTablePayment.getSelectionModel();
		selectPayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectPayment.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row = jTablePayment.getSelectedRows();
				int columnNum = jTablePayment.getColumnCount();

				if (row.length > 0) {

				String debtId = (String) jTablePayment.getValueAt(row[0], 0);
				String name = (String) jTablePayment.getValueAt(row[0], 1);
				String detail = (String) jTablePayment.getValueAt(row[0], 2);
				String debt = (String) jTablePayment.getValueAt(row[0], 3);
				String role = (String) jTablePayment.getValueAt(row[0], 4);


				String report = "<-------- Invoice for Outstanding payment -------->\n";
					
				report += "\n Debt Id: " + debtId + "\n" + "Name: " + name + "\n" + "Detail: " + detail + "\n" + "Debt: RM" + debt + "\n" + "Role: " + role + "\n----------------------\n";
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
				acctmenu.aem.setVisible(true);
				viewOutStanding.setVisible(false);

			}
		});
		viewOutStanding.getContentPane().add(backBtn);
		

	}
}
