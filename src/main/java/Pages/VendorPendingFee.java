package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class VendorPendingFee {

	public JFrame pf;
	public CRUD crud = new CRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorPendingFee window = new VendorPendingFee();
					window.pf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendorPendingFee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pf = new JFrame();
		pf.setTitle("Pending Fee");
		pf.setBounds(100, 100, 871, 622);
		pf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pf.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Pending Fee");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		pf.getContentPane().add(lblNewLabel);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 450);
		pf.getContentPane().add(scroll);
		
		ArrayList<ArrayList<String>> pendingData = crud.read("PendingFee.txt");

		String pendingReport = "\t\t<----- Pending Fee ----->\n";
		
		for (ArrayList<String> row : pendingData) {
			if(Integer.parseInt(row.get(4)) > 0) {
			pendingReport += "\tPending ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice\n\t---------------\t\t\t-------\n" + "\tRental" + "\t\t\t" + row.get(1) + "\n" + "\tUtilities" + "\t\t\t" + row.get(2) + "\n" + "\tServices" + "\t\t\t" + row.get(3) + "\n" + "\t---------------------------------------------------------------\n\tOutstanding" + "\t\t\t" + row.get(4) + "\n"+ "\tPending fee for " + row.get(5) + " " + row.get(6) + "\n\t---------------------------------------------------------------" + "\n\n" + "\t\t<----- Pending Fee ----->\n";
			}
		}

		textArea.setText(pendingReport);

		

		// Back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorPaymentHistoryMenu payHis = new VendorPaymentHistoryMenu();
				payHis.phm.setVisible(true);
				pf.setVisible(false);

			}
		});
		pf.getContentPane().add(backBtn);

	}
}
