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

public class VendorPaymentHistoryMenu extends PageUtils {

	public JFrame phm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorPaymentHistoryMenu window = new VendorPaymentHistoryMenu(null);
					window.phm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendorPaymentHistoryMenu(String vendorName) {
		initialize(vendorName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String vendorName) {
		phm = new JFrame();
		phm.setTitle("Payment History Menu");
		phm.setBounds(100, 100, 871, 622);
		phm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		phm.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Payment History Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		phm.getContentPane().add(lblNewLabel);

		// Pending Fee Button
		JButton profileBtn = new JButton("Pending Fee");
		profileBtn.setBounds(44, 93, 315, 42);
		profileBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		profileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorPendingFee pendingFee = new VendorPendingFee(vendorName);
				
				pendingFee.pf.setVisible(true);
				phm.setVisible(false);
			}
		});
		phm.getContentPane().add(profileBtn);

		// Invoice Button
		JButton paymentBtn = new JButton("Invoice");
		paymentBtn.setBounds(44, 153, 315, 42);
		paymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		paymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorInvoice vendorInvoice = new VendorInvoice(vendorName);
				vendorInvoice.vi.setVisible(true);
				phm.setVisible(false);

			}
		});
		phm.getContentPane().add(paymentBtn);

		// Statement Button
		JButton payHisBtn = new JButton("Statement");
		payHisBtn.setBounds(44, 213, 315, 42);
		payHisBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		payHisBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

                VendorStatement vendorStatement = new VendorStatement(vendorName);
				vendorStatement.vs.setVisible(true);
				phm.setVisible(false);

			}
		});
		phm.getContentPane().add(payHisBtn);
		
		// Receipt Button
		JButton complaintBtn = new JButton("Receipt");
		complaintBtn.setBounds(44, 273, 315, 42);
		complaintBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		complaintBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VendorReceipt vendorReceipt = new VendorReceipt(vendorName);
				vendorReceipt.vr.setVisible(true);
				phm.setVisible(false);

			}
		});
		phm.getContentPane().add(complaintBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Back");
		logOutBtn.setBounds(44, 333, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VendorMenu vm = new VendorMenu(vendorName);
                                setOriginalFrame(phm);
				setTargetedFrame(vm.vm);
				navigatePage();

			}
		});
		phm.getContentPane().add(logOutBtn);



	}

}
