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

public class VendorReceipt extends PageUtils{

	public JFrame vr;
	public CRUD crud = new CRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorReceipt window = new VendorReceipt(null);
					window.vr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendorReceipt(String vendorName) {
		initialize(vendorName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String vendorName) {
		vr = new JFrame();
		vr.setTitle("Vendor Receipt");
		vr.setBounds(100, 100, 871, 622);
		vr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vr.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Vendor Receipt");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		vr.getContentPane().add(lblNewLabel);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 450);
		vr.getContentPane().add(scroll);
		
		ArrayList<ArrayList<String>> receiptData = crud.read("VendorReceipt.txt");

		String receiptReport = "\t\t<----- Receipt ----->\n";
		
		for (ArrayList<String> row : receiptData) {
			
			receiptReport += "\tPayment ID:" + row.get(0) + "\n\n\tDescription\t\t\tPrice\n\t---------------\t\t\t-------\n" + "\tName" + "\t\t\t" + row.get(1) + "\n"+ "\tRental" + "\t\t\t" + row.get(2) + "\n" + "\tUtilities" + "\t\t\t" + row.get(3) + "\n" + "\tServices" + "\t\t\t" + row.get(4) + "\n" + "\t---------------------------------------------------------------\n\tTotal Paid" + "\t\t\t" + row.get(5) + "\n"+ "\tPayment for " + row.get(6) + " " + row.get(7) + "\n" + "\tDate Paid " + row.get(8) + "\n\t---------------------------------------------------------------" + "\n" + "\t                  Thank you for your payment\n\n" + "\t\t<----- Receipt ----->\n";

		}

		textArea.setText(receiptReport);

		

		// Back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorPaymentHistoryMenu payHis = new VendorPaymentHistoryMenu(vendorName);
                                setOriginalFrame(vr);
				setTargetedFrame(payHis.phm);
				navigatePage();

			}
		});
		vr.getContentPane().add(backBtn);

	}
}

