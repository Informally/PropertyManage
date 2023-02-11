package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Data.User;
import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ResidentPaymentHistoryMenu {

	public JFrame rphm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResidentPaymentHistoryMenu window = new ResidentPaymentHistoryMenu();
					window.rphm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResidentPaymentHistoryMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rphm = new JFrame();
		rphm.setTitle("Payment History Menu");
		rphm.setBounds(100, 100, 871, 622);
		rphm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rphm.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Payment History Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rphm.getContentPane().add(lblNewLabel);

		// Invoice Button
		JButton profileBtn = new JButton("Pending Fee");
		profileBtn.setBounds(44, 93, 315, 42);
		profileBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		profileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PendingFee pendingFee = new PendingFee();
				
				pendingFee.pf.setVisible(true);
				rphm.setVisible(false);
			}
		});
		rphm.getContentPane().add(profileBtn);

		// User Payment Button
		JButton paymentBtn = new JButton("Invoice");
		paymentBtn.setBounds(44, 153, 315, 42);
		paymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		paymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorInvoice vendorInvoice = new VendorInvoice();
				vendorInvoice.vi.setVisible(true);
				rphm.setVisible(false);

			}
		});
		rphm.getContentPane().add(paymentBtn);

		// Operation and budget planning Button
		JButton payHisBtn = new JButton("Statement");
		payHisBtn.setBounds(44, 213, 315, 42);
		payHisBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		payHisBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

                VendorStatement vendorStatement = new VendorStatement();
				vendorStatement.vs.setVisible(true);
				rphm.setVisible(false);

			}
		});
		rphm.getContentPane().add(payHisBtn);
		
		// Operation and budget planning Button
		JButton complaintBtn = new JButton("Receipt");
		complaintBtn.setBounds(44, 273, 315, 42);
		complaintBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		complaintBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VendorReceipt vendorReceipt = new VendorReceipt();
				vendorReceipt.vr.setVisible(true);
				rphm.setVisible(false);

			}
		});
		rphm.getContentPane().add(complaintBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Back");
		logOutBtn.setBounds(44, 333, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResidentMenu rm = new ResidentMenu();
				rm.rm.setVisible(true);
				rphm.setVisible(false);

			}
		});
		rphm.getContentPane().add(logOutBtn);



	}

}
