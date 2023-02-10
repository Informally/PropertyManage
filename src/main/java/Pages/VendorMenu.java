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

public class VendorMenu {

	public JFrame vm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorMenu window = new VendorMenu();
					window.vm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendorMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		vm = new JFrame();
		vm.setTitle("Vendor Menu");
		vm.setBounds(100, 100, 871, 622);
		vm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vm.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Vendor Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		vm.getContentPane().add(lblNewLabel);

/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// User Profile Button
		JButton profileBtn = new JButton("User Profile");
		profileBtn.setBounds(44, 93, 315, 42);
		profileBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		profileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorProfile vendorProfile = new VendorProfile();
				
				vendorProfile.vp.setVisible(true);
				vm.setVisible(false);
			}
		});
		vm.getContentPane().add(profileBtn);

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
		// User Payment Button
		JButton paymentBtn = new JButton("Payment");
		paymentBtn.setBounds(44, 153, 315, 42);
		paymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		paymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorPayment vendorPayment = new VendorPayment();
				vendorPayment.vp.setVisible(true);
				vm.setVisible(false);

			}
		});
		vm.getContentPane().add(paymentBtn);

		// Operation and budget planning Button
		JButton payHisBtn = new JButton("Payment History");
		payHisBtn.setBounds(44, 213, 315, 42);
		payHisBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		payHisBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				PaymentHistoryMenu paymentHistoryMenu = new PaymentHistoryMenu();
				paymentHistoryMenu.phm.setVisible(true);
				vm.setVisible(false);

			}
		});
		vm.getContentPane().add(payHisBtn);
		
		// Operation and budget planning Button
		JButton complaintBtn = new JButton("Complaint");
		complaintBtn.setBounds(44, 273, 315, 42);
		complaintBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		complaintBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VendorComplaint vendorComplaint = new VendorComplaint();
				vendorComplaint.vc.setVisible(true);
				vm.setVisible(false);

			}
		});
		vm.getContentPane().add(complaintBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 333, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login loginpage = new Login();
				loginpage.loginPage.setVisible(true);
				vm.setVisible(false);

			}
		});
		vm.getContentPane().add(logOutBtn);



	}

}